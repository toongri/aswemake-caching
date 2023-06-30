package toongri.blog.dbcacheproject.point.adapter.out.persistance;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import toongri.blog.dbcacheproject.point.application.port.out.LoadAccumulatePolicyPort;
import toongri.blog.dbcacheproject.point.domain.AccumulatePolicy;
import toongri.blog.dbcacheproject.point.domain.Order;
import toongri.blog.dbcacheproject.rds.user.UserJpa;
import toongri.blog.dbcacheproject.rds.grade.GradeJpaRepository;
import toongri.blog.dbcacheproject.rds.user.UserJpaRepository;

@Component
@RequiredArgsConstructor
class AccumulatePolicyPersistenceAdapter implements LoadAccumulatePolicyPort {
    private final GradeJpaRepository gradeJpaRepository;
    private final UserJpaRepository userJpaRepository;
    private final AccumulatePolicyMapper accumulatePolicyMapper;

    @Override
    public AccumulatePolicy loadAccumulatePolicy(Order order) {
        long userId = order.getOrdererId();

        UserJpa user = userJpaRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException(String.format("User id %d was not found", userId)));
        return gradeJpaRepository
                        .findOneByCode(user.getGradeCode())
                        .map(accumulatePolicyMapper::toMap)
                        .orElseThrow(() ->
                                new IllegalArgumentException(String.format("Grade id %s was not found", user.getGradeCode())));
    }
}

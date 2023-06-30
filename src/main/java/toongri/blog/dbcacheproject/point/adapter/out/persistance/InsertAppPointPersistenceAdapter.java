package toongri.blog.dbcacheproject.point.adapter.out.persistance;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import toongri.blog.dbcacheproject.point.application.port.out.InsertAppPointPort;
import toongri.blog.dbcacheproject.point.domain.AppPoint;
import toongri.blog.dbcacheproject.rds.point.AppPointJpa;
import toongri.blog.dbcacheproject.rds.point.AppPointJpaRepository;

@Component
@RequiredArgsConstructor
class InsertAppPointPersistenceAdapter implements InsertAppPointPort {
    private final AppPointMapper appPointMapper;
    private final AppPointJpaRepository appPointJpaRepository;
    @Override
    public void insertAppPoint(AppPoint appPoint) {
        AppPointJpa appPointJpa = appPointMapper.toMap(appPoint);
        appPointJpaRepository.save(appPointJpa);
    }
}

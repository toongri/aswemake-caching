package toongri.blog.dbcacheproject.point.adapter.out.persistance;

import org.springframework.stereotype.Component;
import toongri.blog.dbcacheproject.point.domain.AccumulatePolicy;
import toongri.blog.dbcacheproject.point.domain.RateAccumulatePolicy;
import toongri.blog.dbcacheproject.rds.grade.GradeJpa;

@Component
class AccumulatePolicyMapper {
    public AccumulatePolicy toMap(GradeJpa grade) {
        return RateAccumulatePolicy.create(grade.getId(), grade.getAccrualRate());
    }
}

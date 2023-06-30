package toongri.blog.dbcacheproject.point.adapter.out.persistance;

import org.springframework.stereotype.Component;
import toongri.blog.dbcacheproject.point.domain.AppPoint;
import toongri.blog.dbcacheproject.rds.point.AppPointJpa;

@Component
class AppPointMapper {

    public AppPointJpa toMap(AppPoint appPoint) {
        return new AppPointJpa(appPoint.getUserId(), appPoint.getPoint());
    }
}

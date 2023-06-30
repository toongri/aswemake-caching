package toongri.blog.dbcacheproject.rds.point;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AppPointJpaRepository extends JpaRepository<AppPointJpa, Long> {
    List<AppPointJpa> findAllByUserId(long userId);
}

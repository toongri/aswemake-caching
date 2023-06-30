package toongri.blog.dbcacheproject.rds.grade;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GradeJpaRepository extends JpaRepository<GradeJpa, String> {
    @Cacheable(value = "grades", key = "#code")
    Optional<GradeJpa> findOneByCode(String code);
}

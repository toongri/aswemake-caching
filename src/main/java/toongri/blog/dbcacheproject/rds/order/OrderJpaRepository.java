package toongri.blog.dbcacheproject.rds.order;

import org.springframework.data.jpa.repository.JpaRepository;
import toongri.blog.dbcacheproject.point.domain.Order;

public interface OrderJpaRepository extends JpaRepository<OrderJpa, Long> {
}

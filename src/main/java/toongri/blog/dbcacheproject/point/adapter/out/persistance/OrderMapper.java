package toongri.blog.dbcacheproject.point.adapter.out.persistance;

import org.springframework.stereotype.Component;
import toongri.blog.dbcacheproject.point.domain.Order;
import toongri.blog.dbcacheproject.point.domain.OrderStatus;
import toongri.blog.dbcacheproject.rds.order.OrderJpa;

@Component
class OrderMapper {

    public Order toMap(OrderJpa orderJpa) {
        return Order.create(orderJpa.getUserId(), orderJpa.getUserId(), orderJpa.getTotalPrice(), OrderStatus.valueOf(orderJpa.getStatusName()));
    }
}

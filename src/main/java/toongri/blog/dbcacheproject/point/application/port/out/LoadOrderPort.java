package toongri.blog.dbcacheproject.point.application.port.out;

import toongri.blog.dbcacheproject.point.domain.Order;

public interface LoadOrderPort {
    Order loadOrder(Long orderId);
}

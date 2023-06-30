package toongri.blog.dbcacheproject.point.adapter.out.persistance;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import toongri.blog.dbcacheproject.point.application.port.out.LoadOrderPort;
import toongri.blog.dbcacheproject.point.domain.Order;
import toongri.blog.dbcacheproject.rds.order.OrderJpaRepository;

@Component
@RequiredArgsConstructor
class OrderPersistenceAdapter implements LoadOrderPort {
    private final OrderMapper orderMapper;
    private final OrderJpaRepository orderJpaRepository;

    @Override
    public Order loadOrder(Long orderId) {

        return orderJpaRepository.findById(orderId)
                .map(orderMapper::toMap)
                .orElseThrow(() -> new IllegalArgumentException(String.format("Order id %d was not found", orderId)));
    }
}

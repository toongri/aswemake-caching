package toongri.blog.dbcacheproject.point.domain;

import org.springframework.stereotype.Component;

@Component
public class PointValidator {

    public void validate(AppPoint point, Order order) {
        if (!point.isSameOwn(order)) {
            throw new IllegalArgumentException(String.format("order %d는 user %d의 주문이 아닙니다.", order.getId(), point.getUserId()));
        }

        if (point.isEmpty()) {
            throw new RuntimeException(String.format("order %d는 주문금액이 계산되지 않습니다.", order.getId()));
        }

        if (!order.isPayed()) {
            throw new IllegalArgumentException(String.format("order %d는 결제되지 않았습니다.", order.getId()));
        }
    }
}

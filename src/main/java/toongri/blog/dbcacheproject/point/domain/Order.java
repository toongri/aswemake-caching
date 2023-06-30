package toongri.blog.dbcacheproject.point.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Order {

    private final long id;
    private final long ordererId;

    private final BigDecimal totalPrice;

    private OrderStatus status;

    // ==연관관계 메소드==//

    // ==생성 메소드==//
    public static Order create(long orderId, long ordererId, BigDecimal totalPrice, OrderStatus status) {
        return new Order(orderId, ordererId, totalPrice, status);
    }

    // ==수정 메소드==//

    // ==비즈니스 로직==//

    public BigDecimal calculateAccumulatedPoint(AccumulatePolicy accumulatePolicy) {
        return accumulatePolicy.getAccumulatedPoint(this);
    }

    public boolean isPayed() {
        return status == OrderStatus.PAYED;
    }

    // ==조회 로직==//

    public long getId() {
        return id;
    }

    public long getOrdererId() {
        return ordererId;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }
}

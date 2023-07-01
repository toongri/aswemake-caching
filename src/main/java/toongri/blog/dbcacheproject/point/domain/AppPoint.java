package toongri.blog.dbcacheproject.point.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class AppPoint {

    private long id;

    private final long userId;

    private final BigDecimal point;

    // ==생성 메소드==//
    public static AppPoint accumulate(Order order, AccumulatePolicy accumulatePolicy, PointValidator pointValidator) {
        AppPoint appPoint = new AppPoint(order, accumulatePolicy);
        pointValidator.validate(appPoint, order);

        return appPoint;
    }

    private AppPoint(Order order, AccumulatePolicy accumulatePolicy) {
        this.userId = order.getOrdererId();
        this.point = order.calculateAccumulatedPoint(accumulatePolicy);
    }
    // ==비즈니스 로직==//
    public boolean isEmpty() {
        return point.compareTo(BigDecimal.ZERO) == 0;
    }

    public boolean isSameOwn(Order order) {
        return this.userId == order.getOrdererId();
    }

    // ==조회 로직==//

    public long getUserId() {
        return userId;
    }

    public BigDecimal getPoint() {
        return point;
    }
}

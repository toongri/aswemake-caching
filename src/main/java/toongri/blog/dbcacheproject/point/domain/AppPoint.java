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
        BigDecimal amount = order.calculateAccumulatedPoint(accumulatePolicy);
        AppPoint appPoint = new AppPoint(order.getOrdererId(), amount);
        pointValidator.validate(appPoint, order);

        return appPoint;
    }

    private AppPoint(long userId, BigDecimal point) {
        this.userId = userId;
        this.point = point;
    }
    // ==비즈니스 로직==//
    public boolean isEmpty() {
        return point.compareTo(BigDecimal.ZERO) == 0;
    }

    // ==조회 로직==//

    public long getUserId() {
        return userId;
    }

    public BigDecimal getPoint() {
        return point;
    }
}

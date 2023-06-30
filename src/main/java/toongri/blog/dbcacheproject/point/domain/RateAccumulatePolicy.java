package toongri.blog.dbcacheproject.point.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class RateAccumulatePolicy implements AccumulatePolicy{

    private final String id;
    private final BigDecimal accrualRate;

    // ==연관관계 메소드==//

    // ==생성 메소드==//
    public static RateAccumulatePolicy create(String id, BigDecimal accrualRate) {
        return new RateAccumulatePolicy(id, accrualRate);
    }



    // ==수정 메소드==//

    // ==비즈니스 로직==//
    @Override
    public BigDecimal getAccumulatedPoint(Order order) {
        return accrualRate.multiply(order.getTotalPrice());
    }
    // ==조회 로직==//
}

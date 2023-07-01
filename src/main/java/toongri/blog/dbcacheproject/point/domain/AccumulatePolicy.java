package toongri.blog.dbcacheproject.point.domain;

import java.math.BigDecimal;

public interface AccumulatePolicy {

    BigDecimal getAccumulatedPoint(BigDecimal totalPrice);

}

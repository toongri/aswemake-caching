package toongri.blog.dbcacheproject.point.application.port.out;

import toongri.blog.dbcacheproject.point.domain.AccumulatePolicy;
import toongri.blog.dbcacheproject.point.domain.Order;

public interface LoadAccumulatePolicyPort {

    AccumulatePolicy loadAccumulatePolicy(Order order);
}

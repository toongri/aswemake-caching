package toongri.blog.dbcacheproject.point.application.port.in;

import toongri.blog.dbcacheproject.point.application.port.in.command.RewardForOrderCommand;

public interface RewardForOrderUsecase {

    void rewardForPayment(RewardForOrderCommand command);
}

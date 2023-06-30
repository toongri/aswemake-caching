package toongri.blog.dbcacheproject.point.application;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import toongri.blog.dbcacheproject.point.application.port.in.RewardForOrderUsecase;
import toongri.blog.dbcacheproject.point.application.port.in.command.RewardForOrderCommand;
import toongri.blog.dbcacheproject.point.domain.Order;
import toongri.blog.dbcacheproject.point.domain.OrderStatus;
import toongri.blog.dbcacheproject.rds.grade.GradeJpa;
import toongri.blog.dbcacheproject.rds.grade.GradeJpaRepository;
import toongri.blog.dbcacheproject.rds.order.OrderJpa;
import toongri.blog.dbcacheproject.rds.order.OrderJpaRepository;
import toongri.blog.dbcacheproject.rds.point.AppPointJpa;
import toongri.blog.dbcacheproject.rds.point.AppPointJpaRepository;
import toongri.blog.dbcacheproject.rds.user.UserJpa;
import toongri.blog.dbcacheproject.rds.user.UserJpaRepository;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class RewardForOrderTest {

    @Autowired private RewardForOrderUsecase rewardForOrderUsecase;
    @Autowired private OrderJpaRepository orderJpaRepository;
    @Autowired private GradeJpaRepository gradeJpaRepository;
    @Autowired private UserJpaRepository userJpaRepository;
    @Autowired private AppPointJpaRepository appPointJpaRepository;
    @PersistenceContext private EntityManager entityManager;

    @AfterEach
    void cleanUp() {
        appPointJpaRepository.deleteAll();
        orderJpaRepository.deleteAll();
        userJpaRepository.deleteAll();
        gradeJpaRepository.deleteAll();
    }

    @Test
    @DisplayName("주문에 대한 보상을 받는다")
    void 주문에_대한_보상을_받는다() throws Exception{
        //given
        BigDecimal rate = BigDecimal.valueOf(0.01);
        GradeJpa grade = createGrade(rate);
        BigDecimal orderTotalAmount = BigDecimal.valueOf(1000);
        OrderJpa order = this.createOrder(grade, orderTotalAmount);

        RewardForOrderCommand command = new RewardForOrderCommand(order.getId());

        //when
        int loop = 50000;
        for (int i = 0; i < loop; i++) {
            rewardForOrderUsecase.rewardForPayment(command);
        }

        //then
        List<AppPointJpa> points = appPointJpaRepository.findAllByUserId(order.getUserId());

        Assertions.assertThat(points.size()).isEqualTo(loop);

        Assertions.assertThat(points.stream().filter(point -> point.getPoint().compareTo(orderTotalAmount.multiply(rate)) == 0).count()).isEqualTo(loop);
    }

    private GradeJpa createGrade(BigDecimal rate) {
        GradeJpa gradeJpa = new GradeJpa("abc", "짱짱맨", rate, 0, "");
        return gradeJpaRepository.save(gradeJpa);
    }

    private OrderJpa createOrder(GradeJpa grade, BigDecimal totalPrice) {
        UserJpa user = new UserJpa("홍길동", grade);
        userJpaRepository.save(user);
        OrderJpa orderJpa = new OrderJpa(user, totalPrice, OrderJpa.OrderStatus.PAYED);

        return orderJpaRepository.save(orderJpa);
    }
}

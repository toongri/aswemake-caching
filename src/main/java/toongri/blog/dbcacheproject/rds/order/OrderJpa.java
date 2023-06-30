package toongri.blog.dbcacheproject.rds.order;

import jakarta.persistence.*;
import lombok.*;
import toongri.blog.dbcacheproject.rds.BaseTimeEntityJpa;
import toongri.blog.dbcacheproject.rds.user.UserJpa;

import java.math.BigDecimal;

@Entity
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "orders")
public class OrderJpa extends BaseTimeEntityJpa {
  public enum OrderStatus {ORDERED, PAYED, RECEIVED, REFUNDED, CANCELED;}

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "order_id")
  private Long id;

  private Long userId;

  private BigDecimal totalPrice;

  @Enumerated(EnumType.STRING)
  private OrderStatus status;

  public OrderJpa(UserJpa user, BigDecimal totalPrice, OrderStatus status) {
    this.userId = user.getId();
    this.totalPrice = totalPrice;
    this.status = status;
  }

  public String getStatusName() {
    return status.name();
  }
}

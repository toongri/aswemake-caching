package toongri.blog.dbcacheproject.rds.point;

import jakarta.persistence.*;
import lombok.*;
import toongri.blog.dbcacheproject.rds.BaseTimeEntityJpa;

import java.math.BigDecimal;

@Entity
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "app_points")
public class AppPointJpa extends BaseTimeEntityJpa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;

    private Long userId;

    private BigDecimal point;

    public AppPointJpa(Long userId, BigDecimal point) {
        this.userId = userId;
        this.point = point;
    }
}

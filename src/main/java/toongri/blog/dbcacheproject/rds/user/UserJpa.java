package toongri.blog.dbcacheproject.rds.user;


import jakarta.persistence.*;
import lombok.*;
import toongri.blog.dbcacheproject.rds.BaseTimeEntityJpa;
import toongri.blog.dbcacheproject.rds.grade.GradeJpa;

@Entity
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "users")
public class UserJpa extends BaseTimeEntityJpa {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "user_id")
  private Long id;

  private String name;

  private String gradeCode;

  public UserJpa(String name, GradeJpa gradeJpa) {
    this.name = name;
    this.gradeCode = gradeJpa.getCode();
  }
}

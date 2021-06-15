package kodlamaio.HumanResourceManagementSystem.entities.concretes;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "activation_codes")
public class ActivationCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "code")
    private String code;

    @Column(name = "is_verified")
    private boolean isVerified;

    @Column(name = "verified_date")
    private LocalDateTime verifiedDate;

    public ActivationCode(int userId, String code, boolean isVerified, LocalDateTime verifiedDate){
        this.userId = userId;
        this.code = code;
        this.isVerified = isVerified;
        this.verifiedDate = verifiedDate;
    }

}

package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity(name = "FORGOT_PASSWORD")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ForgotPassword {
    @Id
    @GeneratedValue(generator = "FORGOT_PASSWORD_SEQ")
    @SequenceGenerator(name = "FORGOT_PASSWORD_SEQ", sequenceName = "FORGOT_PASSWORD_SEQ", allocationSize = 1)
    @Column(name = "FORGOT_PASSWORD_ID")
    private Long verificationId;

    @OneToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private User user;

    @Column(name = "TOKEN")
    private String token;

    @Column(name = "EXPIRY")
    private Timestamp expiry;

    public boolean isExpired() {
        return LocalDateTime.now().isAfter(expiry.toLocalDateTime());
    }
}

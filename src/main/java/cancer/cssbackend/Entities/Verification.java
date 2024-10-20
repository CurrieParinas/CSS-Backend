package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity(name = "VERIFICATION")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Verification {
    @Id
    @GeneratedValue(generator = "VERIFICATION_SEQ")
    @SequenceGenerator(name = "VERIFICATION_SEQ", sequenceName = "VERIFICATION_SEQ", allocationSize = 1)
    @Column(name = "VERIFICATION_ID")
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

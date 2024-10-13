package cancer.cssbackend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.sql.Date;

@Entity(name = "USERTABLE")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {
    @Id
    @GeneratedValue(generator = "USER_SEQ")
    @SequenceGenerator(name="USER_SEQ", sequenceName = "USER_SEQ", allocationSize = 1)
    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "USER_LASTNAME")
    private String userLastname;

    @Column(name = "USER_FIRSTNAME")
    private String userFirstname;

    @Column(name = "USER_MIDDLENAME")
    private String userMiddlename;

    @Column(name = "USER_EMAIL")
    private String userEmail;

    @Column(name = "USER_PASSWORD")
    private String userPassword;

    @Column(name = "USER_GENDER")
    private String userGender;

    @Column(name = "USER_MARITAL_STATUS")
    private String userMaritalStatus;

    @Column(name = "USER_BIRTHDATE")
    private Date userBirthdate;

    @Column(name = "USER_BIRTHPLACE")
    private String userBirthplace;

    @OneToOne
    @JoinColumn(name = "USER_ADDRESS", referencedColumnName = "ADDRESS_ID")
    private Address userAddress;

    @ManyToOne
    @JoinColumn(name = "USER_ROLE", referencedColumnName = "ROLE_ID")
    private Role userRole;

    @ManyToOne
    @JoinColumn(name = "USER_ACCESS", referencedColumnName = "ACCESS_ID")
    private Access userAccess;

    @Column(name = "USER_IS_VERIFIED")
    private char userIsVerified;

    @Column(name = "USER_STATUS")
    private String userStatus;

    @Column(name = "USER_CREATED_ON")
    private Timestamp userCreatedOn;

    @Column(name = "USER_UPDATED_ON")
    private Timestamp userUpdatedOn;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "USER_ENCODER", referencedColumnName = "USER_ID")
    private User userEncoder;
}

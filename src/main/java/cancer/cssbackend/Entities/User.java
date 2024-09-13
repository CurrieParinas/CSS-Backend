package cancer.cssbackend.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;
import java.sql.Date;

@Entity(name = "USER")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class User {
    @Id
    @JsonProperty("USER_ID")
    @GeneratedValue(generator = "USER_SEQ")
    @SequenceGenerator(name="USER_SEQ", sequenceName = "USER_SEQ", allocationSize = 1)
    @Column(name = "USER_ID")
    private Long userId;
    @JsonProperty("USER_LASTNAME")
    private String userLastName;
    @JsonProperty("USER_FIRSTNAME")
    private String userFirstName;
    @JsonProperty("USER_MIDDLENAME")
    private String userMiddleName;
    @JsonProperty("USER_EMAIL")
    private String userEmail;
    @JsonProperty("USER_PASSWORD")
    private String userPassword;
    @JsonProperty("USER_GENDER")
    private String userGender;
    @JsonProperty("USER_MARITAL_STATUS")
    private String userMaritalStatus;
    @JsonProperty("USER_BIRTHDATE")
    private Date userBirthdate;
    @JsonProperty("USER_BIRTHPLACE")
    private String userBirthplace;
    @OneToOne
    @JoinColumn(name = "ADDRESS_ID", referencedColumnName = "ADDRESS_ID")
    @JsonProperty("USER_ADDRESS")
    private Address userAddress;
    @ManyToOne
    @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID")
    @JsonProperty("USER_ROLE")
    private Role userRole;
    @ManyToOne
    @JoinColumn(name = "ACCESS_ID", referencedColumnName = "ACCESS_ID")
    @JsonProperty("USER_ACCESS")
    private Access userAccess;
    @JsonProperty("USER_IS_VERIFIED")
    private String userIsVerified;
    @JsonProperty("USER_STATUS")
    private String userStatus;
    @JsonProperty("USER_CREATED_ON")
    private Timestamp userCreatedOn;
    @JsonProperty("USER_UPDATED_ON")
    private Timestamp userUpdatedOn;
    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    @JsonProperty("USER_ENCODER")
    private User userEncoder;
}

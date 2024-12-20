package cancer.cssbackend.Entities.Requests;

import cancer.cssbackend.Entities.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddPatientRequest {
    @JsonProperty("USER_LASTNAME")
    private String userLastname;

    @JsonProperty("USER_FIRSTNAME")
    private String userFirstname;

    @JsonProperty("USER_MIDDLENAME")
    private String userMiddlename;

    @JsonProperty("USER_EMAIL")
    private String userEmail;

    @JsonProperty("USER_GENDER")
    private String userGender;

    @JsonProperty("USER_MARITAL_STATUS")
    private String userMaritalStatus;

    @JsonProperty("USER_BIRTHDATE")
    private String userBirthdate;

    @JsonProperty("USER_BIRTHPLACE")
    private String userBirthplace;

    @JsonProperty("ADDRESS_NUMBER")
    private String addressNumber;

    @JsonProperty("ADDRESS_STREET")
    private String addressStreet;

    @JsonProperty("ADDRESS_CITY")
    private String addressCity;

    @JsonProperty("ADDRESS_REGION")
    private String addressRegion;

    @JsonProperty("ADDRESS_ZIPCODE")
    private String addressZipcode;

//    @ManyToOne
//    @JoinColumn(name = "USER_ROLE", referencedColumnName = "ROLE_ID")
//    private Role userRole;

//    @ManyToOne
//    @JoinColumn(name = "USER_ACCESS", referencedColumnName = "ACCESS_ID")
//    private Access userAccess;

//    @JsonProperty("USER_IS_VERIFIED")
//    private char userIsVerified;

//    @JsonProperty("USER_STATUS")
//    private String userStatus;

//    @JsonProperty("USER_CREATED_ON")
//    private Timestamp userCreatedOn;

//    @JsonProperty("USER_UPDATED_ON")
//    private Timestamp userUpdatedOn;

    @JsonProperty("USER_ENCODER")
    private Long userEncoder;

    public Patient mapToPatient(){
        Patient patient = new Patient();
        Address address = new Address();
        User user = new User();

        address.setAddressNumber(addressNumber);
        address.setAddressStreet(addressStreet);
        address.setAddressCity(addressCity);
        address.setAddressRegion(addressRegion);
        address.setAddressZipcode(addressZipcode);

        user.setUserLastname(userLastname);
        user.setUserFirstname(userFirstname);
        user.setUserMiddlename(userMiddlename);
        user.setUserEmail(userEmail);
        user.setUserGender(userGender);
        user.setUserMaritalStatus(userMaritalStatus);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(userBirthdate, formatter);
        user.setUserBirthdate(Date.valueOf(localDate));
        user.setUserBirthplace(userBirthplace);
        user.setUserAddress(address);
        user.setUserIsVerified('N');
        user.setUserStatus("Active");
        user.setUserCreatedOn(Timestamp.valueOf(LocalDateTime.now()));
        user.setUserUpdatedOn(Timestamp.valueOf(LocalDateTime.now()));

        patient.setUser(user);
        patient.setPatientCreatedOn(Timestamp.valueOf(LocalDateTime.now()));
        patient.setPatientUpdatedOn(Timestamp.valueOf(LocalDateTime.now()));
        return patient;
    }

    public Patient mapToPatient(Patient patient, Address address, User user){
        address.setAddressNumber(addressNumber);
        address.setAddressStreet(addressStreet);
        address.setAddressCity(addressCity);
        address.setAddressRegion(addressRegion);
        address.setAddressZipcode(addressZipcode);

        user.setUserLastname(userLastname);
        user.setUserFirstname(userFirstname);
        user.setUserMiddlename(userMiddlename);
        user.setUserEmail(userEmail);
        user.setUserGender(userGender);
        user.setUserMaritalStatus(userMaritalStatus);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(userBirthdate, formatter);
        user.setUserBirthdate(Date.valueOf(localDate));
        user.setUserBirthplace(userBirthplace);
        user.setUserAddress(address);
        user.setUserCreatedOn(Timestamp.valueOf(LocalDateTime.now()));
        user.setUserUpdatedOn(Timestamp.valueOf(LocalDateTime.now()));

        patient.setUser(user);
        patient.setPatientCreatedOn(Timestamp.valueOf(LocalDateTime.now()));
        patient.setPatientUpdatedOn(Timestamp.valueOf(LocalDateTime.now()));
        return patient;
    }
}

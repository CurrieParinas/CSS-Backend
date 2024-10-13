package cancer.cssbackend.Entities.Requests;

import cancer.cssbackend.Entities.*;
import cancer.cssbackend.Services.DepartmentService;
import cancer.cssbackend.Services.HospitalService;
import cancer.cssbackend.Services.SpecialtyService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.print.Doc;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddDoctorRequest {
    @JsonProperty("hospital_id")
    Long hospitalId;

    @JsonProperty("department_id")
    Long departmentId;

    @JsonProperty("specialty_id")
    Long specialtyId;

    @JsonProperty("doctor_e_signature")
    byte[] doctorESignature;

    @JsonProperty("doctor_license_number")
    String doctorLicenseNumber;

    @JsonProperty("doctor_license_exp_date")
    String doctorLicenseExpDate;

    //@JsonProperty("doctor_schedule")
    //int doctorSchedule;
    @JsonProperty("USER_LASTNAME")
    private String userLastname;

    @JsonProperty("USER_FIRSTNAME")
    private String userFirstname;

    @JsonProperty("USER_MIDDLENAME")
    private String userMiddlename;

    @JsonProperty("USER_EMAIL")
    private String userEmail;

    @JsonProperty("USER_PASSWORD")
    private String userPassword;

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

    public Doctor mapToDoctor(HospitalService hospitalService, DepartmentService departmentService, SpecialtyService specialtyService){
        Doctor doctor = new Doctor();

        Address address = new Address();
        address.setAddressNumber(addressNumber);
        address.setAddressStreet(addressStreet);
        address.setAddressCity(addressCity);
        address.setAddressRegion(addressRegion);
        address.setAddressZipcode(addressZipcode);

        User user = new User();
        user.setUserLastname(userLastname);
        user.setUserFirstname(userFirstname);
        user.setUserMiddlename(userMiddlename);
        user.setUserEmail(userEmail);
        user.setUserPassword(userPassword);
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



        Hospital hospital = hospitalService.findHospital(hospitalId);
        if(hospital != null){
            doctor.setHospital(hospital);
        }

        Department department = departmentService.findDepartment(departmentId);
        if(department != null){
            doctor.setDepartment(department);
        }

        Specialty specialty = specialtyService.findSpecialty(specialtyId);
        if(specialty != null){
            doctor.setSpecialty(specialty);
        }

        doctor.setDoctorESignature(doctorESignature);
        doctor.setDoctorLicenseNumber(doctorLicenseNumber);
        doctor.setDoctorLicenseExpDate(Date.valueOf(LocalDate.parse(doctorLicenseExpDate, formatter)));
        doctor.setUser(user);

        return doctor;
    }
}

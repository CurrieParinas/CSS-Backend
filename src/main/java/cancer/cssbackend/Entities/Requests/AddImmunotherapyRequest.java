package cancer.cssbackend.Entities.Requests;

import cancer.cssbackend.Entities.*;
import cancer.cssbackend.Services.DoctorService;
import cancer.cssbackend.Services.HospitalService;
import cancer.cssbackend.Services.PatientService;
import cancer.cssbackend.Services.UserService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddImmunotherapyRequest {
    @JsonProperty("patientId")
    private Long patientId;

    @JsonProperty("immunorxDrug")
    private String immunorxDrug;

    @JsonProperty("immunorxInitialDate")
    private String immunorxInitialdate;

    @JsonProperty("immunorxEndDate")
    private String immunorxEnddate;

    @JsonProperty("immunorxStatus")
    private String immunorxStatus;

    @JsonProperty("immunorxNotes")
    private String immunorxNotes;

    @JsonProperty("immunorxIsCompleted")
    private char immunorxIscompleted;

    @JsonProperty("immunorxFacilityId")
    private Long immunorxFacilityId;

    @JsonProperty("immunorxDoctorId")
    private Long immunorxDoctorId;

    @JsonProperty("immunorxEncoderId")
    private Long immunorxEncoderId;


    public Immunotherapy mapToImmunotherapy(PatientService patientService, DoctorService doctorService, UserService userService, HospitalService hospitalService) {
        Immunotherapy immunotherapy = new Immunotherapy();

        Patient patient = patientService.findPatient(patientId);
        Doctor doctor = doctorService.findDoctor(immunorxDoctorId);
        User encoder = userService.getUser(immunorxEncoderId);
        Hospital facility = hospitalService.findHospital(immunorxFacilityId);

        if(patient != null){
            immunotherapy.setPatient(patient);
        }
        if(doctor != null){
            immunotherapy.setImmunorxDoctor(doctor);
        }
        if(encoder != null){
            immunotherapy.setImmunorxEncoder(encoder);
        }
        if(facility != null){
            immunotherapy.setImmunorxFacility(facility);
        }
        immunotherapy.setImmunorxDrug(this.immunorxDrug);
        immunotherapy.setImmunorxInitialdate(Date.valueOf(this.immunorxInitialdate));
        immunotherapy.setImmunorxEnddate(Date.valueOf(this.immunorxEnddate));
        immunotherapy.setImmunorxStatus(this.immunorxStatus);
        immunotherapy.setImmunorxNotes(this.immunorxNotes);
        immunotherapy.setImmunorxIscompleted(this.immunorxIscompleted);
        immunotherapy.setImmunorxCreatedon(Timestamp.valueOf(LocalDateTime.now()));
        immunotherapy.setImmunorxUpdatedon(Timestamp.valueOf(LocalDateTime.now()));

        return immunotherapy;
    }

}

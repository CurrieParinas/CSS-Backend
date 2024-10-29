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

    @JsonProperty("immunorxCreatedOn")
    private String  immunorxCreatedon;

    @JsonProperty("immunorxUpdatedOn")
    private String immunorxUpdatedon;

    public Immunotherapy mapToImmunotherapy(PatientService patientService, DoctorService doctorService, UserService userService, HospitalService hospitalService) {
        Immunotherapy immunotherapy = new Immunotherapy();

        Patient patient = patientService.findPatient(patientId);
        Doctor doctor = doctorService.findDoctor(immunorxDoctorId);
        User encoder = userService.getUser(immunorxEncoderId);
        Hospital facility = hospitalService.findHospital(immunorxFacilityId);

        immunotherapy.setPatient(patient);
        immunotherapy.setImmunorxDrug(this.immunorxDrug);
        immunotherapy.setImmunorxInitialdate(Date.valueOf(this.immunorxInitialdate));
        immunotherapy.setImmunorxEnddate(Date.valueOf(this.immunorxEnddate));
        immunotherapy.setImmunorxStatus(this.immunorxStatus);
        immunotherapy.setImmunorxNotes(this.immunorxNotes);
        immunotherapy.setImmunorxIscompleted(this.immunorxIscompleted);
        immunotherapy.setImmunorxFacility(facility);
        immunotherapy.setImmunorxDoctor(doctor);
        immunotherapy.setImmunorxEncoder(encoder);
        immunotherapy.setImmunorxCreatedon(Timestamp.valueOf(this.immunorxCreatedon));
        immunotherapy.setImmunorxUpdatedon(Timestamp.valueOf(this.immunorxUpdatedon));

        return immunotherapy;
    }

}

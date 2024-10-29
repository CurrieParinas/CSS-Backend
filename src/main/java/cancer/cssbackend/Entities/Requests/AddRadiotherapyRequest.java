package cancer.cssbackend.Entities.Requests;

import cancer.cssbackend.Entities.*;
import cancer.cssbackend.Services.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.print.Doc;
import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddRadiotherapyRequest {
    @JsonProperty("PATIENT_ID")
    private Long patientId;

    @JsonProperty("RADRX_TYPE")
    private Long radRxType;

    @JsonProperty("RADRX_INITIALDATE")
    private String radRxInitialDate;

    @JsonProperty("RADRX_LASTDATE")
    private String radRxLastDate;

    @JsonProperty("RADRX_DOSE")
    private int radRxDose;

    @JsonProperty("RADRX_BODYSITE")
    private String radRxBodySite;

    @JsonProperty("RADRX_STATUS")
    private String radRxStatus;

    @JsonProperty("RADRX_ISCOMPLETED")
    private char radRxIsCompleted; // 'Y' or 'N'

    @JsonProperty("RADRX_FACILITY")
    private Long radRxFacility;

    @JsonProperty("RADRX_DOCTOR")
    private Long radRxDoctor;

    @JsonProperty("RADRX_ENCODER")
    private Long radRxEncoder;

    public Radiotherapy mapToRadiotherapy(PatientService patientService, RadDetailsService radDetailsService, HospitalService hospitalService, DoctorService doctorService, UserService userService) {
        Radiotherapy radiotherapy = new Radiotherapy();

        Patient patient = patientService.findPatient(patientId);
        if(patient != null){
            radiotherapy.setPatient(patient);
        }

        RadDetails radDetails = radDetailsService.findRadDetails(radRxType);
        if(radDetails != null){
            radiotherapy.setRadRxType(radDetails);
        }

        radiotherapy.setRadRxInitialDate(Date.valueOf(radRxInitialDate));
        radiotherapy.setRadRxLastDate(Date.valueOf(radRxLastDate));
        radiotherapy.setRadRxDose(radRxDose);
        radiotherapy.setRadRxBodySite(radRxBodySite);
        radiotherapy.setRadRxStatus(radRxStatus);
        radiotherapy.setRadRxIsCompleted(radRxIsCompleted);

        Hospital hospital = hospitalService.findHospital(radRxFacility);
        if(hospital != null){
            radiotherapy.setRadRxFacility(hospital);
        }

        Doctor doctor = doctorService.findDoctor(radRxDoctor);
        if(doctor != null){
            radiotherapy.setRadRxDoctor(doctor);
        }

        User user = userService.getUser(radRxEncoder);
        if(user != null){
            radiotherapy.setEncoder(user);
        }

        radiotherapy.setCreatedOn(Timestamp.valueOf(LocalDateTime.now()));
        radiotherapy.setUpdatedOn(Timestamp.valueOf(LocalDateTime.now()));

        return radiotherapy;
    }

}

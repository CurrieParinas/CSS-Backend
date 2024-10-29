package cancer.cssbackend.Entities.Requests;

import cancer.cssbackend.Entities.Doctor;
import cancer.cssbackend.Entities.Hormonal;
import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Entities.User;
import cancer.cssbackend.Services.DoctorService;
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
public class AddHormonalRequest {
    @JsonProperty("patientId")
    private Long patientId;

    @JsonProperty("hormonalDrug")
    private String hormonalDrug;

    @JsonProperty("hormonalDose")
    private int hormonalDose;

    @JsonProperty("hormonalInitialDate")
    private String hormonalInitialdate;

    @JsonProperty("hormonalEndDate")
    private String hormonalEnddate;

    @JsonProperty("hormonalStatus")
    private String hormonalStatus;

    @JsonProperty("hormonalRxNotes")
    private String hormonalRxNotes;

    @JsonProperty("hormonalDoctorId")
    private Long hormonalDoctorId;

    @JsonProperty("hormonalEncoderId")
    private Long hormonalEncoderId;

    @JsonProperty("hormonalCreatedOn")
    private String hormonalCreatedon;

    @JsonProperty("hormonalUpdatedOn")
    private String hormonalUpdatedon;

    public Hormonal mapToHormonal(PatientService patientService, DoctorService doctorService, UserService userService){
        Hormonal hormonal = new Hormonal();
        Patient patient = patientService.findPatient(patientId);

        User encoder = userService.getUser(hormonalEncoderId);
        Doctor doctor = doctorService.findDoctor(hormonalDoctorId);

        hormonal.setPatient(patient);
        hormonal.setHormonalDrug(this.hormonalDrug);
        hormonal.setHormonalDose(this.hormonalDose);
        hormonal.setHormonalInitialdate(Date.valueOf(this.hormonalInitialdate));
        hormonal.setHormonalEnddate(Date.valueOf(this.hormonalEnddate));
        hormonal.setHormonalStatus(this.hormonalStatus);
        hormonal.setHormonalRxNotes(this.hormonalRxNotes);
        hormonal.setHormonalDoctor(doctor);
        hormonal.setHormonalEncoder(encoder);
        hormonal.setHormonalCreatedon(Timestamp.valueOf(this.hormonalCreatedon));
        hormonal.setHormonalUpdatedon(Timestamp.valueOf(this.hormonalUpdatedon));


        return hormonal;

    }
}

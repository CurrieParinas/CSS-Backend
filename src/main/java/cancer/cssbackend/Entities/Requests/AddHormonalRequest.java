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
import java.time.LocalDateTime;

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

    public Hormonal mapToHormonal(PatientService patientService, DoctorService doctorService, UserService userService){
        Hormonal hormonal = new Hormonal();
        Patient patient = patientService.findPatient(patientId);

        User encoder = userService.getUser(hormonalEncoderId);
        Doctor doctor = doctorService.findDoctor(hormonalDoctorId);

        if(patient != null){
            hormonal.setPatient(patient);
        }
        if(doctor != null){
            hormonal.setHormonalDoctor(doctor);
        }
        if(encoder != null){
            hormonal.setHormonalEncoder(encoder);
        }
        hormonal.setHormonalDrug(this.hormonalDrug);
        hormonal.setHormonalDose(this.hormonalDose);
        hormonal.setHormonalInitialdate(Date.valueOf(this.hormonalInitialdate));
        hormonal.setHormonalEnddate(Date.valueOf(this.hormonalEnddate));
        hormonal.setHormonalStatus(this.hormonalStatus);
        hormonal.setHormonalRxNotes(this.hormonalRxNotes);
        hormonal.setHormonalCreatedon(Timestamp.valueOf(LocalDateTime.now()));
        hormonal.setHormonalUpdatedon(Timestamp.valueOf(LocalDateTime.now()));

        return hormonal;

    }
}

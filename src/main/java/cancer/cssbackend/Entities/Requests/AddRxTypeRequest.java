package cancer.cssbackend.Entities.Requests;

import cancer.cssbackend.Entities.Patient;
import cancer.cssbackend.Entities.RXType;
import cancer.cssbackend.Entities.User;
import cancer.cssbackend.Services.PatientService;
import cancer.cssbackend.Services.UserService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.repository.query.Param;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddRxTypeRequest {
    @JsonProperty("PATIENT_ID")
    private Long patientId;

    @JsonProperty("RXTYPE_SURGERY")
    private char rxtypeSurgery;

    @JsonProperty("RXTYPE_CHEMOTHERAPY")
    private char rxtypeChemotherapy;

    @JsonProperty("RXTYPE_RADIOTHERAPY")
    private char rxtypeRadiotherapy;

    @JsonProperty("RXTYPE_IMMUNOTHERAPY")
    private char rxtypeImmunotherapy;

    @JsonProperty("RXTYPE_HORMONALTHERAPY")
    private char rxtypeHormonalTherapy;

    @JsonProperty("RXTYPE_OTHERS")
    private char rxtypeOthers;

    @JsonProperty("RXTYPE_NOTES")
    private String rxtypeNotes;

    @JsonProperty("RXTYPE_ENCODER")
    private Long rxtypeEncoderId;

    public RXType mapToRxType(UserService userService, PatientService patientService){
        RXType rxType = new RXType();

        Patient patient = patientService.findPatient(patientId);
        if(patient != null){
            rxType.setPatient(patient);
        }

        rxType.setRxtypeSurgery(this.rxtypeSurgery);
        rxType.setRxtypeChemotherapy(this.rxtypeChemotherapy);
        rxType.setRxtypeRadiotherapy(this.rxtypeRadiotherapy);
        rxType.setRxtypeImmunotherapy(this.rxtypeImmunotherapy);
        rxType.setRxtypeHormonalTherapy(this.rxtypeHormonalTherapy);
        rxType.setRxtypeOthers(this.rxtypeOthers);
        rxType.setRxtypeNotes(this.rxtypeNotes);

        User encoderUser = userService.getUser(rxtypeEncoderId);
        if(encoderUser != null){
            rxType.setEncoder(encoderUser);
        }
        return rxType;
    }
}

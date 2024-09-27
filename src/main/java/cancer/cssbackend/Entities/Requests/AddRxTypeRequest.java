package cancer.cssbackend.Entities.Requests;

import cancer.cssbackend.Entities.RXType;
import cancer.cssbackend.Entities.User;
import cancer.cssbackend.Services.UserService;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddRxTypeRequest {
    @JsonProperty("RXTYPE_ID")
    private Long rxtypeId;

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
    private Long encoderId;

    public RXType mapToRxType(UserService userService){
        RXType rxType = new RXType();
        rxType.setRxtypeId(this.rxtypeId);
        rxType.setRxtypeSurgery(this.rxtypeSurgery);
        rxType.setRxtypeChemotherapy(this.rxtypeChemotherapy);
        rxType.setRxtypeRadiotherapy(this.rxtypeRadiotherapy);
        rxType.setRxtypeImmunotherapy(this.rxtypeImmunotherapy);
        rxType.setRxtypeHormonalTherapy(this.rxtypeHormonalTherapy);
        rxType.setRxtypeOthers(this.rxtypeOthers);
        rxType.setRxtypeNotes(this.rxtypeNotes);

        User encoderUser = userService.getUser(encoderId);
        if(encoderUser != null){
            rxType.setEncoder(encoderUser);
        }
        return rxType;
    }
}

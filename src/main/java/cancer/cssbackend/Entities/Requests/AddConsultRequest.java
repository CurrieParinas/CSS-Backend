package cancer.cssbackend.Entities.Requests;

import cancer.cssbackend.Entities.Consult;
import cancer.cssbackend.Entities.DiseaseStatus;
import cancer.cssbackend.Entities.Patient;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
public class AddConsultRequest {
    @JsonProperty("PATIENT_ID")
    private Long patientID;

    @JsonProperty("CONSULT_DATE")
    private String consultDate;

    @JsonProperty("CONSULT_SUBJECTIVE")
    private String consultSubjective;

    @JsonProperty("CONSULT_OBJECTIVE")
    private String consultObjective;

    @JsonProperty("CONSULT_SURVWORKUP")
    private String consultSurvworkup;

    @JsonProperty("CONSULT_RXPLAN")
    private String consultRxplan;

    @JsonProperty("CONSULT_ASSESSMENT")
    private String consultAssessment;

    @JsonProperty("CONSULT_PATIENTSTATUS")
    private Long consultPatientstatus;

    public Consult mapToConsult() {
        Consult consult = new Consult();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(consultDate, formatter);
        consult.setConsultDate(Date.valueOf(localDate));
        consult.setConsultSubjective(consultSubjective);
        consult.setConsultObjective(consultObjective);
        consult.setConsultSurvworkup(consultSurvworkup);
        consult.setConsultRxplan(consultRxplan);
        consult.setConsultAssessment(consultAssessment);

        return consult;
    }
}

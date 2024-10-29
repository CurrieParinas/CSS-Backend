package cancer.cssbackend.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity(name = "RXTYPE")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class RXType {

    @Id
    @GeneratedValue(generator = "RXTYPE_SEQ")
    @SequenceGenerator(name="RXTYPE_SEQ", sequenceName = "RXTYPE_SEQ", allocationSize = 1)
    @Column(name = "RXTYPE_ID")
    private Long rxtypeId;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "PATIENT_ID", referencedColumnName = "PATIENT_ID", foreignKey = @ForeignKey(name = "FK_PATIENT_RXTYPE"))
    private Patient patient;

    @Column(name = "RXTYPE_SURGERY")
    private char rxtypeSurgery;

    @Column(name = "RXTYPE_CHEMOTHERAPY")
    private char rxtypeChemotherapy;

    @Column(name = "RXTYPE_RADIOTHERAPY")
    private char rxtypeRadiotherapy;

    @Column(name = "RXTYPE_IMMUNOTHERAPY")
    private char rxtypeImmunotherapy;

    @Column(name = "RXTYPE_HORMONALTHERAPY")
    private char rxtypeHormonalTherapy;

    @Column(name = "RXTYPE_OTHERS")
    private char rxtypeOthers;

    @Column(name = "RXTYPE_NOTES")
    private String rxtypeNotes;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RXTYPE_ENCODER")
    private User encoder;

    @Column(name = "RXTYPE_CREATEDON")
    private Timestamp createdOn;

    @Column(name = "RXTYPE_UPDATEDON")
    private Timestamp updatedOn;
}

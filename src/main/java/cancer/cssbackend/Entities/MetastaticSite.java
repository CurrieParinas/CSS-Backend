package cancer.cssbackend.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Timestamp;

@Entity(name = "METASTATICSITE")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class MetastaticSite {
    @Id
    @SequenceGenerator(name = "METASTATICSITE_SEQ", sequenceName = "METASTATICSITE_SEQ", allocationSize = 1)
    @Column(name = "METS_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "METASTATICSITE_SEQ")
    private Long metSID;

    @OneToOne
    @JoinColumn(name = "PATIENT_ID", referencedColumnName = "PATIENT_ID")
    @JsonProperty("PATIENT_ID")
    private Patient patient;


    @Column(name = "METS_DISTANTLN")
    private char metsDistantLN;

    @Column(name = "METS_BONE")
    private char metsBone;

    @Column(name = "METS_LIVER")
    private char metsLiver;

    @Column(name = "METS_LUNG")
    private char metsLung;

    @Column(name = "METS_BRAIN")
    private char metsBrain;

    @Column(name = "METS_OVARY")
    private char metsOvary;

    @Column(name = "METS_SKIN")
    private char metsSkin;

    @Column(name = "METS_INTESTINE")
    private char metsIntestine;

    @Column(name = "METS_OTHERS")
    private char metsOthers;

    @Column(name = "METS_UNKNOWN")
    private char metsUnknown;

    @Column(name = "METS_NOTES")
    private String metsNotes;

    @Column(name = "METS_CREATEDON")
    private Timestamp metsCreatedOn;

    @Column(name = "METS_UPDATEDON")
    private Timestamp metsUpdatedOn;

    @ManyToOne
    @JoinColumn(name = "METS_ENCODER", referencedColumnName = "METS_ENCODER")
    @JsonProperty("METS_ENCODER")
    private User histoEncoder;
}
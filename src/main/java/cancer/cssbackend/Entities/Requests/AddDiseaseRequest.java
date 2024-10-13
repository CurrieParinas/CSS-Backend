package cancer.cssbackend.Entities.Requests;

import cancer.cssbackend.Entities.*;
import cancer.cssbackend.Repositories.DoctorRepository;
import cancer.cssbackend.Repositories.PatientRepository;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddDiseaseRequest {
    @JsonProperty("PATIENT_ID")
    private Long patientID;

    @JsonProperty("DISEASE_PRIMARY_SITE")
    private Long bodySiteID;

    @JsonProperty("DISEASE_DIAGNOSIS_DATE")
    private String diseaseDiagnosisDate;

    @JsonProperty("DISEASE_BASIS")
    private Long basisID;

    @JsonProperty("DISEASE_LATERALITY")
    private String diseaseLaterality;

//    @JsonProperty("DISEASE_HISTOLOGY")
//    private Long diseaseHistology;

    @JsonProperty("HISTO_PATHOLOGY")
    private Long histoPathology;

    @JsonProperty("HISTO_TUMOR_SIZE")
    private int histoTumorSize;

    @JsonProperty("HISTO_TUMOR_EXTENSION")
    private char histoTumorExtension;

    @JsonProperty("HISTO_GRADE")
    private int histoGrade;

    @JsonProperty("HISTO_NODE_POSITIVE")
    private int histoNodePositive;

    @JsonProperty("HISTO_NODE_HARVEST")
    private int histoNodeHarvest;

    @JsonProperty("HISTO_MARGINS_NEGATIVE")
    private char histoMarginsNegative;

    @JsonProperty("HISTO_POSITIVE_MARGINS")
    private String histoMarginsPositive;

    @JsonProperty("HISTO_STAGE")
    private String histoStage;

//    @JsonProperty("HISTO_CREATED_ON")
//    private Timestamp histoCreatedOn;
//
//    @JsonProperty("HISTO_UPDATED_ON")
//    private Timestamp histoUpdatedOn;
//
//    @JsonProperty("HISTO_ENCODER")
//    private Long histoEncoder;

    @JsonProperty("DISEASE_EXTENT")
    private String diseaseExtent;

    @JsonProperty("DISEASE_TUMOR_SIZE")
    private int diseaseTumorSize;

    @JsonProperty("DISEASE_LYMPH_NODE")
    private int diseaseLymphNode;

    @JsonProperty("DISEASE_METASTATIC")
    private char diseaseMetastatic;

//    @JsonProperty("DISEASE_METASTATIC_SITE")
//    private Long metastaticSiteID;

    @JsonProperty("METS_DISTANTLN")
    private char metsDistantln;

    @JsonProperty("METS_BONE")
    private char metsBone;

    @JsonProperty("METS_LIVER")
    private char metsLiver;

    @JsonProperty("METS_LUNG")
    private char metsLung;

    @JsonProperty("METS_BRAIN")
    private char metsBrain;

    @JsonProperty("METS_OVARY")
    private char metsOvary;

    @JsonProperty("METS_SKIN")
    private char metsSkin;

    @JsonProperty("METS_INTESTINE")
    private char metsIntestine;

    @JsonProperty("METS_OTHERS")
    private char metsOthers;

    @JsonProperty("METS_UNKNOWN")
    private char metsUnknown;

    @JsonProperty("METS_NOTES")
    private String metsNotes;

//    @JsonProperty("METS_CREATED_ON")
//    private Timestamp metsCreatedOn;
//
//    @JsonProperty("METS_UPDATED_ON")
//    private Timestamp metsUpdatedOn;
//
//    @JsonProperty("METS_ENCODER")
//    private Long metsEncoder;

    @JsonProperty("DISEASE_MULTIPLE_PRIMARY")
    private int diseaseMultiplePrimary;

    @JsonProperty("DISEASE_OTHER_SITES")
    private List<Long> diseaseOtherSites;

    @JsonProperty("DISEASE_TSTAGE")
    private int diseaseTstage;

    @JsonProperty("DISEASE_NSTAGE")
    private int diseaseNstage;

    @JsonProperty("DISEASE_MSTAGE")
    private int diseaseMstage;

    @JsonProperty("DISEASE_GSTAGE")
    private int diseaseGstage;

    @JsonProperty("DISEASE_STAGE")
    private String diseaseStage;

    @JsonProperty("DISEASE_STAGE_TYPE")
    private String diseaseStageType;

//    @JsonProperty("DISEASE_STATUS")
//    private Long diseaseStatus;

//    @JsonProperty("DISEASE_CREATED_ON")
//    private String diseaseCreatedOn;
//
//    @JsonProperty("DISEASE_UPDATED_ON")
//    private String diseaseUpdatedOn;

    @JsonProperty("DXSTATUS_ALIVE")
    private char dxstatusAlive;

    @JsonProperty("DXSTATUS_SYMPTOMS")
    private char dxstatusSymptoms;

    @JsonProperty("DXSTATUS_RECURRENCE")
    private char dxstatusRecurrence;

    @JsonProperty("DXSTATUS_METASTATIC")
    private char dxstatusMetastatic;

    @JsonProperty("DXSTATUS_CURATIVE")
    private char dxstatusCurative;

//    @JsonProperty("DXSTATUS_CREATED_ON")
//    private Timestamp dxstatusCreatedOn;

    @JsonProperty("DISEASE_ENCODER")
    private Long diseaseEncoder;

    public Disease mapToDisease(){
        Disease disease = new Disease();
        Histology histology = new Histology();
        MetastaticSite metastaticSite = new MetastaticSite();
        DiseaseStatus diseaseStatus = new DiseaseStatus();

        histology.setHistoPathology(histoPathology);
        histology.setHistoTumorSize(histoTumorSize);
        histology.setHistoTumorExtension(histoTumorExtension);
        histology.setHistoGrade(histoGrade);
        histology.setHistoNodePositive(histoNodePositive);
        histology.setHistoNodeHarvest(histoNodeHarvest);
        histology.setHistoMarginsNegative(histoMarginsNegative);
        histology.setHistoMarginsPositive(histoMarginsPositive);
        histology.setHistoStage(histoStage);
        histology.setHistoCreatedOn(Timestamp.valueOf(LocalDateTime.now()));
        histology.setHistoUpdatedOn(Timestamp.valueOf(LocalDateTime.now()));

        metastaticSite.setMetsDistantln(metsDistantln);
        metastaticSite.setMetsBone(metsBone);
        metastaticSite.setMetsLiver(metsLiver);
        metastaticSite.setMetsLung(metsLung);
        metastaticSite.setMetsBrain(metsBrain);
        metastaticSite.setMetsOvary(metsOvary);
        metastaticSite.setMetsSkin(metsSkin);
        metastaticSite.setMetsIntestine(metsIntestine);
        metastaticSite.setMetsOthers(metsOthers);
        metastaticSite.setMetsUnknown(metsUnknown);
        metastaticSite.setMetsNotes(metsNotes);
        metastaticSite.setMetsCreatedOn(Timestamp.valueOf(LocalDateTime.now()));
        metastaticSite.setMetsUpdatedOn(Timestamp.valueOf(LocalDateTime.now()));

        diseaseStatus.setDxstatusAlive(dxstatusAlive);
        diseaseStatus.setDxstatusSymptoms(dxstatusSymptoms);
        diseaseStatus.setDxstatusRecurrence(dxstatusRecurrence);
        diseaseStatus.setDxstatusMetastatic(dxstatusMetastatic);
        diseaseStatus.setDxstatusCurative(dxstatusCurative);
        diseaseStatus.setDxstatusCreatedOn(Timestamp.valueOf(LocalDateTime.now()));

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate localDate = LocalDate.parse(diseaseDiagnosisDate, formatter);
        disease.setDiseaseDiagnosisDate(Date.valueOf(localDate));
        disease.setDiseaseLaterality(diseaseLaterality);
        disease.setDiseaseHistology(histology);
        disease.setDiseaseExtent(diseaseExtent);
        disease.setDiseaseTumorSize(diseaseTumorSize);
        disease.setDiseaseLymphNode(diseaseLymphNode);
        disease.setDiseaseMetastatic(diseaseMetastatic);
        disease.setDiseaseMetastaticSite(metastaticSite);
        disease.setDiseaseMultiplePrimary(diseaseMultiplePrimary);
        disease.setDiseaseTstage(diseaseTstage);
        disease.setDiseaseNstage(diseaseNstage);
        disease.setDiseaseMstage(diseaseMstage);
        disease.setDiseaseGstage(diseaseGstage);
        disease.setDiseaseStage(diseaseStage);
        disease.setDiseaseStageType(diseaseStageType);
        disease.setDiseaseStatus(diseaseStatus);
        disease.setDiseaseCreatedOn(Timestamp.valueOf(LocalDateTime.now()));
        disease.setDiseaseUpdatedOn(Timestamp.valueOf(LocalDateTime.now()));
        return disease;
    }
}

package cancer.cssbackend.Entities.Requests;

import cancer.cssbackend.Entities.*;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddDiseaseRequest {
    //@JsonProperty("PATIENT_ID")
    //private Long patientID;

    //@JsonProperty("DISEASE_PRIMARY_SITE")
    //private Long bodySiteID;

    @JsonProperty("DISEASE_DIAGNOSISDATE")
    private String diseaseDiagnosisDate;

    //@JsonProperty("DISEASE_BASIS")
    //private Long basisID;

    @JsonProperty("DISEASE_LATERALITY")
    private String diseaseLaterality;

    //wala pa histology table
    //@Column(name = "DISEASE_HISTOLOGY")
    //private int diseaseHistology;

    @JsonProperty("DISEASE_EXTENT")
    private String diseaseExtent;

    @JsonProperty("DISEASE_TUMORSIZE")
    private int diseaseTumorSize;

    @JsonProperty("DISEASE_LYMPHNODE")
    private int diseaseLymphNode;

    @JsonProperty("DISEASE_METASTATIC")
    private char diseaseMetastatic;

    //need Add metastatic site request
    @JsonProperty("DISEASE_METASTATICSITE")
    private List<AddMetastaticSiteRequest> metastaticSites;

    @JsonProperty("DISEASE_MULTIPLEPRIMARY")
    private int diseaseMultiplePrimary;

    //need Add Metastaticsite Request
    @JsonProperty("DISEASE_OTHERSITE")
    private List<AddMetastaticSiteRequest> otherSites;

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

    @JsonProperty("DISEASE_STAGETYPE")
    private String diseaseStageType;

    @JsonProperty("DISEASE_STATUS")
    private List<AddDiseaseStatusRequest> diseaseStatuses;

    @JsonProperty("DISEASE_CREATEDON")
    private String diseaseCreatedOn;

    @JsonProperty("DISEASE_UPDATEDON")
    private String diseaseUpdatedOn;


    @JsonProperty("DISEASE_ENCODER")
    private Long diseaseEncoderID;

    public Disease mapToDisease(){
        Disease disease = new Disease();

        disease.setDiseaseExtent(this.diseaseExtent);
        disease.setDiseaseLaterality(this.diseaseLaterality);
        disease.setDiseaseDiagnosisDate(Date.valueOf(this.diseaseDiagnosisDate));
        disease.setDiseaseTumorSize(this.diseaseTumorSize);
        disease.setDiseaseLymphNode(this.diseaseLymphNode);
        disease.setDiseaseMetastatic(this.diseaseMetastatic);
        disease.setDiseaseMultiplePrimary(this.diseaseMultiplePrimary);
        disease.setDiseaseTstage(this.diseaseTstage);
        disease.setDiseaseNstage(this.diseaseNstage);
        disease.setDiseaseMstage(this.diseaseMstage);
        disease.setDiseaseGstage(this.diseaseGstage);
        disease.setDiseaseStage(this.diseaseStage);
        disease.setDiseaseStageType(this.diseaseStageType);
        disease.setDiseaseCreatedOn(Timestamp.valueOf(this.diseaseCreatedOn));
        disease.setDiseaseUpdatedOn(Timestamp.valueOf(this.diseaseUpdatedOn));



        //add loop for metastaticsites
        /*
        MetastaticSite metastaticSite = new MetastaticSite();
        List<MetastaticSite> metastaticSiteList = new ArrayList<>();

        if(!metastaticSites.isEmpty()){
            for(AddMetastaticSiteRequest addMetastaticSiteRequest : metastaticSites){
                metastaticSite.setMetsDistantln(addMetastaticSiteRequest.getMetsDistantLN());
                metastaticSite.setMetsBone(addMetastaticSiteRequest.getMetsBone());
                metastaticSite.setMetsLiver(addMetastaticSiteRequest.getMetsLiver());
                metastaticSite.setMetsLung(addMetastaticSiteRequest.getMetsLung());
                metastaticSite.setMetsBrain(addMetastaticSiteRequest.getMetsBrain());
                metastaticSite.setMetsOvary(addMetastaticSiteRequest.getMetsOvary());
                metastaticSite.setMetsSkin(addMetastaticSiteRequest.getMetsSkin());
                metastaticSite.setMetsIntestine(addMetastaticSiteRequest.getMetsIntestine());
                metastaticSite.setMetsOthers(addMetastaticSiteRequest.getMetsOthers());
                metastaticSite.setMetsNotes(addMetastaticSiteRequest.getMetsNotes());
                metastaticSite.setMetsUnknown(addMetastaticSiteRequest.getMetsUnknown());
                metastaticSite.setMetsCreatedOn(Timestamp.valueOf(addMetastaticSiteRequest.getMetsCreatedOn()));
                metastaticSite.setMetsUpdatedOn(Timestamp.valueOf(addMetastaticSiteRequest.getMetsUpdatedOn()));

                metastaticSite.set
            }

        }

        */
        //add loop for othersites
        //add loop for diseasestatuses
        return disease;
    }
}

package cancer.cssbackend.Entities.Requests;

import cancer.cssbackend.Entities.MetastaticSite;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.sql.Time;
import java.sql.Timestamp;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddMetastaticSiteRequest {

    @JsonProperty("METS_DISTANTLN")
    private char metsDistantLN;

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

    @JsonProperty("METS_CREATEDON")
    private String metsCreatedOn;

    @JsonProperty("METS_UPDATEDON")
    private String metsUpdatedOn;

    public MetastaticSite mapToMetastaticSite(){
        MetastaticSite metastaticSite = new MetastaticSite();

        metastaticSite.setMetsDistantln(this.metsDistantLN);
        metastaticSite.setMetsBone(this.metsBone);
        metastaticSite.setMetsLiver(this.metsLiver);
        metastaticSite.setMetsLung(this.metsLung);
        metastaticSite.setMetsBrain(this.metsBrain);
        metastaticSite.setMetsOvary(this.metsOvary);
        metastaticSite.setMetsSkin(this.metsSkin);
        metastaticSite.setMetsIntestine(this.metsIntestine);
        metastaticSite.setMetsOthers(this.metsOthers);
        metastaticSite.setMetsNotes(this.metsNotes);
        metastaticSite.setMetsUnknown(this.metsUnknown);
        metastaticSite.setMetsCreatedOn(Timestamp.valueOf(this.metsCreatedOn));
        metastaticSite.setMetsUpdatedOn(Timestamp.valueOf(this.metsUpdatedOn));

        return metastaticSite;
    }
}

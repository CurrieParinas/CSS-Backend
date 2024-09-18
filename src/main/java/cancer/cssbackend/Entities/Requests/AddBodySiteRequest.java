package cancer.cssbackend.Entities.Requests;

import cancer.cssbackend.Entities.BodySite;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddBodySiteRequest {
    @JsonProperty("BODYSITE_NAME")
    private String bodySiteName;

    public BodySite mapToBodySite(){
        BodySite bodySite = new BodySite();

        bodySite.setBodySiteName(this.bodySiteName);

        return bodySite;
    }
}

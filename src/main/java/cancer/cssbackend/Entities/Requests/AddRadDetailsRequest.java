package cancer.cssbackend.Entities.Requests;

import cancer.cssbackend.Entities.RadDetails;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddRadDetailsRequest {
    @JsonProperty("RAD_DETAILS_PROCEDURE")
    private String radDetailsProcedure;

    public RadDetails mapToRadDetails() {
        RadDetails radDetails = new RadDetails();
        radDetails.setRadDetailsProcedure(this.radDetailsProcedure);
        return radDetails;
    }
}

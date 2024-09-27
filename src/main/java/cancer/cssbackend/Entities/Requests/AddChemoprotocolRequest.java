package cancer.cssbackend.Entities.Requests;

import cancer.cssbackend.Entities.Chemoprotocol;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddChemoprotocolRequest {
    @JsonProperty("CHEMODRUGS")
    private String chemoDrugs;

    @JsonProperty("CHEMODOSAGE")
    private Long chemoDosage;

    @JsonProperty("CHEMONOCYCLE")
    private Long chemoNoCycle;

    @JsonProperty("CHEMODILUENT")
    private String chemoDiluent;

    public Chemoprotocol mapToChemotherapyProtocol() {
        Chemoprotocol protocol = new Chemoprotocol();
        protocol.setChemoDrugs(this.chemoDrugs);
        protocol.setChemoDosage(this.chemoDosage);
        protocol.setChemoNoCycle(this.chemoNoCycle);
        protocol.setChemoDiluent(this.chemoDiluent);
        return protocol;
    }
}

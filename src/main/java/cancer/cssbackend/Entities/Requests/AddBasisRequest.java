package cancer.cssbackend.Entities.Requests;

import cancer.cssbackend.Entities.Basis;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class AddBasisRequest {
    @JsonProperty("CATEGORY")
    private String category;

    @JsonProperty("SUBCATEGORY")
    private String subcategory;

    public Basis mapToBasis(){
        Basis basis = new Basis();

        basis.setCategory(this.category);
        basis.setSubcategory(this.subcategory);

        return basis;
    }
}

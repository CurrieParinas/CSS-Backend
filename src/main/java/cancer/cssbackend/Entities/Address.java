package cancer.cssbackend.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "ADDRESS")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Address {
    @Id
    @JsonProperty("ADDRESS_ID")
    @GeneratedValue(generator = "ADDRESS_SEQ")
    @SequenceGenerator(name="ADDRESS_SEQ", sequenceName = "ADDRESS_SEQ", allocationSize = 1)
    @Column(name = "ADDRESS_ID")
    private Long addressId;
    @JsonProperty("ADDRESS_NUMBER")
    private String addressNumber;
    @JsonProperty("ADDRESS_STREET")
    private String addressStreet;
    @JsonProperty("ADDRESS_CITY")
    private String addressCity;
    @JsonProperty("ADDRESS_REGION")
    private String addressRegion;
    @JsonProperty("ADDRESS_ZIPCODE")
    private String addressZipcode;
}

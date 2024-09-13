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
    private Long addressNumber;
    @JsonProperty("ADDRESS_STREET")
    private Long addressStreet;
    @JsonProperty("ADDRESS_CITY")
    private Long addressCity;
    @JsonProperty("ADDRESS_REGION")
    private Long addressRegion;
    @JsonProperty("ADDRESS_ZIPCODE")
    private Long addressZipcode;
}

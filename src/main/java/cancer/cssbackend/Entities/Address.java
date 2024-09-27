package cancer.cssbackend.Entities;

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
    @GeneratedValue(generator = "ADDRESS_SEQ")
    @SequenceGenerator(name="ADDRESS_SEQ", sequenceName = "ADDRESS_SEQ", allocationSize = 1)
    @Column(name = "ADDRESS_ID", nullable = false)
    private Long addressId;

    @Column(name = "ADDRESS_NUMBER")
    private String addressNumber;

    @Column(name = "ADDRESS_STREET")
    private String addressStreet;

    @Column(name = "ADDRESS_CITY")
    private String addressCity;

    @Column(name = "ADDRESS_REGION")
    private String addressRegion;

    @Column(name = "ADDRESS_ZIPCODE")
    private String addressZipcode;
}

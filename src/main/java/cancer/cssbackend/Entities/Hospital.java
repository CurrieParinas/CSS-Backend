package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "HOSPITAL")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Hospital {
    @Id
    @SequenceGenerator(name = "HOSPITAL_SEQ", sequenceName = "HOSPITAL_SEQ", allocationSize = 1)
    @Column(name = "HOSPITAL_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "HOSPITAL_SEQ")
    private Long hospitalId;

    @Column(name = "HOSPITAL_NAME")
    private String hospitalName;

    @OneToOne
    @JoinColumn(name = "HOSPITAL_ADDRESS", referencedColumnName = "ADDRESS_ID")
    private Address address;

    @Column(name = "HOSPITAL_CONTACT_NO")
    private String hospitalContactNo;
}

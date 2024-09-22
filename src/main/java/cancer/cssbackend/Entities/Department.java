package cancer.cssbackend.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity(name = "DEPARTMENT")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Department {
    @Id
    @SequenceGenerator(name = "DEPARTMENT_SEQ", sequenceName = "DEPARTMENT_SEQ", allocationSize = 1)
    @Column(name = "DEPARTMENT_ID", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "DEPARTMENT_SEQ")
    private Long departmentId;

    @Column(name = "DEPARTMENT_NAME")
    private String departmentName;
}

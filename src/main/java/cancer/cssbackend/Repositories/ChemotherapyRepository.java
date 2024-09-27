package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Chemotherapy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChemotherapyRepository extends JpaRepository<Chemotherapy, Long> {
}

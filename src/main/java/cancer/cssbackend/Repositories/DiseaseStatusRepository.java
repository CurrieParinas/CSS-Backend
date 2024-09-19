package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.DiseaseStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseStatusRepository extends JpaRepository<DiseaseStatus, Long> {
}

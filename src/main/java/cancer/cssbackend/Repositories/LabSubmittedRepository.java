package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.LabSubmitted;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabSubmittedRepository extends JpaRepository<LabSubmitted, Long> {
}

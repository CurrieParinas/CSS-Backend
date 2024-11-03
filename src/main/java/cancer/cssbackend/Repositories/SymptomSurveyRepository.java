package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.SymptomSurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymptomSurveyRepository extends JpaRepository<SymptomSurvey, Long> {
}

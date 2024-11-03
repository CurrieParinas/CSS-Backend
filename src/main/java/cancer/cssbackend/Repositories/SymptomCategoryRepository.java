package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.SymptomCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SymptomCategoryRepository extends JpaRepository<SymptomCategory, Long> {
}

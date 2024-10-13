package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.DiseaseOtherSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DiseaseOtherSiteRepository extends JpaRepository<DiseaseOtherSite, Long> {
}

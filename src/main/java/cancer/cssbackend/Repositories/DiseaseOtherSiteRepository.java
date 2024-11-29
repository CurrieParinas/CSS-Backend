package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.DiseaseOtherSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DiseaseOtherSiteRepository extends JpaRepository<DiseaseOtherSite, Long> {
    @Query(value="SELECT * FROM DiseaseOtherSite dos WHERE dos.DISEASE_ID = :diseaseID", nativeQuery = true)
    List<DiseaseOtherSite> fetchOtherSitesByDiseaseID(@Param("diseaseID") Long diseaseID);
}

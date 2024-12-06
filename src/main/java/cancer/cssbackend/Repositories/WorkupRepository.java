package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Projections.WorkupProjection;
import cancer.cssbackend.Entities.Workup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkupRepository extends JpaRepository<Workup, Long> {

    @Query(value="SELECT WORKUP_NAME, WORKUP_FREQUENCY, WORKUP_TYPE, WORKUP_INDICATION, WORKUP_DURATION, WORKUP_REFERRAL FROM WORKUP WHERE CANCER_TYPE = :cancerType", nativeQuery = true)
    List<WorkupProjection> getWorkupProjection(@Param("cancerType") Long cancerType);
}

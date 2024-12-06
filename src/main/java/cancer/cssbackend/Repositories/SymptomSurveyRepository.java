package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Projections.SymptomProjection;
import cancer.cssbackend.Entities.SymptomSurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SymptomSurveyRepository extends JpaRepository<SymptomSurvey, Long> {
    @Query(value="SELECT ss.SYMPTOMSURVEY_ID, ss.SYMPTOM_NAME FROM SYMPTOMSURVEY ss WHERE ss.CANCER_TYPE = :cancerType AND ss.SYMPTOM_CATEGORY = 1", nativeQuery = true)
    List<SymptomProjection> fetchSymptomNameByCancerTypeLOCALSYMPTOM(@Param("cancerType") Long cancerType);

    @Query(value="SELECT ss.SYMPTOMSURVEY_ID, ss.SYMPTOM_NAME FROM SYMPTOMSURVEY ss WHERE ss.CANCER_TYPE = :cancerType AND ss.SYMPTOM_CATEGORY = 2", nativeQuery = true)
    List<SymptomProjection> fetchSymptomNameByCancerTypeSYSTEMICSYMPTOM(@Param("cancerType") Long cancerType);

    @Query(value="SELECT ss.SYMPTOMSURVEY_ID, ss.SYMPTOM_NAME FROM SYMPTOMSURVEY ss WHERE ss.CANCER_TYPE = :cancerType AND ss.SYMPTOM_CATEGORY = 3", nativeQuery = true)
    List<SymptomProjection> fetchSymptomNameByCancerTypeQOL(@Param("cancerType") Long cancerType);

    @Query(value="SELECT ss.SYMPTOMSURVEY_ID, ss.SYMPTOM_NAME FROM SYMPTOMSURVEY ss WHERE ss.CANCER_TYPE = :cancerType AND ss.SYMPTOM_CATEGORY = 4", nativeQuery = true)
    List<SymptomProjection> fetchSymptomNameByCancerTypeTSE(@Param("cancerType") Long cancerType);
}

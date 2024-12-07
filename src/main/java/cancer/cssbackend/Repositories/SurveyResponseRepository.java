package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.SurveyResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SurveyResponseRepository extends JpaRepository<SurveyResponse, Long> {
    @Query(value="SELECT * FROM SURVEYRESPONSE WHERE PATIENT_ID = :patientID AND DOCTOR_ID = :doctorID", nativeQuery = true)
    public SurveyResponse fetchExistingSurveyResponse(@Param("patientID") Long patientID, @Param("doctorID") Long doctorID);
}

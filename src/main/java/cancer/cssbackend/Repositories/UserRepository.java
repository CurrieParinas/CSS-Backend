package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserEmailAndUserPassword(String email, String password);

    @Query(value = "SELECT U.* FROM USERTABLE U JOIN PATIENT P ON P.USER_ID = U.USER_ID WHERE P.PATIENT_ID = :patientid", nativeQuery = true)
    User getUserByPatientID(@Param("patientid") Long patientid);

}

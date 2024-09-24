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

    @Query(value = "SELECT UT.USER_ID, UT.USER_LASTNAME, UT.USER_FIRSTNAME, UT.USER_ID, USER_LASTNAME, USER_FIRSTNAME, USER_MIDDLENAME, USER_EMAIL, USER_PASSWORD, USER_GENDER, USER_MARITAL_STATUS, USER_BIRTHDATE, USER_BIRTHPLACE, USER_ADDRESS, USER_CONTACTNO, USER_ROLE, USER_ACCESS, USER_IS_VERIFIED, USER_STATUS, USER_CREATED_ON, USER_UPDATED_ON, USER_ENCODER, D.DOCTOR_ID, D.DOCTOR_HOSPITAL, D.DOCTOR_DEPARTMENT, D.DOCTOR_SPECIALTY, D.DOCTOR_E_SIGNATURE, D.DOCTOR_LICENSE_NUMBER, D.DOCTOR_LICENSE_EXP_DATE, D.DOCTOR_SCHEDULE FROM USERTABLE UT FULL JOIN DOCTOR D ON UT.USER_ID=D.USER_ID WHERE LOWER(USER_PASSWORD)='gwp030677' AND LOWER(USER_EMAIL)='gwparker@gmail.com'", nativeQuery = true)
    Map<String, Object> returnValidDoctor(@Param("email") String email, @Param("password") String password);


}

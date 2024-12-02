package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.CheckupSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckupScheduleRepository extends JpaRepository<CheckupSchedule, Long> {
    @Query(value="SELECT * FROM CHECKUPSCHEDULE WHERE DOCTOR_ID = :doctorID", nativeQuery = true)
    List<CheckupSchedule> fetchAllByDoctor(@Param(("doctorID")) Long doctorID);

    @Query(value="SELECT * FROM CHECKUPSCHEDULE WHERE DOCTOR_ID = :doctorID AND CHECKUPCONFIRMED_DATE = TO_DATE(:date, 'YYYY-MM-DD')", nativeQuery = true)
    List<CheckupSchedule> fetchAllByDoctorAndDate(@Param(("doctorID")) Long doctorID, @Param("date") String date);
}

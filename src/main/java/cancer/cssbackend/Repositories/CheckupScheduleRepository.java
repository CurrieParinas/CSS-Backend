package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.CheckupSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckupScheduleRepository extends JpaRepository<CheckupSchedule, Long> {
}

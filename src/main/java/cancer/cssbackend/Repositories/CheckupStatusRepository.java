package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.CheckupStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckupStatusRepository extends JpaRepository<CheckupStatus, Long> {
}

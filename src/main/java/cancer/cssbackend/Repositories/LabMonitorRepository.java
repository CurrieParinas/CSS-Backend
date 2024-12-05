package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.LabMonitor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LabMonitorRepository extends JpaRepository<LabMonitor, Long> {
    List<LabMonitor> findByStatus(String status);
}

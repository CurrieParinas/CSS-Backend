package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.LabsDownload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LabsDownloadRepository extends JpaRepository<LabsDownload, Long> {
}

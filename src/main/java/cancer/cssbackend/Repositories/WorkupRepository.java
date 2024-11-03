package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Workup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkupRepository extends JpaRepository<Workup, Long> {
}

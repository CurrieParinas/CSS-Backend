package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Checkup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckupRepository extends JpaRepository<Checkup, Long> {
}

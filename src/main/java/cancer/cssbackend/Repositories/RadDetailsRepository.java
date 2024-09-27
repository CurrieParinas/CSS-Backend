package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.RadDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RadDetailsRepository extends JpaRepository<RadDetails, Long> {
}

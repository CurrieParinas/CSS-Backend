package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Onboard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OnboardRepository extends JpaRepository<Onboard, Long> {

}

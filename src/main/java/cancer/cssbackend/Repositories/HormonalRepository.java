package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Hormonal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HormonalRepository extends JpaRepository<Hormonal, Long> {
}

package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Radiotherapy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RadiotherapyRepository extends JpaRepository<Radiotherapy, Long> {
}

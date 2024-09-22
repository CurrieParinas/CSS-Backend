package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Histology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistologyRepository extends JpaRepository<Histology, Long> {
}

package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.PathologyDim;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PathologyDimRepository extends JpaRepository<PathologyDim, Long> {
}

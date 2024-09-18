package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Basis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BasisRepository extends JpaRepository<Basis, Long> {
}

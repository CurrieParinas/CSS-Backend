package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Immunotherapy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImmunotherapyRepository extends JpaRepository<Immunotherapy, Long> {
}

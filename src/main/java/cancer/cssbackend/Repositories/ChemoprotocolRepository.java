package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Chemoprotocol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChemoprotocolRepository extends JpaRepository<Chemoprotocol, Long> {
}

package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.RXType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RxTypeRepository extends JpaRepository<RXType, Long> {
}

package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Access;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccessRepository extends JpaRepository<Access, Long> {

}

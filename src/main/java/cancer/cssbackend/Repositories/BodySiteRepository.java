package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.BodySite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BodySiteRepository extends JpaRepository<BodySite, Long> {

}

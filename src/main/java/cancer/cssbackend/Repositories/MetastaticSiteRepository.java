package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.MetastaticSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetastaticSiteRepository extends JpaRepository<MetastaticSite, Long> {
}

package cancer.cssbackend.Repositories;

import cancer.cssbackend.Entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}

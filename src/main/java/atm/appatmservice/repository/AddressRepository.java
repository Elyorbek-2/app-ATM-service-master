package atm.appatmservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import atm.appatmservice.entity.Address;
import atm.appatmservice.entity.Role;

@Repository
public interface AddressRepository extends JpaRepository<Address, Integer> {
}

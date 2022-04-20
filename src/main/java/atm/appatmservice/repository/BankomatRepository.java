package atm.appatmservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import atm.appatmservice.entity.Banknote;
import atm.appatmservice.entity.Bankomat;

@RepositoryRestResource(path = "bankomat",collectionResourceRel = "list")
public interface BankomatRepository extends JpaRepository<Bankomat, Integer> {
}

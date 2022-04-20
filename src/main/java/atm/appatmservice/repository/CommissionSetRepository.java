package atm.appatmservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import atm.appatmservice.entity.CommissionSet;

@RepositoryRestResource(path = "commissionSet",collectionResourceRel = "list")
public interface CommissionSetRepository extends JpaRepository<CommissionSet, Integer> {
}

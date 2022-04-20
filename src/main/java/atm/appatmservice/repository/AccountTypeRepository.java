package atm.appatmservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import atm.appatmservice.entity.AccountType;
import atm.appatmservice.entity.enums.AccountTypeName;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Integer> {
    AccountType findByName(AccountTypeName name);
}

package atm.appatmservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import atm.appatmservice.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Integer> {
    Bank findByName(String name);
}

package atm.appatmservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import atm.appatmservice.entity.Currency;

@Repository
public interface CurrencyRepository extends JpaRepository<Currency, Integer> {
}

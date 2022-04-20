package atm.appatmservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import atm.appatmservice.entity.ReplenishAtmHistory;

import java.util.List;
import java.util.UUID;

@Repository
public interface ReplenishAtmHistoryRepository extends JpaRepository<ReplenishAtmHistory, UUID> {
    List<ReplenishAtmHistory> findAllByBankomatId(Integer bankomat_id);
}

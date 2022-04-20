package atm.appatmservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import atm.appatmservice.entity.CardType;

import java.util.Collection;
import java.util.List;

@Repository
public interface CardTypeRepository extends JpaRepository<CardType, Integer> {
    List<CardType> findAllByIdIn(Collection<Integer> id);
}

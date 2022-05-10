package stockMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stockMgmt.entity.Dealer;

import java.util.Map;

public interface DealerRepository extends JpaRepository<Dealer, Long> {
    Dealer findByName(String name);


}

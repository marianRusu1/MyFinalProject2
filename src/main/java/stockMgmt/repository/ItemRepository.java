package stockMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stockMgmt.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}

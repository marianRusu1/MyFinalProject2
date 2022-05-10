package stockMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stockMgmt.entity.ContactDetails;
import stockMgmt.entity.Item;

public interface ContactDetailsRepository extends JpaRepository<ContactDetails, Long> {
}

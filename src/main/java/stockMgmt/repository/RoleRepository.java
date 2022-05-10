package stockMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stockMgmt.entity.Dealer;
import stockMgmt.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}

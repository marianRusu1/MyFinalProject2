package stockMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import stockMgmt.entity.Dealer;
import stockMgmt.entity.MyUser;

import java.util.List;

public interface UserRepository extends JpaRepository<MyUser, Long> {

    MyUser findByUsernameIgnoreCase(String username);

    MyUser findByEmail(String username);


}

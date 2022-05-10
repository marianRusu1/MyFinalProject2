package stockMgmt.service;

import stockMgmt.entity.MyUser;
import org.springframework.stereotype.Service;
import stockMgmt.entity.MyUser;

import java.util.List;

@Service
public interface UserService {

    MyUser findUserByEmail(String email);

    MyUser findUserByUserName(String userName);

    boolean findUserByUserNameAndPassword(String userName, String password);

    List<MyUser> findAll();

    void deleteById(long id);

    MyUser saveUser(MyUser u);
}

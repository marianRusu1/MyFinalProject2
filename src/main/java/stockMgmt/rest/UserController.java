package stockMgmt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import stockMgmt.repository.DealerRepository;
import stockMgmt.repository.UserRepository;

@Controller
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/user/all")
    public String getAllUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "all-users";
    }

}

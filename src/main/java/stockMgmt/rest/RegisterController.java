package stockMgmt.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import stockMgmt.entity.MyUser;
import stockMgmt.entity.Role;
import stockMgmt.service.UserService;

import java.util.Set;

@Controller
public class RegisterController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/register")
    public String registerForm(Model model) {
        MyUser user = new MyUser();
        model.addAttribute("user", user);
        return "register";
    }



    @PostMapping(value = "/register")
    public String registerUser(@ModelAttribute("user") @RequestBody MyUser user, Model model) {

        try {
            if (user.getPassword().equalsIgnoreCase(user.getPasswordConfirm())) {
                user.setRoles(Set.of(new Role("ROLE_USER")));
                userService.saveUser(user);
            }
        } catch (Exception e) {
            if (user.getPassword().equalsIgnoreCase(user.getPasswordConfirm())) {
                user.setRoles(Set.of(new Role("ROLE_USER")));
                userService.saveUser(user);
            }
        }
        return "login";
    }
}
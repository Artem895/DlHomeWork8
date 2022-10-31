package core.controler;

import core.model.User;
import core.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class Controler {

    private final UserService userService;
    private final UserValidator userValidator;

    @Autowired
    public Controler(UserService userService, UserValidator userValidator) {
        this.userService = userService;
        this.userValidator = userValidator;
    }

    @GetMapping("/login")
    public String getLoginPage(){
        return "login";

    }
    @GetMapping("/good")
    public String getSuccess(){
        return "good";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {

        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "registration";
        }
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder(12);
        userForm.setPassword(bCryptPasswordEncoder.encode(userForm.getPassword()));
        userService.save(userForm);
        return "redirect:good";
    }
    @GetMapping("/registration")
    public String registration(Model model) {
        model.addAttribute("userForm", new User());
        return "registration";
    }


}

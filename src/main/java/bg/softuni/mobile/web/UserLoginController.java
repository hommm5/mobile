package bg.softuni.mobile.web;
import bg.softuni.mobile.model.dto.UserLoginDTO;
import bg.softuni.mobile.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserLoginController {
    private UserService userService;

    public UserLoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users/login")
    public String login() {
        System.out.println("");
        return "auth-login";
    }

    @GetMapping("/users/logout")
    public String logout(){
        userService.logout();
        return "redirect:/";
    }

    @PostMapping("/user/login")
    public String login(UserLoginDTO userLoginDTO) {
        System.out.println("User is logged:" + userService.login(userLoginDTO));
        return "redirect:/";
    }
}

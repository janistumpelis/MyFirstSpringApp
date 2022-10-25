package io.codelex.myfirstspringapp.users;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {

    private UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    public void login() {
        //userService.getUser(login)
    }

}

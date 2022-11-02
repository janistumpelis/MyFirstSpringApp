package io.codelex.myfirstspringapp.users;

import io.codelex.myfirstspringapp.users.domain.User;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping(path = "/users")
    public List<String> getUsers(@RequestParam(required = false) String usernameSearch) {
        return service.getUserList(usernameSearch);
    }

    @PostMapping("/user")
    public void saveUser(@RequestBody @Valid User user) {
        service.saveUser(user);
    }

    @GetMapping(path = "/user/{userId}")
    public User getUser(@PathVariable("userId") Long usrId) {
        return service.getUser(usrId);
    }

    @PostMapping(path = "/users")
    public List<String> saveUsers() {
        return service.getUserList(null);
    }

    @GetMapping("/users/greeting")
    public String getGreetingMessage() {
        return service.getGreetingMessage();
    }

}

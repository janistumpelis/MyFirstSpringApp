package io.codelex.myfirstspringapp.users;

import io.codelex.myfirstspringapp.config.MyApplicationConfig;
import io.codelex.myfirstspringapp.users.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository repository;

    private MyApplicationConfig myApplicationConfig;


    public UserService(UserRepository repository, MyApplicationConfig myApplicationConfig) {
        this.repository = repository;
        this.myApplicationConfig = myApplicationConfig;
    }

    public void saveUser(User user) {
        this.repository.saveUser(user);
    }

    public List<String> getUserList(String usernameSearch) {
        List<User> filteredUsers = repository.getUserList();
        if (usernameSearch != null) {
            filteredUsers = filteredUsers.stream().filter(u -> u.getUsername().startsWith(usernameSearch)).toList();
        }
        return convertUsers(filteredUsers);
    }

    public User getUser(Long id) {
        return repository.getUserList()
                .stream().filter(u -> u.getId().equals(id))
                .findFirst().orElseThrow(() -> new RuntimeException("User not found!"));
    }

    private List<String> convertUsers(List<User> users) {
        return users.stream().map(usr -> usr.getId() + " - " + usr.getUsername()).toList();
    }

    public String getGreetingMessage() {
        return myApplicationConfig.getGreeting() + " "
                + myApplicationConfig.getName() + " "
                + myApplicationConfig.getGoodbye() + " "
                + myApplicationConfig.getLastGoodbye();
    }

}

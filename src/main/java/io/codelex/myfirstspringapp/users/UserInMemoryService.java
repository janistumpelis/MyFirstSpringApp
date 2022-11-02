package io.codelex.myfirstspringapp.users;

import io.codelex.myfirstspringapp.config.MyApplicationConfig;
import io.codelex.myfirstspringapp.users.domain.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@ConditionalOnProperty(prefix = "myapp", name = "appmode", havingValue = "inmemory")
public class UserInMemoryService implements UserService {

    private UserInMemoryRepository repository;

    private MyApplicationConfig myApplicationConfig;


    public UserInMemoryService(UserInMemoryRepository repository, MyApplicationConfig myApplicationConfig) {
        this.repository = repository;
        this.myApplicationConfig = myApplicationConfig;
    }

    @Override
    public void saveUser(User user) {
        if (repository.getUserList().stream().anyMatch(u -> u.equals(user))) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "User already exists!");
        }

        this.repository.saveUser(user);
    }

    @Override
    public List<String> getUserList(String usernameSearch) {
        List<User> filteredUsers = repository.getUserList();
        if (usernameSearch != null) {
            filteredUsers = filteredUsers.stream().filter(u -> u.getUsername().startsWith(usernameSearch)).toList();
        }
        return convertUsers(filteredUsers);
    }

    @Override
    public User getUser(Long id) {
        return repository.getUserList().stream().filter(u -> u.getId().equals(id))
                .findFirst().orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Lietotājs nav atrasts!"));
    }

    private List<String> convertUsers(List<User> users) {
        return users.stream().map(usr -> usr.getId() + " - " + usr.getUsername()).toList();
    }

    @Override
    public String getGreetingMessage() {
        return myApplicationConfig.getGreeting() + " "
                + myApplicationConfig.getName() + " "
                + myApplicationConfig.getGoodbye() + " "
                + myApplicationConfig.getLastGoodbye();
    }

}

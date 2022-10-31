package io.codelex.myfirstspringapp.users;

import io.codelex.myfirstspringapp.users.domain.User;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@ConditionalOnProperty(prefix = "myapp", name = "appmode", havingValue = "database")
public class UserDBService implements UserService {

    @Override
    public void saveUser(User user) {
        throw new RuntimeException("DB mode not implemented!");
    }

    @Override
    public List<String> getUserList(String usernameSearch) {
        throw new RuntimeException("DB mode not implemented!");
    }

    @Override
    public User getUser(Long id) {
        throw new RuntimeException("DB mode not implemented!");
    }

    @Override
    public String getGreetingMessage() {
        throw new RuntimeException("DB mode not implemented!");
    }
}

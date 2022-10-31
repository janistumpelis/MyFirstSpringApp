package io.codelex.myfirstspringapp.users;

import io.codelex.myfirstspringapp.users.domain.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);

    List<String> getUserList(String usernameSearch);

    User getUser(Long id);

    String getGreetingMessage();

}

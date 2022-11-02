package io.codelex.myfirstspringapp.users;

import io.codelex.myfirstspringapp.users.domain.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class UserControllerTest {

    @Mock
    UserService service;

    @InjectMocks
    UserController controller;

    @Test
    public void getUsersTest() {
        String username = "bob";
        controller.getUsers(username);
        Mockito.verify(service).getUserList(username);
    }

    @Test
    public void saveUsersTest() {
        User user = new User(1L, "Steve");
        controller.saveUser(user);
        Mockito.verify(service).saveUser(user);
    }

}

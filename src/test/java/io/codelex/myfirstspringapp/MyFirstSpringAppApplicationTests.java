package io.codelex.myfirstspringapp;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.codelex.myfirstspringapp.users.UserController;
import io.codelex.myfirstspringapp.users.UserInMemoryRepository;
import io.codelex.myfirstspringapp.users.UserInMemoryService;
import io.codelex.myfirstspringapp.users.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class MyFirstSpringAppApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    UserController userController;

    @Autowired
    UserInMemoryRepository repository;

    @Autowired
    UserInMemoryService service;

    @Test
    void getAllUsersTest() {
        List<String> allUsers = userController.getUsers(null);
        int realUserCount = repository.getUserList().size();
        Assertions.assertEquals(realUserCount, allUsers.size());
    }

    @Test
    void saveUserTest() {
        User user = new User(4L, "Steve");
        userController.saveUser(user);

        User savedUser = userController.getUser(4L);

        Assertions.assertEquals(user, savedUser);
    }

    @Test
    void saveUserApiTest() throws Exception {
        User user = new User(5L, "Rob");

        ObjectMapper jsonObjectMapper = new ObjectMapper();

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/user")
                .with(user("janis").password("codelex"))
                .content(jsonObjectMapper.writeValueAsString(user))
                .contentType(MediaType.APPLICATION_JSON);

        mvc.perform(requestBuilder).andExpect(status().is(200)).andReturn();

        User savedUser = service.getUser(user.getId());

        Assertions.assertEquals(user, savedUser);
    }

}

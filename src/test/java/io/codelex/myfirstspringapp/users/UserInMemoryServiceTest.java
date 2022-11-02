package io.codelex.myfirstspringapp.users;

import io.codelex.myfirstspringapp.config.MyApplicationConfig;
import io.codelex.myfirstspringapp.users.domain.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class UserInMemoryServiceTest {

    @Mock
    UserInMemoryRepository repository;

    @Mock
    MyApplicationConfig myApplicationConfig;

    @InjectMocks
    UserInMemoryService service;

    public void setupRepositoryMock() {
        List<User> testUsers = new ArrayList<>();
        testUsers.add(new User(1L, "johnny"));
        testUsers.add(new User(2L, "lisa"));
        Mockito.doAnswer(i -> testUsers).when(repository).getUserList();
    }

    @Test
    public void testGetUserList() {
        //Given
        setupRepositoryMock();
        //When
        List<String> result = service.getUserList("john");
        //Then
        Assertions.assertEquals("1 - johnny", result.get(0));
    }

    @Test
    public void testGetAllUsers() {
        //Given
        setupRepositoryMock();
        List<String> result = service.getUserList(null);
        Assertions.assertEquals(2, result.size());
    }

    @Test
    public void testGetUser() {
        //Given
        setupRepositoryMock();
        //When
        User user = service.getUser(1L);
        //Then
        Assertions.assertEquals(1L, user.getId());
        Assertions.assertEquals("johnny", user.getUsername());
    }


    @Test
    public void testGetNonExistingUser() {
        //Given
        setupRepositoryMock();
        Long nonExistingId = 9L;
        //When
        ResponseStatusException exception = Assertions.assertThrows(ResponseStatusException.class, () -> service.getUser(nonExistingId));
        //Then
        Assertions.assertEquals(404, exception.getRawStatusCode());
        Assertions.assertEquals("Lietotājs nav atrasts!", exception.getReason());
    }

    @Test
    public void testGetGreetingMessage() {
        //Given
        Mockito.doAnswer(i -> "A").when(myApplicationConfig).getGreeting();
        Mockito.doAnswer(i -> "B").when(myApplicationConfig).getName();
        Mockito.doAnswer(i -> "C").when(myApplicationConfig).getGoodbye();
        Mockito.doAnswer(i -> "D").when(myApplicationConfig).getLastGoodbye();
        //When
        String result = service.getGreetingMessage();
        //Then
        Assertions.assertEquals("A B C D", result);
    }

}

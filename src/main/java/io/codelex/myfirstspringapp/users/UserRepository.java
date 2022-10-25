package io.codelex.myfirstspringapp.users;

import org.springframework.stereotype.Repository;
import io.codelex.myfirstspringapp.users.domain.User;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    //Only for demo
    //Usually repository uses database
    private List<User> userList = new ArrayList<>();

    public UserRepository() {
        //Also should not do this
        userList.add(new User(1L, "john"));
        userList.add(new User(2L, "peter"));
        userList.add(new User(3L, "lisa"));
    }

    //This should return data from database
    public List<User> getUserList() {
        return userList;
    }

    public void saveUser(User user) {
        userList.add(user);
    }
}

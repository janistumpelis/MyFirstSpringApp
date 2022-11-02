package io.codelex.myfirstspringapp.users.domain;

import javax.validation.constraints.NotBlank;
import java.util.Objects;

//DTO (data transfer object)
public class User {

    /*
    JSON representation:
    {
        "id": 123,
        "username": "john"
    }

    */

    private Long id;

    @NotBlank
    private String username;

    public User() {

    }

    public User(Long id, String username) {
        this.id = id;
        this.username = username;
    }

    public Long getId() { //JSON => id: 123
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() { //JSON => username: 123
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id.equals(user.id) && username.equals(user.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username);
    }
}

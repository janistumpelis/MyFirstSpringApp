package io.codelex.myfirstspringapp.users.domain;

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
}

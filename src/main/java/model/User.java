package model;


import java.io.Serializable;
import java.time.LocalDateTime;

public class User implements Serializable {

    private String login;
    private String password;
    private String email;
    private LocalDateTime registered;

    public User(String login, String password, String email) {
        this.login = login;
        this.password = password;
        this.email = email;
        this.registered = LocalDateTime.now();
    }

    public User() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDateTime getRegistered() {
        return registered;
    }

    public void setRegistered(LocalDateTime registered) {
        this.registered = registered;
    }
}

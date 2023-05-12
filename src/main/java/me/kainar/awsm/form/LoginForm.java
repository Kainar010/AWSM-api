package me.kainar.awsm.form;

import org.springframework.stereotype.Component;

@Component
public class LoginForm {
    private String username;
    private String authString;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAuthString() {
        return authString;
    }

    public void setAuthString(String authString) {
        this.authString = authString;
    }
}

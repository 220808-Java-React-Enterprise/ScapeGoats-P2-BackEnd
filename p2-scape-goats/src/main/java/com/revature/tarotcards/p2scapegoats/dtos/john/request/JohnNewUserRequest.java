package com.revature.tarotcards.p2scapegoats.dtos.john.request;

public class JohnNewUserRequest {

    private String username;

    private String password;

    private String role_id;



    public JohnNewUserRequest() {

    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

package com.revature.tarotcards.p2scapegoats.dtos.request.melissa;

public class NewUserRequest {

    private String id;
    private String username;
    private String firstname;
    private String lastname;
    private String password;
    private String email;
    private String role_id;
    private String consultant;

    public NewUserRequest() {
    }

    public NewUserRequest(String id, String username, String firstname, String lastname, String password, String email, String role_id, String consultant) {
        this.id = id;
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.password = password;
        this.email = email;
        this.role_id = role_id;
        this.consultant = consultant;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
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

    public String getConsultant() {
        return consultant;
    }

    public void setConsultant(String consultant) {
        this.consultant = consultant;
    }

    @Override
    public String toString() {
        return "NewUserRequest{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", role_id='" + role_id + '\'' +
                ", consultant='" + consultant + '\'' +
                '}';
    }
}

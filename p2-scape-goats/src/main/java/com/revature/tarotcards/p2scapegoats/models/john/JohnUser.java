package com.revature.tarotcards.p2scapegoats.models.john;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name="users")
public class JohnUser {

    @Id
    private String id;

    @Column(name="username", nullable = false)
    private String username;

    @Column(name="password", nullable = false)
    private String password;

    @Column(name="firstname", nullable = true)
    private String firstName;


    @Column(name="lastname", nullable = true)
    private String lastName;

    @Column(name="email", nullable = true)
    private String email;

    @Column(name="role_id", insertable = false, updatable = false)
    private String role_id;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    @JsonBackReference
    private JohnRole role;

    @Column(name="consultant", nullable = true)
    private boolean consultant;

    public JohnUser(String id, String username, String password, Optional<JohnRole> role) {

    }

    public JohnUser() {

    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public JohnUser(String id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public JohnUser(String id, String username, String password, JohnRole role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public JohnRole getRole() {
        return role;
    }

    public void setRole(JohnRole role) {
        this.role = role;
    }

    public boolean isConsultant() {
        return consultant;
    }

    public void setConsultant(boolean consultant) {
        this.consultant = consultant;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", role=" + role +
                ", consultant=" + consultant +
                '}';
    }
}

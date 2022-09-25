package com.revature.tarotcards.p2scapegoats.models.melissa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "consultants")
public class Consultants {
    @Id
    private String id;
    @Column(name="firstname", nullable = false)
    private String firstname;
    @Column(name="lastname", nullable = false)
    private String lastname;

    @ManyToMany
    @JoinTable(
            name = "consultations",
            joinColumns = @JoinColumn(name="consultant_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    List<Users> users;

    public Consultants() {
    }

    public Consultants(String id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public void addUser(Users user) {
        if(users == null) {
            users = new ArrayList<>();
        }
        users.add(user);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public List<Users> getUsers() {
        return users;
    }

    public void setUsers(List<Users> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Consultants{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}

package com.revature.tarotcards.p2scapegoats.models.john;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="roles")
public class JohnRole {

    @Id
    private String role_id;

    @Column(name="title", nullable = false)
    private String title;

    @OneToMany(
            mappedBy = "role",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<JohnUser> users;

    public JohnRole() {
        //users = new ArrayList<>();
    }

    public JohnRole(String role_id, String title) {
        this.role_id = role_id;
        this.title = title;
    }

    public JohnRole(String role_id, String title, List<JohnUser> users) {
        this.role_id = role_id;
        this.title = title;
        this.users = users;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<JohnUser> getUsers() {
        return users;
    }

    public void setUsers(List<JohnUser> users) {
        this.users = users;
    }


    @Override
    public String toString() {
        return "Role{" +
                "role_id='" + role_id + '\'' +
                ", title='" + title + '\'' +
                ", users=" + users +
                '}';
    }
}

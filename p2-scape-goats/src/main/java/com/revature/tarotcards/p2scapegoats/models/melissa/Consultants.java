package com.revature.tarotcards.p2scapegoats.models.melissa;

import javax.persistence.*;
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

    @ManyToMany(
            mappedBy = "consultants"
    )
    List<Users> users;

    public Consultants() {
    }

    public Consultants(String id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
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

    @Override
    public String toString() {
        return "Consultants{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }
}

package com.revature.tarotcards.p2scapegoats.models.melissa;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="roles")
public class Roles {

    @Id //primary key
    private String role_id;

    @Column(name="title", nullable = false, unique = true)
    private String title;

    /*
     * @JsonManagedReference is the forward part of reference – the one that gets serialized normally.
     *      If we do not specify this, we will have an infinite recursion
     *          (Go ahead and try it without this, I dare you!)
     *
     * mappedby = Once we have defined the owning side of the relationship,
     *      Hibernate already has all the information it needs to map that relationship in our database.
     *
     * FetchType.EAGER = Eager Loading is a design pattern in which data initialization occurs on the spot.
     * FetchType.LAZY = Lazy Loading is a design pattern that we use to defer initialization of an object as long as it's possible.
     *
     * CascadeType.ALL = persistence will propagate (cascade) all EntityManager operations (PERSIST, REMOVE, REFRESH, MERGE, DETACH) to the relating entities.
     */

    @OneToMany (
        mappedBy = "role",   //define the referencing side (non-owning side)
        fetch = FetchType.EAGER,
        cascade = CascadeType.ALL
    )
    @JsonManagedReference  //Head
    private List<Users> users;

    public Roles() {
       users = new ArrayList<>();  //not sure if this is needed here
    }

    public Roles(String role_id, String title) {
        this.role_id = role_id;
        this.title = title;
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

    @Override
    public String toString() {
        return "Roles{" +
                "role_id='" + role_id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

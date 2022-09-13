package com.revature.tarotcards.p2scapegoats.models.melissa;



import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")
public class Users {
    @Id
    private String user_id;
    @Column(name = "username", nullable = false)
    private String username;
    @Column(name = "firstname", nullable = false)
    private String firstName;
    @Column(name = "lastname", nullable = false)
    private String lastName;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "email")
    private String email;
    /*@Column(name = "role_id", nullable = false)
    private String role_id;*/                           //because I'm creating it below where I'm joining tables
    @Column(name = "consultant", nullable = false)      //it's a foreign key (cont from above)
    private Boolean consultant = false;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)  //my foreign key
    @JsonBackReference
    private Roles role;

    @OneToMany (
            mappedBy = "user",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<Readings> readings;

    @ManyToMany
    @JoinTable(
            name = "consultations",
            joinColumns = @JoinColumn(name="user_id"),
            inverseJoinColumns = @JoinColumn(name = "consultant_id")

    )
    List<Consultants> consultants;



    public Users(){

    }

    public Users(String user_id, String username, String firstName, String lastName, String password, String email, String role_id, Boolean consultant) {
        this.user_id = user_id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
        this.consultant = consultant;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public Boolean getConsultant() {
        return consultant;
    }

    public void setConsultant(Boolean consultant) {
        this.consultant = consultant;
    }

    @Override
    public String toString() {
        return "Users{" +
                "user_id='" + user_id + '\'' +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", consultant=" + consultant +
                '}';
    }
}

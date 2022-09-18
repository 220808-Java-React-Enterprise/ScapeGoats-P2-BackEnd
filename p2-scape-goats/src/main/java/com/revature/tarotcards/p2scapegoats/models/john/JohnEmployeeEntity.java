package com.revature.tarotcards.p2scapegoats.models.john;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="employees")
public class JohnEmployeeEntity {

    @Id
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="gender")
    private String gender;

    @Column(name="dateOfBirth")
    private String dateOfBirth;

    @Column(name="address")
    private String address;

    public JohnEmployeeEntity() {

    }
}

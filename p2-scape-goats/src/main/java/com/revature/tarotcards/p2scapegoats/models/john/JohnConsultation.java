package com.revature.tarotcards.p2scapegoats.models.john;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="consultation")
public class JohnConsultation {

    @Id
    @Column(name="user_id", nullable = false)
    private String user_id;

    @Column(name="consultant_id", nullable = false)
    private String consultant_id;

    @Column(name="reviews", nullable = true)
    private int reviews;

    @Column(name="description", nullable = true)
    private String description;

}

package com.revature.tarotcards.p2scapegoats.models.melissa;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "readings")
public class Readings {
    @Id
    private String id;
    @Column(name = "card1", nullable = false)
    private String card1;
    @Column(name = "card2", nullable = false)
    private String card2;
    @Column(name = "card3", nullable = false)
    private String card3;
    @Column(name = "description", nullable = false)
    private String description;
    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    @JsonBackReference
    private Users user;

    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    @JsonBackReference
    private Categories category;



}

package com.revature.tarotcards.p2scapegoats.models.melissa;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name = "questions")
public class Questions {

    @Id
    private String id;

    @Column(name = "question", nullable = false)
    private String question;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonBackReference
    private Categories categories;



    public Questions() {
    }
}

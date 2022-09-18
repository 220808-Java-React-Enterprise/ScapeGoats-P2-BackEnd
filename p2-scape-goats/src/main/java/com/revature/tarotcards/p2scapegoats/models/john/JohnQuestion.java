package com.revature.tarotcards.p2scapegoats.models.john;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table(name="questions")
public class JohnQuestion {

    @Id
    private String id;


    @Column(name="question", nullable = false)
    private String question;


//    @Column(name="category_id", insertable = false, updatable = false)
//    private String category_id;


    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonBackReference
    private JohnCategory category;

    public JohnQuestion() {

    }

    public JohnQuestion(String id, String question, JohnCategory category) {
        this.id = id;
        this.question = question;
        this.category = category;
    }

    public JohnQuestion(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public JohnCategory getCategory() {
        return category;
    }

    public void setCategory(JohnCategory category) {
        if(category != null) {
            this.category = category;
        }
    }

    @Override
    public String toString() {
        return "Question{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", category=" + category +
                '}';
    }
}

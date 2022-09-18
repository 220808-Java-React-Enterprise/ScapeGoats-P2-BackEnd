package com.revature.tarotcards.p2scapegoats.models.john;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="categories")
public class JohnCategory {

    @Id
    private String id;

    @Column(name="category", nullable = false)
    private String category;

    @OneToMany(
            mappedBy = "category",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<JohnQuestion> questions;


    @OneToMany(
            mappedBy = "category",
            fetch = FetchType.LAZY,
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private List<JohnReading> readings;

    public JohnCategory() {

    }

    public List<JohnReading> getReadings() {
        return readings;
    }

    public void setReadings(List<JohnReading> readings) {
        this.readings = readings;
    }

    public JohnCategory(String id, String category) {
        this.id = id;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public List<JohnQuestion> getQuestions() {
        return questions;
    }

    public void setQuestions(List<JohnQuestion> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id='" + id + '\'' +
                ", category='" + category + '\'' +
                ", questions=" + questions +
                ", readings=" + readings +
                '}';
    }
}

package com.revature.tarotcards.p2scapegoats.models.melissa;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="categories")
public class Categories {

    @Id // Primary Key
    private String category_id;

    @Column(name="category", nullable = false)
    private String category;

    @OneToMany(
            mappedBy = "category",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private Set<Readings> readings;

    @OneToMany(
            mappedBy = "categories",
            fetch = FetchType.EAGER,
            cascade = CascadeType.ALL
    )
    @JsonManagedReference
    private Set<Questions> questions;

    public Categories() {
    }

    public Categories(String category_id, String category) {
        this.category_id = category_id;
        this.category = category;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Readings> getReadings() {
        return readings;
    }

    public void setReadings(Set<Readings> readings) {
        this.readings = readings;
    }

    public Set<Questions> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Questions> questions) {
        this.questions = questions;
    }

    @Override
    public String toString() {
        return "Categories{" +
                "category_id='" + category_id + '\'' +
                ", category='" + category + '\'' +
                ", readings=" + readings +
                ", questions=" + questions +
                '}';
    }
}

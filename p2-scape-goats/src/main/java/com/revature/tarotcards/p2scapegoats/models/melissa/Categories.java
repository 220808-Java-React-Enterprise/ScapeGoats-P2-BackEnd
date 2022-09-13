package com.revature.tarotcards.p2scapegoats.models.melissa;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Categories {

    @Id // Primary Key
    private String category_id;

    @Column(name="category", nullable = false)
    private String category;

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

    @Override
    public String toString() {
        return "Categories{" +
                "category_id='" + category_id + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

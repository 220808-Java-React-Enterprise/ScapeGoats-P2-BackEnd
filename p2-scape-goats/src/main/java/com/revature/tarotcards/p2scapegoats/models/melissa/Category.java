package com.revature.tarotcards.p2scapegoats.models.melissa;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {

    @Id // Primary Key
    private String category_id;

    @Column(name="category", nullable = false)
    private String name;

    public Category() {

    }

    public Category(String category_id, String name) {
        this.category_id = category_id;
        this.name = name;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Category{" +
                "category_id='" + category_id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

package com.revature.tarotcards.p2scapegoats.models.melissa;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Timestamp;
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
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name="user_id", nullable = false)
    @JsonBackReference
    private Users user;

    @ManyToOne
    @JoinColumn(name="category_id", nullable = false)
    @JsonBackReference
    private Categories category;

    public Readings() {
    }

    public Readings(String id, String card1, String card2, String card3) {
        this.id = id;
        this.card1 = card1;
        this.card2 = card2;
        this.card3 = card3;
    }

    public Readings(String id, String card1, String card2, String card3, String description, Timestamp date, Users user, Categories category) {
        this.id = id;
        this.card1 = card1;
        this.card2 = card2;
        this.card3 = card3;
        this.description = description;
        this.date = date;
        this.user = user;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCard1() {
        return card1;
    }

    public void setCard1(String card1) {
        this.card1 = card1;
    }

    public String getCard2() {
        return card2;
    }

    public void setCard2(String card2) {
        this.card2 = card2;
    }

    public String getCard3() {
        return card3;
    }

    public void setCard3(String card3) {
        this.card3 = card3;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Categories getCategory() {
        return category;
    }

    public void setCategory(Categories category) {
        this.category = category;
    }



    @Override
    public String toString() {
        return "Readings{" +
                "id='" + id + '\'' +
                ", card1='" + card1 + '\'' +
                ", card2='" + card2 + '\'' +
                ", card3='" + card3 + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", user=" + user +
                ", category=" + category +
                '}';
    }
}

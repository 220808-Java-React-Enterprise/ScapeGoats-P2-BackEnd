package com.revature.tarotcards.p2scapegoats.models.john;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name="readings")
public class JohnReading {

    @Id
    @Column(name="reading_id")
    private String reading_id;

    @Column(name="card1", nullable = false)
    private String card1;

    @Column(name="card2", nullable = false)
    private String card2;

    @Column(name="card3", nullable = false)
    private String card3;

    @Column(name="description", nullable = true)
    private String description;

//    reimburstment.setSubmitted(Timestamp.valueOf(LocalDateTime.now()));
    @Column(name="date", nullable = true)
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    @JsonBackReference
    private JohnCategory category;


    public JohnReading() {

    }

    public JohnReading(String id, String card1, String card2, String card3) {
        this.reading_id = id;
        this.card1 = card1;
        this.card2 = card2;
        this.card3 = card3;
    }

    public String getReading_id() {
        return reading_id;
    }

    public void setReading_id(String reading_id) {
        this.reading_id = reading_id;
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

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public JohnCategory getCategory() {
        return category;
    }

    public void setCategory(JohnCategory category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Reading{" +
                "reading_id='" + reading_id + '\'' +
                ", card1='" + card1 + '\'' +
                ", card2='" + card2 + '\'' +
                ", card3='" + card3 + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", category=" + category +
                '}';
    }
}

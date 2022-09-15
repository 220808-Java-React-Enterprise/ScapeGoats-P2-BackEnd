package com.revature.tarotcards.p2scapegoats.models.melissa;

import javax.persistence.*;

@Entity
public class Consultation {
    @EmbeddedId
    ConsultationReview id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name="user_id")
    Users users;

    @ManyToOne
    @MapsId("consultantId")
    @JoinColumn(name="consultant_id")
    Consultants consultants;

    int reviews;

    String description;

    public Consultation() {
    }

    public Consultation(ConsultationReview id, Users users, Consultants consultants, int reviews, String description) {
        this.id = id;
        this.users = users;
        this.consultants = consultants;
        this.reviews = reviews;
        this.description = description;
    }

    public ConsultationReview getId() {
        return id;
    }

    public void setId(ConsultationReview id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Consultants getConsultants() {
        return consultants;
    }

    public void setConsultants(Consultants consultants) {
        this.consultants = consultants;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Consultation{" +
                "id=" + id +
                ", users=" + users +
                ", consultants=" + consultants +
                ", reviews=" + reviews +
                ", description='" + description + '\'' +
                '}';
    }
}

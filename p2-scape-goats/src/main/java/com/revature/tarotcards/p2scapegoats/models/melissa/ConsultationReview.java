package com.revature.tarotcards.p2scapegoats.models.melissa;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class ConsultationReview implements Serializable {
    //composite key for many to many table
    @Column(name = "user_id", nullable = false)
    String user_id;
    @Column(name = "consultant_id", nullable = false)
    String consultant_id;

    public ConsultationReview() {
    }

    public ConsultationReview(String user_id, String consultant_id) {
        this.user_id = user_id;
        this.consultant_id = consultant_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getConsultant_id() {
        return consultant_id;
    }

    public void setConsultant_id(String consultant_id) {
        this.consultant_id = consultant_id;
    }

    @Override
    public String toString() {
        return "ConsultationReview{" +
                "user_id='" + user_id + '\'' +
                ", consultant_id='" + consultant_id + '\'' +
                '}';
    }
}

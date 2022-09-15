package com.revature.tarotcards.p2scapegoats.dtos.request.melissa;

import java.util.Date;

public class NewReadingRequest {

    private String id;
    private String card1;
    private String card2;
    private String card3;
    private String description;
    private Date date;
    private String user_id;
    private String category_id;

    public NewReadingRequest() {
    }

    public NewReadingRequest(String id, String card1, String card2, String card3, String description, Date date, String user_id, String category_id) {
        this.id = id;
        this.card1 = card1;
        this.card2 = card2;
        this.card3 = card3;
        this.description = description;
        this.date = date;
        this.user_id = user_id;
        this.category_id = category_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
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

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "NewReadingRequest{" +
                "id='" + id + '\'' +
                ", card1='" + card1 + '\'' +
                ", card2='" + card2 + '\'' +
                ", card3='" + card3 + '\'' +
                ", description='" + description + '\'' +
                ", date=" + date +
                ", user_id='" + user_id + '\'' +
                ", category_id='" + category_id + '\'' +
                '}';
    }
}

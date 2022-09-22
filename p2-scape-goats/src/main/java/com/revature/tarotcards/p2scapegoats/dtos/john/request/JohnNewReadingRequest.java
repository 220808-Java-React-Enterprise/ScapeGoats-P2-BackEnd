package com.revature.tarotcards.p2scapegoats.dtos.john.request;

public class JohnNewReadingRequest {

    private String user_id;
    private String reading_id;
    private String card1;

    private String card2;
    private String card3;
    private String description;

    private String category;

    private String category_id;


    public JohnNewReadingRequest() {

    }

    public String getUser_id() {
        return user_id;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "JohnNewReadingRequest{" +
                "user_id='" + user_id + '\'' +
                ", reading_id='" + reading_id + '\'' +
                ", card1='" + card1 + '\'' +
                ", card2='" + card2 + '\'' +
                ", card3='" + card3 + '\'' +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}

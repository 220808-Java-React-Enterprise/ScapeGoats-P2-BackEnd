package com.revature.tarotcards.p2scapegoats.dtos.request.melissa;

public class NewQuestionRequest {

    private String id;
    private String question;
    private String category_id;

    public NewQuestionRequest() {
    }

    public NewQuestionRequest(String id, String question, String category_id) {
        this.id = id;
        this.question = question;
        this.category_id = category_id;
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

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "NewQuestionRequest{" +
                "id='" + id + '\'' +
                ", question='" + question + '\'' +
                ", category_id='" + category_id + '\'' +
                '}';
    }
}

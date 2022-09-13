package com.revature.tarotcards.p2scapegoats.dtos.request.melissa;

public class NewQuestionRequest {

    private String id;
    private String question;

    public NewQuestionRequest() {
    }

    public NewQuestionRequest(String id, String question) {
        this.id = id;
        this.question = question;
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
                '}';
    }
}

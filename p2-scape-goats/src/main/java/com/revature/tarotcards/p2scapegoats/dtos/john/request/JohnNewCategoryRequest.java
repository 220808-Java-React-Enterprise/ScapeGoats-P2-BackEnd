package com.revature.tarotcards.p2scapegoats.dtos.john.request;

public class JohnNewCategoryRequest {

    private String id;

    private String category;

    public JohnNewCategoryRequest() {
    }

    public JohnNewCategoryRequest(String id, String category) {
        this.id = id;
        this.category = category;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

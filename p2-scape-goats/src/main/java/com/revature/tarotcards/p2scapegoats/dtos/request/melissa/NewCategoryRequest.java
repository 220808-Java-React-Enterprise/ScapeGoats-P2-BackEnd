package com.revature.tarotcards.p2scapegoats.dtos.request.melissa;


public class NewCategoryRequest {

    private String category_id;
    private String category;

    /*public NewCategoryRequest() {
    }*/

    public NewCategoryRequest(String category_id, String category) {
        this.category_id = category_id;
        this.category = category;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory_id() {
        return category_id;
    }



    @Override
    public String toString() {
        return "NewCategoryRequest{" +
                "category_id='" + category_id + '\'' +
                ", category='" + category + '\'' +
                '}';
    }

}

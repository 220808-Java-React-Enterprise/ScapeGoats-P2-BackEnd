package com.revature.tarotcards.p2scapegoats.dtos.request.melissa;

public class NewRoleRequest {

    private String role_id;
    private String title;

    public NewRoleRequest() {
    }

    public NewRoleRequest(String role_id, String title) {
        this.role_id = role_id;
        this.title = title;
    }

    public String getRole_id() {
        return role_id;
    }

    public void setRole_id(String role_id) {
        this.role_id = role_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "NewRoleRequest{" +
                "role_id='" + role_id + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}

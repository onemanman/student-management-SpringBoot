package com.galaxy.studentmanagement.model;

public class StudentResponse {
    private String message;
    public StudentResponse(String message) {
        this.message = message;
    }

    public String getDeleteMessage() {
        return message;
    }

    public void setDeleteMessage(String message) {
        this.message = message;
    }
}

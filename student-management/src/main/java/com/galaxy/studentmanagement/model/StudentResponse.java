package com.galaxy.studentmanagement.model;

public class StudentResponse {
    private String deleteMessage;
    public StudentResponse(String deleteMessage) {
        this.deleteMessage = deleteMessage;
    }

    public String getDeleteMessage() {
        return deleteMessage;
    }

    public void setDeleteMessage(String deleteMessage) {
        this.deleteMessage = deleteMessage;
    }
}

package com.galaxy.studentmanagement.exception;

import java.util.Set;

public class SetAPIException {
    private int status;
    private Set<String> messages;

    public SetAPIException(int status, Set<String> Messages) {
        this.status = status;
        this.messages = Messages;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Set<String> getMessages() {
        return messages;
    }

    public void setMessages(Set<String> messages) {
        this.messages = messages;
    }
}

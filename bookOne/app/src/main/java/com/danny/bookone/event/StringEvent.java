package com.danny.bookone.event;

public class StringEvent {
    String message;

    public StringEvent(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

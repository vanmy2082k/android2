package com.example.vanmy.model;

public class Count {
    private String action;

    public Count(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "Count{" +
                "action='" + action + '\'' +
                '}';
    }
}

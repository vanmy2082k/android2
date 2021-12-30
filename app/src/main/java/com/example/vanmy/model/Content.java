package com.example.vanmy.model;

import com.google.gson.annotations.SerializedName;

public class Content {
    @SerializedName("counter_online")
    private int counterOnline;

    public int getCounterOnline() {
        return counterOnline;
    }
}

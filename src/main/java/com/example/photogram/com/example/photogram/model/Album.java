package com.example.photogram.com.example.photogram.model;

import com.google.gson.annotations.SerializedName;

public class Album {
    @SerializedName("userId")
    int userId;
    @SerializedName("id")
    int id;
    @SerializedName("title")
    String title;

    public Album(int userId, int id, String title) {
        this.userId = userId;
        this.id = id;
        this.title = title;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

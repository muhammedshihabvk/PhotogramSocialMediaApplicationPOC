package com.example.photogram.com.example.photogram.model;

import com.google.gson.annotations.SerializedName;

public class Post {
    @SerializedName("userId")
    int userId;
    @SerializedName("id")
    int id;
    @SerializedName("title")
    String title;
    @SerializedName("body")
    String body;

    public Post() {
    }

    public Post(int userId, int id, String title, String body) {
        this.userId = userId;
        this.id = id;
        this.title = title;
        this.body = body;
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

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

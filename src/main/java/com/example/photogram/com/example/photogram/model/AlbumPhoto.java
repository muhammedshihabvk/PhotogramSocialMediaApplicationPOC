package com.example.photogram.com.example.photogram.model;

import com.google.gson.annotations.SerializedName;

public class AlbumPhoto {

    @SerializedName("Albums")
    int albums;
    @SerializedName("id")
    int id;
    @SerializedName("title")
    String title;
    @SerializedName("url")
    String url;
    @SerializedName("thumbnailUrl")
    String thumbnailUrl;

    public AlbumPhoto(int albums, int id, String title, String url, String thumbnailUrl) {
        this.albums = albums;
        this.id = id;
        this.title = title;
        this.url = url;
        this.thumbnailUrl = thumbnailUrl;
    }

    public int getAlbums() {
        return albums;
    }

    public void setAlbums(int albums) {
        this.albums = albums;
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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
}

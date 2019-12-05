package com.example.photogram.com.example.photogram.retrofit;

import com.example.photogram.com.example.photogram.model.Album;
import com.example.photogram.com.example.photogram.model.AlbumPhoto;
import com.example.photogram.com.example.photogram.model.Post;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GetDataService {

    @GET("/posts")
    Call<List<Post>> getAllPost();

    @GET("/posts/{id}")
    Call<Post> getPostById(@Path("id") int id);

    @GET("/albums")
    Call<List<Album>> getAllAlbum();

    @GET("/albums/1/photos")
    Call<List<AlbumPhoto>> getAllAlbumPhotos();

}

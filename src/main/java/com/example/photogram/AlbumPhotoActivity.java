package com.example.photogram;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photogram.com.example.photogram.adapter.AlbumAdapter;
import com.example.photogram.com.example.photogram.adapter.AlbumPhotoAdapter;
import com.example.photogram.com.example.photogram.model.AlbumPhoto;

import com.example.photogram.com.example.photogram.retrofit.GetDataService;
import com.example.photogram.com.example.photogram.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumPhotoActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    AlbumPhotoAdapter albumPhotoAdapter;
    List<AlbumPhoto> albumList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.album_photo_view);


        GetDataService service = RetrofitClient.getRetrofitInstance().create(GetDataService.class);
        Call<List<AlbumPhoto>> call = service.getAllAlbumPhotos();
        call.enqueue(new Callback<List<AlbumPhoto>>() {
            @Override
            public void onResponse(Call<List<AlbumPhoto>> call, Response<List<AlbumPhoto>> response) {
                generateDataList(response.body());
            }
            @Override
            public void onFailure(Call<List<AlbumPhoto>> call, Throwable t) {
                Toast.makeText(AlbumPhotoActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });

    }
    private void generateDataList(List<AlbumPhoto> albumList) {
        recyclerView = findViewById(R.id.albumphotoviewrecyclerview);
        albumPhotoAdapter = new AlbumPhotoAdapter(albumList,AlbumPhotoActivity.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(AlbumPhotoActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(albumPhotoAdapter);
    }
}

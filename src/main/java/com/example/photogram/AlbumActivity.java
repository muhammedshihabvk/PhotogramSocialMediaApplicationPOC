package com.example.photogram;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photogram.com.example.photogram.adapter.AlbumAdapter;
import com.example.photogram.com.example.photogram.model.Album;
import com.example.photogram.com.example.photogram.retrofit.GetDataService;
import com.example.photogram.com.example.photogram.retrofit.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AlbumActivity  extends AppCompatActivity {

    RecyclerView recyclerView;
    AlbumAdapter albumAdapter;
    List<Album> albumList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.album_view_main);



        GetDataService service = RetrofitClient.getRetrofitInstance().create(GetDataService.class);
        Call<List<Album>> call = service.getAllAlbum();
        call.enqueue(new Callback<List<Album>>() {
            @Override
            public void onResponse(Call<List<Album>> call, Response<List<Album>> response) {
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Album>> call, Throwable t) {
                Toast.makeText(AlbumActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataList(List<Album> albumList) {
        recyclerView = findViewById(R.id.albumphotosviewrecyclerview);
        albumAdapter = new AlbumAdapter(albumList,AlbumActivity.this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(AlbumActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(albumAdapter);
    }
}

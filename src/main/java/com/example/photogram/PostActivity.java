package com.example.photogram;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photogram.com.example.photogram.adapter.PostAdapter;
import com.example.photogram.com.example.photogram.model.Post;
import com.example.photogram.com.example.photogram.retrofit.GetDataService;
import com.example.photogram.com.example.photogram.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.post_view_main);
        List<Post> postlist = new ArrayList<Post>();

//        Post obj1 = new Post(1,2,"shihab","india is my country");
//        postlist.add(obj1);
//        Post obj2 = new Post(1,3,"shuaib","all indians are my brothers and sisters.i love my country.and am proud of its rich and very higt each");
//        postlist.add(obj2);
//        generateDataList(postlist);

        GetDataService service = RetrofitClient.getRetrofitInstance().create(GetDataService.class);
        Call<List<Post>> call = service.getAllPost();
        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                generateDataList(response.body());
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                Toast.makeText(PostActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void generateDataList(List<Post> photoList) {
        recyclerView = findViewById(R.id.albumphotosviewrecyclerview);
        postAdapter = new PostAdapter(photoList,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(PostActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(postAdapter);
    }
}

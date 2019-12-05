package com.example.photogram;

import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.photogram.com.example.photogram.model.Post;
import com.example.photogram.com.example.photogram.retrofit.GetDataService;
import com.example.photogram.com.example.photogram.retrofit.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class FullPostViewActivity extends AppCompatActivity {

    TextView titleText,bodyText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.post_full_view);

        final String result = getIntent().getStringExtra("postId");
//        Log.d("love", "null"+result);

        titleText = findViewById(R.id.postFullTitleTextView);
        bodyText = findViewById(R.id.postFullBodyTextView);

        GetDataService service = RetrofitClient.getRetrofitInstance().create(GetDataService.class);
        Call<Post> call = service.getPostById(Integer.parseInt(result));
        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                titleText.setText(response.body().getTitle());
                bodyText.setText(response.body().getBody());
            }
            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                Toast.makeText(FullPostViewActivity.this, "Something went wrong...Please try later!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}

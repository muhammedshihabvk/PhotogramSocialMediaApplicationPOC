package com.example.photogram;

import android.content.Context;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class AlbumPhotoFullViewActivity extends AppCompatActivity {

    TextView textView;
    ImageView imageView;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        getSupportActionBar().hide(); // hide the title bar
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN); //enable full screen
        setContentView(R.layout.album_full_photo_view);

        textView = findViewById(R.id.fullphototitlevtext);
        imageView = findViewById(R.id.fullphotoview);

        final String title = getIntent().getStringExtra("title");
        final  String url = getIntent().getStringExtra("urlLink");

        textView.setText(title);
        Glide.with(AlbumPhotoFullViewActivity.this)
                .asBitmap()
                .load(url)
                .into(imageView);

    }
}

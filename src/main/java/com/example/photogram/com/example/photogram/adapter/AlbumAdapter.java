package com.example.photogram.com.example.photogram.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.load.engine.cache.InternalCacheDiskCacheFactory;
import com.example.photogram.AlbumActivity;
import com.example.photogram.AlbumPhotoActivity;
import com.example.photogram.FullPostViewActivity;
import com.example.photogram.R;
import com.example.photogram.com.example.photogram.model.Album;
import com.example.photogram.com.example.photogram.model.Post;

import java.util.List;

public class AlbumAdapter extends RecyclerView.Adapter<AlbumAdapter.AlbumViewHolder> {

    private List<Album> dataList;
    private Context context;

    public AlbumAdapter(List<Album> dataList,Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @NonNull
    @Override
    public AlbumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.album_row_layout, parent, false);
        return new AlbumAdapter.AlbumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AlbumViewHolder holder, int position) {
        holder.albumTxtTitle.setText(dataList.get(position).getTitle());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AlbumPhotoActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class AlbumViewHolder extends  RecyclerView.ViewHolder{
        TextView albumTxtTitle;
        ConstraintLayout parentLayout;

        public AlbumViewHolder(@NonNull View itemView) {
            super(itemView);
            albumTxtTitle = itemView.findViewById(R.id.albumtitletext);
            parentLayout = itemView.findViewById(R.id.album_parent_layout);
        }
    }
}

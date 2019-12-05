package com.example.photogram.com.example.photogram.adapter;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.photogram.AlbumPhotoFullViewActivity;
import com.example.photogram.FullPostViewActivity;
import com.example.photogram.R;
import com.example.photogram.com.example.photogram.model.AlbumPhoto;
import com.example.photogram.com.example.photogram.model.Post;

import java.util.List;

public class AlbumPhotoAdapter extends RecyclerView.Adapter<AlbumPhotoAdapter.PhotoViewHolder> {

    private List<AlbumPhoto> dataList;
    private Context context;


    public AlbumPhotoAdapter(List<AlbumPhoto> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }

    @Override
    public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.album_photo_row_layout, parent, false);
        return new AlbumPhotoAdapter.PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder( PhotoViewHolder holder, int position) {

        holder.titleTxt.setText(dataList.get(position).getTitle());

        Glide.with(context)
                .asBitmap()
                .load(dataList.get(position).getUrl())
                .into(holder.imgView);
        final int pos = position;
        holder.constraintLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ProgressDialog dialog = new ProgressDialog(context);
//                dialog.setMessage("Please wait.....");
//                dialog.show();
                Intent intent = new Intent(context, AlbumPhotoFullViewActivity.class);
                intent.putExtra("title",String.valueOf(dataList.get(pos).getTitle()));
                intent.putExtra("urlLink",String.valueOf(dataList.get(pos).getUrl()));
//              intent.putExtra("postId","100");
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public class PhotoViewHolder  extends  RecyclerView.ViewHolder{
        TextView titleTxt;
        ImageView imgView;
        ConstraintLayout constraintLayout;
        public PhotoViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTxt = itemView.findViewById(R.id.photoRowTitleText);
            imgView = itemView.findViewById(R.id.albumPhotoRow);
            constraintLayout=itemView.findViewById(R.id.photoRowLayout);
        }
    }
}

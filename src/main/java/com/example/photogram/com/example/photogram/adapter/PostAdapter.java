package com.example.photogram.com.example.photogram.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.photogram.FullPostViewActivity;
import com.example.photogram.R;
import com.example.photogram.com.example.photogram.model.Post;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder> {

    private List<Post> dataList;
    private Context context;

    public PostAdapter(List<Post> dataList, Context context) {
        this.dataList = dataList;
        this.context = context;
    }
    public class PostViewHolder extends RecyclerView.ViewHolder {

        TextView txtTitle,txtbody;
        ConstraintLayout parentLayout;

        public PostViewHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.albumtitletext);
            txtbody = itemView.findViewById(R.id.bodytext);
            parentLayout= itemView.findViewById(R.id.parent_layout);
        }
    }

    @Override
    public PostViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.post_row_layout, parent, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(PostAdapter.PostViewHolder holder, final int position) {
        holder.txtTitle.setText(dataList.get(position).getTitle());
        holder.txtbody.setText(dataList.get(position).getBody());

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, FullPostViewActivity.class);
                intent.putExtra("postId",String.valueOf(dataList.get(position).getId()));
//              intent.putExtra("postId","100");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return dataList.size();
    }

}

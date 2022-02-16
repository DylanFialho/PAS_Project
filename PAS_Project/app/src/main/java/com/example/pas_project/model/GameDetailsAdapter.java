package com.example.pas_project.model;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pas_project.R;

import java.util.ArrayList;
import java.util.List;

public class GameDetailsAdapter extends RecyclerView.Adapter<GameDetailsAdapter.ViewHolder> {

    private List<Review> reviewList;
    private Context context;
    private LayoutInflater layoutInflater;

    public GameDetailsAdapter(Context context){
        this.context = context;
        this.reviewList = new ArrayList<>();
        this.layoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public GameDetailsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.review_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameDetailsAdapter.ViewHolder holder, int position) {
        Review review = this.reviewList.get(position);

        holder.textEmail.setText(review.getUser().getEmail());
        holder.textReview.setText(review.getContent());
    }

    @Override
    public int getItemCount() {
        return this.reviewList.size();
    }

    public void update(List<Review> newReviewList) {
        this.reviewList = newReviewList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private View root;
        private TextView textEmail;
        private TextView textReview;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.root = itemView;
            this.textEmail = itemView.findViewById(R.id.textUserReview);
            this.textReview = itemView.findViewById(R.id.textReview);
        }
    }
}

package com.example.pas_project.model;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pas_project.R;

import java.util.List;

public class GameItemAdapter extends RecyclerView.Adapter<GameItemAdapter.ViewHolder>{
    private final Context context;
    private List<Game> gameList;

    public GameItemAdapter(Context context, List<Game> gameList) {
        this.context = context;
        this.gameList = gameList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.store_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Game game = this.gameList.get(position);
        Glide.with(context).load(game.getImgURL()).into(holder.getGameImageView());
        holder.getTextViewTitle().setText(game.getTitle());
        holder.getTextViewPrice().setText(String.valueOf(game.getPrice()));

        holder.getRoot().setOnClickListener(view -> {

        });
    }

    @Override
    public int getItemCount() {
        return this.gameList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View root;
        private ImageView gameImageView;
        private TextView textViewTitle;
        private TextView textViewPrice;

        public ViewHolder(@NonNull View gameView) {
            super(gameView);
            this.root = gameView;
            this.gameImageView = gameView.findViewById(R.id.storeItemImage);
            this.textViewTitle = gameView.findViewById(R.id.storeTextView);
            this.textViewPrice = gameView.findViewById(R.id.storePriceTextView);
        }

        public View getRoot() {
            return root;
        }

        public ImageView getGameImageView(){
            return  gameImageView;
        }

        public TextView getTextViewTitle() {
            return textViewTitle;
        }

        public TextView getTextViewPrice() {
            return textViewPrice;
        }
    }
}
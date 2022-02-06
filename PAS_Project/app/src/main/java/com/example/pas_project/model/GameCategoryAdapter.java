package com.example.pas_project.model;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pas_project.R;

import java.util.List;

public class GameCategoryAdapter extends RecyclerView.Adapter<GameCategoryAdapter.ViewHolder>{

    private final Context context;
    private List<Game> gameList;

    public GameCategoryAdapter(Context context, List<Game> gameList) {
        this.context = context;
        this.gameList = gameList;
    }

    @NonNull
    @Override
    public GameCategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.category_store_item, parent, false);
        return new GameCategoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GameCategoryAdapter.ViewHolder holder, int position) {

        GameItemAdapter gameItemAdapter = new GameItemAdapter(context, gameList);
        holder.recyclerView.setAdapter(gameItemAdapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);

    }

    @Override
    public int getItemCount() {
        return this.gameList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View root;
        private TextView categoryTextView;
        private RecyclerView recyclerView;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            this.categoryTextView = root.findViewById(R.id.categoryTextView);
            this.recyclerView = root.findViewById(R.id.recyclerViewCategory );
        }

        public View getRoot() {
            return root;
        }

        public TextView getCategoryTextView() {
            return categoryTextView;
        }

        public RecyclerView getRecyclerView() {
            return recyclerView;
        }
    }
}

package com.example.pas_project.Fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.pas_project.R;
import com.example.pas_project.model.GameCart;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {


    private final Context context;
    private List<GameCart> gameList;

    public CartAdapter(Context context, List<GameCart> gameList) {
        this.context = context;
        this.gameList = gameList;
    }

    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(this.context).inflate(R.layout.cart_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {

        GameCart game = this.gameList.get(position);

        Glide.with(context).load(game.getImgURL()).into(holder.getGameImageView());
        holder.getTextViewTitle().setText(game.getTitle());
        holder.getTextViewPrice().setText(String.valueOf(game.getPrice()));

        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, game.getTitle() + "eliminado", Toast.LENGTH_SHORT).show();
                updateList(gameList);
            }
        });

    }

    @Override
    public int getItemCount() {
        return this.gameList.size();
    }

    public void updateList(List<GameCart> newGames) {
        this.gameList = newGames;
        this.notifyItemRangeInserted(0, newGames.size());
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private View root;
        private ImageView gameImageView;
        private TextView textViewTitle;
        private TextView textViewPrice;
        private Button button;

        public ViewHolder(@NonNull View gameView) {
            super(gameView);
            this.root = gameView;
            this.gameImageView = gameView.findViewById(R.id.imageCart);
            this.textViewTitle = gameView.findViewById(R.id.textNameCart);
            this.textViewPrice = gameView.findViewById(R.id.textNamePrice);
            this.button = gameView.findViewById(R.id.buttonCart);
        }

        public View getRoot() {
            return root;
        }

        public ImageView getGameImageView() {
            return gameImageView;
        }

        public TextView getTextViewTitle() {
            return textViewTitle;
        }

        public TextView getTextViewPrice() {
            return textViewPrice;
        }

        public Button getButton() {
            return button;
        }
    }
}

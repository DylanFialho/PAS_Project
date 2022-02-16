package com.example.pas_project.model;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.pas_project.R;
import com.example.pas_project.ViewModel.GameDetailsViewModel;

import java.util.List;

public class GameDetailsActivity extends AppCompatActivity {

    private static final String KEY_GAMEID = "GAMEID";
    private static final String TAG = "GameDetailsActivity";
    private GameDetailsViewModel gameDetailsViewModel;

    private ImageView gameImage;
    private TextView gameTitle;
    private TextView gamePrice;
    private TextView gameDescription;
    private RecyclerView recyclerReview;

    private long id;

    public static void startActivity(Context context, long id){
        Intent intent = new Intent(context, GameDetailsActivity.class);
        intent.putExtra(KEY_GAMEID, id);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_details);
        gameDetailsViewModel = new ViewModelProvider(this).get(GameDetailsViewModel.class);

        gameImage = findViewById(R.id.imageGameDetails);
        gameTitle = findViewById(R.id.textTitleGameDetails);
        gameDescription = findViewById(R.id.textDescriptionDetails);
        gamePrice = findViewById(R.id.textPriceGameDetails);
        recyclerReview = findViewById(R.id.recyclerViewGameDetails);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            id = bundle.getInt(KEY_GAMEID, -1);
            if (id == -1) {
                Log.e(TAG, "Invalid position found!");
                finish();
                return;
            }
        }

        gameDetailsViewModel.getGamesById(id).observe(this, new Observer<List<Game>>() {
            @Override
            public void onChanged(List<Game> gameList) {
                Glide.with(GameDetailsActivity.this).load(gameList.get(0).getImgURL()).into(GameDetailsActivity.this.gameImage);
                GameDetailsActivity.this.gameTitle.setText(gameList.get(0).getTitle());
                GameDetailsActivity.this.gamePrice.setText(gameList.get(0).getPrice() + "€");
                GameDetailsActivity.this.gameDescription.setText(gameList.get(0).getDescription());

                GameDetailsAdapter adapter = new GameDetailsAdapter(GameDetailsActivity.this);
                recyclerReview.setLayoutManager(new LinearLayoutManager(GameDetailsActivity.this.getApplicationContext()));
                recyclerReview.setAdapter(adapter);
            }
        });
    }
}
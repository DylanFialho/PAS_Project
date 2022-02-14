package com.example.pas_project.model;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.pas_project.model.database.AppDatabase;
import com.example.pas_project.model.database.GameDao;
import com.example.pas_project.model.database.ReviewDao;
import com.example.pas_project.model.remote.DataSource;
import com.example.pas_project.model.remote.GameService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GameRepository {

    private final Context context;
    private GameDao gameDao;
    private ReviewDao gameWithReview;

    public GameRepository(Context context){
        this.gameDao = AppDatabase.getInstance(context).getGameDao();
        this.gameWithReview = AppDatabase.getInstance(context).getReviewDao();
        this.context = context;
    }

    public LiveData<List<GameWithReview>> getGames() {
        this.updateGames();
        return this.gameDao.getAllGames();
    }

    public LiveData<Game> getGameId(long id) {
        this.updateGames();
        return this.gameDao.getGame(id);
    }

    public void updateGames() {
        GameService gameService = DataSource.getGameService();
        Call<List<Game>> call = gameService.getGames();

        call.enqueue(new Callback<List<Game>>() {
            @Override
            public void onResponse(Call<List<Game>> call, Response<List<Game>> response) {
                if(response.isSuccessful()){
                    List<Game> gameList = response.body();

                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            gameDao.addGames(gameList);
                        }
                    }).start();
                }
            }

            @Override
            public void onFailure(Call<List<Game>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public LiveData<List<GameCart>> getGamesInCart(long id) {
        GameService gameService = DataSource.getGameService();
        Call<List<GameCart>> call = gameService.getGamesInCart(id);

        call.enqueue(new Callback<List<GameCart>>() {
            @Override
            public void onResponse(Call<List<GameCart>> call, Response<List<GameCart>> response) {
                if(response.isSuccessful()){
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            gameDao.addGameToCart(response.body());
                        }
                    }).start();
                }
            }

            @Override
            public void onFailure(Call<List<GameCart>> call, Throwable t) {
                t.printStackTrace();
            }
        });

        return gameDao.getAllInCart();
    }
}

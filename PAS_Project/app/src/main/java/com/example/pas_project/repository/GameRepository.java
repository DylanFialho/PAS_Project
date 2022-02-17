package com.example.pas_project.repository;

import android.content.Context;

import androidx.lifecycle.LiveData;

import com.example.pas_project.model.Game;
import com.example.pas_project.model.User;
import com.example.pas_project.model.database.AppDatabase;
import com.example.pas_project.model.database.GameDao;
import com.example.pas_project.model.database.ReviewDao;
import com.example.pas_project.model.remote.DataSource;
import com.example.pas_project.model.remote.GameService;

import java.util.ArrayList;
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

    public LiveData<Game> getGameId(long id) {
        return this.gameDao.getGame(id);
    }

    public LiveData<List<Game>> updateGames() {
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

        return gameDao.getAllGames();
    }


    public void createUser(User user, IRepoResponse<User> callBack) {
        GameService service = DataSource.getGameService();
        Call<User> call = service.addUser(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                if(response.isSuccessful()){
                    User user = response.body();
                    callBack.onSuccess(user);
                }
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void getUserByPasswordAndEmail(String email, String password, IRepoResponse<List<User>> callBack) {
        GameService service = DataSource.getGameService();
        Call<List<User>> call = service.getUserByEmailAndPassword(email, password);

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful()){
                    List<User> users = response.body();
                    callBack.onSuccess(users);
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void getGamesInCart(IRepoResponse<List<Game>> callBack) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                callBack.onSuccess(gameDao.getAllInCart());
            }
        }).start();
    }

    public void updateGameToCart(Game game) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                gameDao.updateGame(game.getId());
            }
        }).start();
    }

    public void getNews(IRepoResponse<List<Game>> callBack) {
        List<Game> gameList = new ArrayList<>();
        new Thread(new Runnable() {
            @Override
            public void run() {
                callBack.onSuccess(gameDao.getNews());
            }
        }).start();
    }
}

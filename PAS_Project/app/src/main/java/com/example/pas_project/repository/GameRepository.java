package com.example.pas_project.repository;

import android.content.Context;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.pas_project.model.Game;
import com.example.pas_project.model.GameCart;
import com.example.pas_project.model.GameWithReview;
import com.example.pas_project.model.User;
import com.example.pas_project.model.UserResponse;
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

    public void createUser(User user) {
        GameService service = DataSource.getGameService();
        service.addUser(user).enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                User users = response.body();
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public LiveData<User> getUserByEmail(Context context, String email) {
        MutableLiveData<User> userMutableLiveData = new MutableLiveData<>();
        GameService service = DataSource.getGameService();
        service.getUserByEmail(email).enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if (response.isSuccessful()){
                    List<User> users = response.body();
                    if (users.size() > 0) {
                        userMutableLiveData.postValue(response.body().get(0));
                    }else {
                        userMutableLiveData.postValue(null);
                        Toast toast = Toast.makeText(context, "Email já existe",Toast.LENGTH_SHORT);
                        toast.show();
                    }
                }else {
                    userMutableLiveData.postValue(null);
                }
            }
            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                t.printStackTrace();
                userMutableLiveData.postValue(null);
            }
        });
        return userMutableLiveData;
    }

    public LiveData<UserResponse> getUserByPasswordAndEmail(Context context, String email, String password) {
        MutableLiveData<UserResponse> userMutableLiveData = new MutableLiveData<>();
        GameService service = DataSource.getGameService();
        service.getUserByEmailAndPassword(new User(0, password, email)).enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                UserResponse users = response.body();
                if (users != null) {
                    userMutableLiveData.postValue(response.body());
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                userMutableLiveData.postValue(null);
            }
        });

        return userMutableLiveData;
    }
}

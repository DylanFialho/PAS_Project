package com.example.pas_project.repository;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.pas_project.R;
import com.example.pas_project.model.Game;
import com.example.pas_project.model.GameCart;
import com.example.pas_project.model.GameCategoryBody;
import com.example.pas_project.model.GameListCategory;
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

    public void createUser(View view, User user) {
        GameService service = DataSource.getGameService();
        Call<User> call = service.addUser(user);
        call.enqueue(new Callback<User>() {
            @Override
            public void onResponse(Call<User> call, Response<User> response) {
                Toast.makeText(context, "Registo Criado", Toast.LENGTH_LONG).show();
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_registerFragment_to_pub1Fragment);
            }

            @Override
            public void onFailure(Call<User> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public void getUserByPasswordAndEmail(View view, String email, String password) {
        GameService service = DataSource.getGameService();
        Call<List<User>> call = service.getUserByEmailAndPassword(email, password);

        call.enqueue(new Callback<List<User>>() {
            @Override
            public void onResponse(Call<List<User>> call, Response<List<User>> response) {
                if(response.isSuccessful()){
                    List<User> users = response.body();
                    if(users.size() == 1){
                        NavController navController = Navigation.findNavController(view);
                        navController.navigate(R.id.action_loginFragment_to_nav_graph);
                    }else{
                        Toast.makeText(view.getContext(), "Email ou password errados!", Toast.LENGTH_SHORT);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<User>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}

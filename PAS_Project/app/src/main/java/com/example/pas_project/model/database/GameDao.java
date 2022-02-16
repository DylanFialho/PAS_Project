package com.example.pas_project.model.database;

import static androidx.room.OnConflictStrategy.REPLACE;

import android.security.keystore.StrongBoxUnavailableException;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.pas_project.model.Game;
import com.example.pas_project.model.GameListCategory;
import com.example.pas_project.model.GameWithReview;
import com.example.pas_project.model.User;
import com.example.pas_project.model.GameCart;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

@Dao
public interface GameDao {

    @Query("SELECT * FROM Game")
    LiveData<List<GameWithReview>> getAllGames();

    @Query("SELECT * FROM Game WHERE id = :idGame")
    LiveData<Game> getGame(long idGame);

    @Query("SELECT * FROM GameCart")
    LiveData<List<GameCart>> getAllInCart();

    @Query("SELECT * FROM Game WHERE category IN (:categoryList)")
    LiveData<List<GameListCategory>> getAllinCategory(List<String> categoryList);

    @Query("SELECT * FROM User WHERE email = :email AND password = :pass")
    LiveData<User> getUserByEmailAndPass(String email, String pass);

    @Query("SELECT * FROM User WHERE id = :id")
    LiveData<User> getUserId(long id);

    @Insert(onConflict = REPLACE)
    void addGames(List<Game> gameList);

    @Insert(onConflict = REPLACE)
    void addGameToCart(List<GameCart> GameCart);

    @Insert(onConflict = REPLACE)
    void addUser(User user);
}

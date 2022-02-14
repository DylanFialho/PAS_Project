package com.example.pas_project.model.database;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.pas_project.model.Game;
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

    @Insert(onConflict = REPLACE)
    void addGames(List<Game> gameList);

    @Insert(onConflict = REPLACE)
    void addGameToCart(List<GameCart> GameCart);


}

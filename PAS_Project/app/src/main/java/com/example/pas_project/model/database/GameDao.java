package com.example.pas_project.model.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Query;
import com.example.pas_project.model.Game;

import java.util.List;

@Dao
public interface GameDao {

    @Query("SELECT * FROM Game")
    LiveData<List<Game>> getAllGames();

    @Query("SELECT * FROM Game WHERE id = :idGame")
    LiveData<Game> getGame(long idGame);

    @Query("SELECT * FROM Game WHERE isInCart = 1")
    List<Game> getAllInCart();
}

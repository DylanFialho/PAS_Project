package com.example.pas_project.model.database;

import static androidx.room.OnConflictStrategy.REPLACE;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.pas_project.model.Game;
import com.example.pas_project.model.User;

import java.util.List;

@Dao
public interface GameDao {

    @Query("SELECT * FROM Game")
    LiveData<List<Game>> getAllGames();

    @Query("SELECT * FROM Game WHERE id = :idGame")
    LiveData<Game> getGame(long idGame);

    @Query("SELECT * FROM Game WHERE isInCart = 1 ")
    List<Game> getAllInCart();

    @Query("SELECT * FROM User WHERE email = :email AND password = :pass")
    LiveData<User> getUserByEmailAndPass(String email, String pass);

    @Query("SELECT * FROM User WHERE id = :id")
    LiveData<User> getUserId(long id);

    @Query("SELECT * FROM Game ORDER BY RANDOM() LIMIT 3")
    List<Game> getNews();

    @Insert(onConflict = REPLACE)
    void addGames(List<Game> gameList);

    @Update
    public void updateGame(Game game);

    @Insert(onConflict = REPLACE)
    void addUser(User user);
}

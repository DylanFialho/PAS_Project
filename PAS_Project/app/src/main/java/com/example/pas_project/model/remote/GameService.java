package com.example.pas_project.model.remote;

import com.example.pas_project.model.GameCart;
import com.example.pas_project.model.Game;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GameService {

    @GET("games/")
    Call<List<Game>> getGames();

    @GET("game/{id}")
    Call<Game> getGameId(@Path("id") long id);

    @GET("user/{id}/cart")
    Call<List<GameCart>> getGamesInCart(@Path("id") long id);

}

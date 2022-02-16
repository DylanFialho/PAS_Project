package com.example.pas_project.model.remote;

import com.example.pas_project.model.GameCart;
import com.example.pas_project.model.Game;
import com.example.pas_project.model.GameListCategory;
import com.example.pas_project.model.User;
import com.example.pas_project.model.UserResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface GameService {
    ///////////////////////////////////////////////////////////////////USER API

    @POST("user/")
    Call<User> addUser(@Body User user);

    @GET("user/{email}")
    Call<List<User>> getUserByEmail(@Path("email") String email);

    @POST("user/login")
    Call<UserResponse> getUserByEmailAndPassword(@Body User user);

    @GET("user/{id}/cart")
    Call<List<GameCart>> getGamesInCart(@Path("id") long id);

    ///////////////////////////////////////////////////////////////////GAMES API

    @GET("games/")
    Call<List<Game>> getGames();

    @GET("game/{id}")
    Call<Game> getGameId(@Path("id") long id);

    @GET("game/categories")
    Call<GameListCategory> getGameCategorys(@Body List<String> category);
}

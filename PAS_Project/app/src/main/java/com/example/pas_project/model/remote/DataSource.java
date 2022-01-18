package com.example.pas_project.model.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataSource {

    private final static String WEB_URL = "http://localhost:8000/api/";

    private static Retrofit retrofit = new Retrofit.Builder().baseUrl(WEB_URL).
            addConverterFactory(GsonConverterFactory.create()).
            build();

    private static GameService gameService;

    public static GameService getGameService(){

        if(gameService == null){
            gameService = retrofit.create(GameService.class);
        }
        return  gameService;
    }
}
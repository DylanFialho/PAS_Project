package com.example.pas_project.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.pas_project.model.Game;
import com.example.pas_project.repository.GameRepository;
import com.example.pas_project.model.GameCart;

import java.util.List;

public class CartViewModel extends AndroidViewModel {

    private GameRepository gameRepository;

    public CartViewModel(@NonNull Application application){
        super(application);
        this.gameRepository = new GameRepository(application.getApplicationContext());
    }

    public LiveData<List<GameCart>> updateGames() {
        return this.gameRepository.getGamesInCart(1);
    }

    public LiveData<Game> getGameById(long id) {
        return this.gameRepository.getGameId(id);
    }
}
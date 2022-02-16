package com.example.pas_project.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.pas_project.model.Game;
import com.example.pas_project.repository.GameRepository;

import java.util.List;

public class GameDetailsViewModel extends AndroidViewModel {

    private GameRepository gameRepository;

    public GameDetailsViewModel(@NonNull Application application){
        super(application);
        this.gameRepository = new GameRepository(application.getApplicationContext());
    }


    public LiveData<Game> getGamesById(long id) {
        return gameRepository.getGameId(id);
    }
}

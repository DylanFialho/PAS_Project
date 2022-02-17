package com.example.pas_project.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.pas_project.model.Game;
import com.example.pas_project.model.Review;
import com.example.pas_project.repository.GameRepository;

public class GameDetailsViewModel extends AndroidViewModel {

    private GameRepository gameRepository;

    public GameDetailsViewModel(@NonNull Application application){
        super(application);
        this.gameRepository = new GameRepository(application.getApplicationContext());
    }

    public LiveData<Game> getGamebyId(long id){
        return this.gameRepository.getGameId(id);
    }
}
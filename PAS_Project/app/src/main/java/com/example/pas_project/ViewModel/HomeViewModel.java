package com.example.pas_project.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.pas_project.model.Game;
import com.example.pas_project.model.GameListCategory;
import com.example.pas_project.model.GameWithReview;
import com.example.pas_project.repository.GameRepository;

import java.util.List;

public class HomeViewModel extends AndroidViewModel {

    private GameRepository gameRepository;

    public HomeViewModel(@NonNull Application application) {
        super(application);
        this.gameRepository = new GameRepository(application.getApplicationContext());
    }

    public LiveData<List<Game>> getAllGames(){
        return this.gameRepository.updateGames();
    }
}
package com.example.pas_project.ViewModel;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.pas_project.model.Game;
import com.example.pas_project.repository.GameRepository;
import com.example.pas_project.repository.IRepoResponse;

import java.util.List;

public class NewsViewModel extends AndroidViewModel {

    private GameRepository gameRepository;

    public NewsViewModel(@NonNull Application application){
        super(application);
        this.gameRepository = new GameRepository(application.getApplicationContext());
    }

    public void getNews(IRepoResponse<List<Game>> callBack) {
        gameRepository.getNews(callBack);
    }

    public LiveData<List<Game>> getAll() {
        return gameRepository.updateGames();
    }
}
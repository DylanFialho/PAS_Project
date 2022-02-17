package com.example.pas_project.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.pas_project.model.Game;
import com.example.pas_project.repository.GameRepository;
import com.example.pas_project.repository.IRepoResponse;

import java.util.List;

public class CartViewModel extends AndroidViewModel {

    private GameRepository gameRepository;

    public CartViewModel(@NonNull Application application){
        super(application);
        this.gameRepository = new GameRepository(application.getApplicationContext());
    }

    public void getGamesInCart(IRepoResponse<List<Game>> callBack) {
        gameRepository.getGamesInCart(callBack);
    }
}
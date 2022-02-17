package com.example.pas_project.ViewModel;

import android.app.Application;
import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.pas_project.model.User;
import com.example.pas_project.repository.GameRepository;
import com.example.pas_project.repository.IRepoResponse;

public class RegisterFragmentViewModel extends AndroidViewModel {

    private GameRepository gameRepository;

    public RegisterFragmentViewModel(@NonNull Application application) {
        super(application);
        this.gameRepository = new GameRepository(application.getApplicationContext());
    }

    public void createUser(User user, IRepoResponse<User> callBack){
        this.gameRepository.createUser(user, callBack);
    }
}

package com.example.pas_project.ViewModel;

import android.app.Application;
import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.pas_project.model.User;
import com.example.pas_project.model.UserResponse;
import com.example.pas_project.repository.GameRepository;

public class LoginFragmentViewModel extends AndroidViewModel {

    private GameRepository gameRepository;

    public LoginFragmentViewModel(@NonNull Application application) {
        super(application);
        this.gameRepository = new GameRepository(application);
    }

    public void getUserLogin(View view, String email, String password){
        gameRepository.getUserByPasswordAndEmail(view, email,password);
    }
}

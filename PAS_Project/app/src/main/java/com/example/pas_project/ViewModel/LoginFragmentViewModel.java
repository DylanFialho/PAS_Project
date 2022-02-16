package com.example.pas_project.ViewModel;

import android.app.Application;
import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.pas_project.model.UserResponse;
import com.example.pas_project.repository.GameRepository;
import com.example.pas_project.repository.SessionRepository;
import com.example.pas_project.model.User;

public class LoginFragmentViewModel extends AndroidViewModel {

    private GameRepository gameRepository;
    private SessionRepository sessionRepository;

    public LoginFragmentViewModel(@NonNull Application application) {
        super(application);
        this.gameRepository = new GameRepository(application);
    }

    public LiveData<User> getUserByEmail(Context context, String email){
        return gameRepository.getUserByEmail(context,email);
    }

    public LiveData<UserResponse> getUserByPasswordAndEmail(String email, String password){
        return gameRepository.getUserByPasswordAndEmail(email,password);
    }

    public void saveSession(User user){
        this.sessionRepository.saveSession(user);
    }

    public User getActiveSession(){
        return sessionRepository.getActiveSession();
    }
}

package com.example.pas_project.ViewModel;

import android.app.Application;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.pas_project.repository.GameRepository;
import com.example.pas_project.repository.SessionRepository;
import com.example.pas_project.model.User;

public class RegisterFragmentViewModel extends AndroidViewModel {

    private SessionRepository sessionRepository;
    private GameRepository gameRepository;

    public RegisterFragmentViewModel(@NonNull Application application) {
        super(application);
        this.sessionRepository = new SessionRepository(application.getApplicationContext());
        this.gameRepository = new GameRepository(application.getApplicationContext());
    }

    public void createUser(User user){
        this.gameRepository.createUser(user);
    }

    public LiveData<User> getUserByEmail(Context context, String email){
        return gameRepository.getUserByEmail(context,email);
    }

    public void saveSession(User user){
        this.sessionRepository.saveSession(user);
    }
}

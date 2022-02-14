package com.example.pas_project.ViewModel;

import android.app.Application;
import android.content.Context;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.pas_project.repository.Repository;

public class LoginFragmentViewModel extends AndroidViewModel {

    private Repository repository;

    public LoginFragmentViewModel(@NonNull Application application) {
        super(application);
        this.repository = new Repository(application);
    }

    public void login(Context context, View view, String email, String password){ this.repository.login(context,view,email,password);}
}

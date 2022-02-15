package com.example.pas_project.repository;

import android.content.Context;

import com.example.pas_project.model.SessionManager;
import com.example.pas_project.model.User;

public class SessionRepository {

    private Context context;

    public SessionRepository(Context context){
        this.context = context;
    }

    public User getActiveSession(){
        return SessionManager.getActiveSession(this.context);
    }

    public void saveSession(User user){
        SessionManager.saveSession(this.context,user);
    }

    public void clearSession(){
        SessionManager.clearSession(this.context);
    }
}

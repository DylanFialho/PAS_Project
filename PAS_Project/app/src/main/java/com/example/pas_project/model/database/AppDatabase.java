package com.example.pas_project.model.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.pas_project.model.Game;
import com.example.pas_project.model.User;

@Database(entities = {Game.class, User.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    public GameDao getGameDao();
    public ReviewDao getReviewDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context){
        if(INSTANCE == null){
            INSTANCE = Room.databaseBuilder
                    (context.getApplicationContext(), AppDatabase.class, "gamesDB")
                    .build();
        }

        return INSTANCE;
    }
}

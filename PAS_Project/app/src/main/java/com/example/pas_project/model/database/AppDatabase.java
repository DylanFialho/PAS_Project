package com.example.pas_project.model.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.pas_project.CustomTypeConverters;
import com.example.pas_project.model.Game;
import com.example.pas_project.model.Review;
import com.example.pas_project.model.User;

@Database(entities = {Game.class, User.class, Review.class}, version = 4)
@TypeConverters({CustomTypeConverters.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract GameDao getGameDao();
    public abstract ReviewDao getReviewDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder
                    (context.getApplicationContext(), AppDatabase.class, "gamesDB")
                    .build();
        }

        return INSTANCE;
    }
}

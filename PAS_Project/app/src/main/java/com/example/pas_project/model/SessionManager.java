package com.example.pas_project.model;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    private static final String KEY_ID = "ID";
    private static final String KEY_EMAIL = "EMAIL";
    private static final String KEY_PASSWORD = "PASSWORD";
    private Context context;

    private static SharedPreferences sharedpreferences;
    private static SharedPreferences sharedpreferencesTheme;

    private static SharedPreferences getInstance(Context context) {
        if (sharedpreferences == null) {
            sharedpreferences = context.getApplicationContext().getSharedPreferences("Preferences", 0);
        }
        return sharedpreferences;
    }

    public static User getActiveSession(Context context) {
        if (getInstance(context).contains(KEY_EMAIL) && getInstance(context).contains(KEY_PASSWORD)) {
            return new User(getInstance(context).getLong(KEY_ID, 0),
                    getInstance(context).getString(KEY_EMAIL, ""),
                    getInstance(context).getString(KEY_PASSWORD, ""));
        }
        return null;
    }

    public static void saveSession(Context context, User user) {
        getInstance(context).edit().putLong(KEY_ID, user.getId()).apply();
        getInstance(context).edit().putString(KEY_EMAIL, user.getEmail()).apply();
        getInstance(context).edit().putString(KEY_PASSWORD, user.getPassword()).apply();
    }

    public static void clearSession(Context context) {
        getInstance(context).edit().clear().apply();
    }
}

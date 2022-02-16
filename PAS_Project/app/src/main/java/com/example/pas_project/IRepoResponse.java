package com.example.pas_project;

import androidx.room.TypeConverter;

import com.example.pas_project.model.Game;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;


/*
Passar uma lista de objeto Game para String e vice versa
https://medium.com/@toddcookevt/android-room-storing-lists-of-objects-766cca57e3f9
*/
public class IRepoResponse {

    Gson gson = new Gson();

    @TypeConverter
    public List<Game> stringToGameList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }
        Type listType = new TypeToken<List<Game>>() {}.getType();
        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public String gameListToString(List<Game> game) {
        return gson.toJson(game);
    }
}

package com.example.pas_project.model;

import androidx.room.Ignore;

import java.util.List;

public class GameListCategory {

    private String category;
    @Ignore
    private List<Game> gameList;

    public GameListCategory( String category, List<Game> gameList) {
        this.category = category;
        this.gameList = gameList;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}

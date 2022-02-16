package com.example.pas_project.model;

import java.util.List;

public class GameListCategory {

    private String category;
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

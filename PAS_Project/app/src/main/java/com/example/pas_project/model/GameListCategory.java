package com.example.pas_project.model;

import java.util.List;

public class GameListCategory {

    private List<Game> gameList;
    private String category;

    public GameListCategory(List<Game> gameList, String category) {
        this.gameList = gameList;
        this.category = category;
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

package com.example.pas_project.model;

import java.util.List;

public class GameCategoryBody {

    private List<String> category;

    public GameCategoryBody(List<String> category) {
        this.category = category;
    }

    public List<String> getCategory() {
        return category;
    }

    public void setCategory(List<String> category) {
        this.category = category;
    }
}

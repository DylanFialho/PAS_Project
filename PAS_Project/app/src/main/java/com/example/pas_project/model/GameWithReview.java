package com.example.pas_project.model;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

public class GameWithReview {

    @Embedded
    private Game game;

    @Relation(parentColumn = "id", entityColumn = "gameId")
    private List<Review> reviewList;

    public GameWithReview(Game game, List<Review> reviewList){
        this.game = game;
        this.reviewList = reviewList;
    }

    public Game getGame() {
        return game;
    }

    public void setGame(Game post) {
        this.game = post;
    }

    public List<Review> getReviewList() {
        return reviewList;
    }

    public void setReviewList(List<Review> reviewList) {
        this.reviewList = reviewList;
    }
}

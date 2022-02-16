package com.example.pas_project.model;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

import java.util.List;

@Entity(foreignKeys = {@ForeignKey(entity = Game.class,
        parentColumns = "id",
        childColumns = "gameId",
        onDelete = ForeignKey.CASCADE),
        @ForeignKey(entity = User.class,
                parentColumns = "id",
                childColumns = "userId",
                onDelete = ForeignKey.CASCADE)
})
public class Review {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private long gameId;
    private User user;
    private String content;

    public Review(long id, long gameId, User user, String content) {
        this.id = id;
        this.gameId = gameId;
        this.user = user;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getGameId() {
        return gameId;
    }

    public void setGameId(long gameId) {
        this.gameId = gameId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

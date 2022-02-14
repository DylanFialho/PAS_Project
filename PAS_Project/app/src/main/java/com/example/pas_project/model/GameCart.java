package com.example.pas_project.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class GameCart {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private long userId;
    private String imgURL;
    private String title;
    private String description;
    private String category;
    private float price;

    public GameCart(long id, long userId, String imgURL, String title, String description, String category, float price) {
        this.id = id;
        this.userId = userId;
        this.imgURL = imgURL;
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getImgURL() {
        return imgURL;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}

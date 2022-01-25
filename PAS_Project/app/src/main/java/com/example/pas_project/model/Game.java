package com.example.pas_project.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Game {

    @PrimaryKey(autoGenerate = true)
    private long id;
    private String imgURL;
    private String title;
    private String description;
    private String category;
    private float price;
    private boolean isInCart;

    public Game(long id, String imgURL, String title, String description, String category, float price, boolean isInCart) {
        this.id = id;
        this.imgURL = imgURL;
        this.title = title;
        this.description = description;
        this.category = category;
        this.price = price;
        this.isInCart = isInCart;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public boolean isInCart() {
        return isInCart;
    }

    public void setInCart(boolean inCart) {
        isInCart = inCart;
    }
}

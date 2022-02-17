package com.example.pas_project.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.Objects;

@Entity
public class Game {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return id == game.id && Float.compare(game.price, price) == 0 && isInCart == game.isInCart && Objects.equals(imgURL, game.imgURL) && Objects.equals(title, game.title) && Objects.equals(description, game.description) && Objects.equals(category, game.category) && Objects.equals(console, game.console);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, imgURL, title, description, category, console, price, isInCart);
    }

    @PrimaryKey(autoGenerate = true)
    private long id;
    @SerializedName("url")
    private String imgURL;
    @SerializedName("name")
    private String title;
    private String description;
    private String category;
    private String console;
    private float price;
    private boolean isInCart;

    public Game(long id, String imgURL, String title, String description, String category, String console, float price, boolean isInCart) {
        this.id = id;
        this.imgURL = imgURL;
        this.title = title;
        this.description = description;
        this.category = category;
        this.console = console;
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

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
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

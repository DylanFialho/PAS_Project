package com.example.pas_project.model;

public class Review {

    private int id;
    private String userName;
    private String content;
    private int rating;

    public Review(int id, String userName, String content, int rating) {
        this.id = id;
        this.userName = userName;
        this.content = content;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}

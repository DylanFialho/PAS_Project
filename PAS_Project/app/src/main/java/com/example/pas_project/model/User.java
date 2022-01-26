package com.example.pas_project.model;

public class User {

    private String username;
    private String password;
    private String url;
    private String email;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public User(String username, String password, String url, String email) {
        this.username = username;
        this.password = password;
        this.url = url;
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

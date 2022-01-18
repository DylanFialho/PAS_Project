package com.example.pas_project.model;

public class Game {

    private int id;
    private String url;
    private String name;
    private String categpry;
    private String console;


    public Game(int id, String url, String name, String categpry, String console) {
        this.id = id;
        this.url = url;
        this.name = name;
        this.categpry = categpry;
        this.console = console;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategpry() {
        return categpry;
    }

    public void setCategpry(String categpry) {
        this.categpry = categpry;
    }

    public String getConsole() {
        return console;
    }

    public void setConsole(String console) {
        this.console = console;
    }
}

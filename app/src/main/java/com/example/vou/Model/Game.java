package com.example.vou.Model;

public class Game {
    private int id;
    private String name;
    private int image;
    private int type;
    private String name_type;
    private boolean exchange;
    private String tutorial;

    public Game(int id, String name, int image, int type, boolean exchange, String name_type, String tutorial) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.type = type;
        this.exchange = exchange;
        this.name_type = name_type;
        this.tutorial = tutorial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getName_type() {
        return name_type;
    }

    public void setName_type(String name_type) {
        this.name_type = name_type;
    }

    public boolean isExchange() {
        return exchange;
    }

    public void setExchange(boolean exchange) {
        this.exchange = exchange;
    }

    public String getTutorial() {
        return tutorial;
    }

    public void setTutorial(String tutorial) {
        this.tutorial = tutorial;
    }
}

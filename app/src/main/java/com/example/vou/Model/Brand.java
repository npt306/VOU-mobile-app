package com.example.vou.Model;

import java.io.Serializable;

public class Brand implements Serializable {
    private int id;
    private String name;
    private String field;
    private String address;
    private String coordinate;
    private boolean state;
    private String email;
    private int image;

    public Brand(int id, String name, String field, String address, String coordinate, boolean state, String email, int image){
        this.id = id;
        this.name = name;
        this.field = field;
        this.address = address;
        this.coordinate = coordinate;
        this.state =state;
        this.email = email;
        this.image = image;
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

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}

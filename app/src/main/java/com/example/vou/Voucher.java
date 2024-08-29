package com.example.vou;

import java.util.Date;

public class Voucher {
    private String id;
    private String brand;
    private String sale;
    private String description;
    private Date expired_day;
    private String code;
    private int type;
    private int total_pieces;
    private int available_pieces;

    public Voucher(String brand, String sale, String description, Date expired_day, String code){
        this.brand = brand;
        this.sale = sale;
        this.description = description;
        this.expired_day = expired_day;
        this.code = code;
        this.type = 1;
        this.total_pieces = 0;
        this.available_pieces = 0;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExpired_day() {
        return expired_day;
    }

    public void setExpired_day(Date expired_day) {
        this.expired_day = expired_day;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getTotal_pieces() {
        return total_pieces;
    }

    public void setTotal_pieces(int total_pieces) {
        this.total_pieces = total_pieces;
    }

    public int getAvailable_pieces() {
        return available_pieces;
    }

    public void setAvailable_pieces(int available_pieces) {
        this.available_pieces = available_pieces;
    }
}

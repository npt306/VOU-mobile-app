package com.example.vou;

import java.util.Date;

public class Voucher {
    private static final int VOUCHER_TYPE_1 = 1;
    private static final int VOUCHER_TYPE_2 = 2;

    private int id;
    private String code;
    private String name;
    private int image;
    private String description;
    private Date expiredDay;
    private int type;
    private int idUser;
    private String sale;
    private boolean state;
    private int idEvent;
    private int totalPieces;
    private int availablePieces;

    public Voucher(String name, String code, String description, Date expiredDay, String sale){
        this.id = 0;
        this.code = code;
        this.name = name;
        this.image = R.drawable.icon_voucher_1;
        this.description = description;
        this.expiredDay = expiredDay;
        this.type = VOUCHER_TYPE_1;
        this.idUser = 0;
        this.sale = sale;
        this.state = true;
        this.idEvent = 0;
        this.totalPieces = 0;
        this.availablePieces = 0;
    }

    public Voucher(String name, String code, String description, Date expiredDay, String sale, int availablePieces, int totalPieces){
        this.id = 0;
        this.code = code;
        this.name = name;
        this.image = R.drawable.icon_voucher_2;
        this.description = description;
        this.expiredDay = expiredDay;
        this.type = VOUCHER_TYPE_2;
        this.idUser = 0;
        this.sale = sale;
        this.state = true;
        this.idEvent = 0;
        this.totalPieces = totalPieces;
        this.availablePieces = availablePieces;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getImage() { return image; }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getExpiredDay(){return expiredDay;}

    public String getExpiredDayString() {
        return expiredDay.getDay() + "/" + expiredDay.getMonth() + "/" + expiredDay.getYear();
    }

    public void setExpiredDay(Date expiredDay) {
        this.expiredDay = expiredDay;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getTotalPieces() {
        return totalPieces;
    }

    public void setTotalPieces(int totalPieces) {
        this.totalPieces = totalPieces;
    }

    public int getAvailablePieces() {
        return availablePieces;
    }

    public void setAvailablePieces(int availablePieces) {
        this.availablePieces = availablePieces;
    }
}

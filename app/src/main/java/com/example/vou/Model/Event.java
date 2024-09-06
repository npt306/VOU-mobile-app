package com.example.vou.Model;

import java.util.Date;
import java.util.List;

public class Event {
    private int id;
    private  String name;
    private String short_description;
    private int image;
    private int voucher_quantity;
    private int voucher_use;
    private Date start_date;
    private Date end_date;
    private int brand_id;
    private int game_id;
    private int num_of_turn;
    private String guideline;
    private List<Integer> voucherIdList;

    public Event(int id, String name, String short_description, int image, int voucher_quantity, int voucher_use, Date start_date, Date end_date, int brand_id, int game_id,int num_of_turn, String guideline, List<Integer> voucherIdList){
        this.id = id;
        this.name = name;
        this.short_description = short_description;
        this.image = image;
        this.voucher_quantity = voucher_quantity;
        this.voucher_use = voucher_use;
        this.start_date = start_date;
        this.end_date = end_date;
        this.num_of_turn = num_of_turn;
        this.brand_id = brand_id;
        this.game_id = game_id;
        this.guideline = guideline;
        this.voucherIdList = voucherIdList;
    }

    public int getNum_of_turn() {
        return num_of_turn;
    }

    public void setNum_of_turn(int num_of_turn) {
        this.num_of_turn = num_of_turn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShort_description() {
        return short_description;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public List<Integer> getVoucherIdList() {
        return voucherIdList;
    }

    public void setVoucherIdList(List<Integer> voucherIdList) {
        this.voucherIdList = voucherIdList;
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

    public int getVoucher_quantity() {
        return voucher_quantity;
    }

    public void setVoucher_quantity(int voucher_quantity) {
        this.voucher_quantity = voucher_quantity;
    }

    public int getVoucher_use() {
        return voucher_use;
    }

    public void setVoucher_use(int voucher_use) {
        this.voucher_use = voucher_use;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public int getGame_id() {
        return game_id;
    }

    public void setGame_id(int game_id) {
        this.game_id = game_id;
    }

    public String getGuideline() {
        return guideline;
    }

    public void setGuideline(String guideline) {
        this.guideline = guideline;
    }

    public int getBrand_id() {
        return brand_id;
    }

    public void setBrand_id(int brand_id) {
        this.brand_id = brand_id;
    }
}

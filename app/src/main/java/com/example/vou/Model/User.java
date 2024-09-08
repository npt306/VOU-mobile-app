package com.example.vou.Model;

import java.util.Date;

public class User {
    private int id;
    private String username;
    private String email;
    private String full_name;
    private String password;
    private String phone_number;
    private boolean role;
    private int sex;
    private int avatar;
    private Date birthday;
    private String facebook_account;

    public User(int id, String username, String email, String full_name, String password, String phone_number, boolean role, int sex, int avatar, Date birthday, String facebook_account) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.full_name = full_name;
        this.password = password;
        this.phone_number = phone_number;
        this.role = role;
        this.sex = sex;
        this.avatar = avatar;
        this.birthday = birthday;
        this.facebook_account = facebook_account;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public boolean isRole() {
        return role;
    }

    public void setRole(boolean role) {
        this.role = role;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getFacebook_account() {
        return facebook_account;
    }

    public void setFacebook_account(String facebook_account) {
        this.facebook_account = facebook_account;
    }
}

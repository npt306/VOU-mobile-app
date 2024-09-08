package com.example.vou.Singleton;

import com.example.vou.Model.User;

import java.util.ArrayList;
import java.util.List;

public class UserSingleton {
    private static UserSingleton instance;
    private List<User> userList;
    private List<User> friendList = new ArrayList<>();

    private UserSingleton() {}

    public static UserSingleton getInstance() {
        if (instance == null) {
            instance = new UserSingleton();
        }
        return instance;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public List<User> getFriendList() {
        return friendList;
    }

    public void addFriend(int userId){
        for(int i = 0; i <  userList.size(); i++){
            if(userList.get(i).getId() == userId){
                friendList.add(userList.get(i));
                return;
            }
        }
    }

    public boolean isFriend(int userId){
        for(int i = 0; i <  friendList.size(); i++){
            if(friendList.get(i).getId() == userId){
                return true;
            }
        }
        return false;
    }
}

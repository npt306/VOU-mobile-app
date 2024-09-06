package com.example.vou.Singleton;

import com.example.vou.Model.Game;

import java.util.List;

public class GameSingleton {
    private static GameSingleton instance;
    List<Game> gameList;

    private GameSingleton() {}

    public GameSingleton(List<Game> gameList){
        this.gameList =gameList;
    }

    public static GameSingleton getInstance() {
        if (instance == null) {
            instance = new GameSingleton();
        }
        return instance;
    }

    public List<Game> getGameList() {
        return gameList;
    }

    public void setGameList(List<Game> gameList) {
        this.gameList = gameList;
    }

    public Game getGame(int id){
        for(int i = 0; i < gameList.size(); i++){
            if(gameList.get(i).getId() == id ){
                return gameList.get(i);
            }
        }
        return null;
    }
}

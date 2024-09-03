package com.example.vou.Singleton;


public class LoginSingleton {
    private static LoginSingleton instance;
    private boolean isLogging;

    private LoginSingleton() {}
    private LoginSingleton(boolean isLogging) {this.isLogging = isLogging;}

    public static LoginSingleton getInstance() {
        if (instance == null) {
            instance = new LoginSingleton(false);
        }
        return instance;
    }

    public boolean isLogging() {
        return isLogging;
    }

    public void setLogging(boolean isLogging) {
        this.isLogging = isLogging;
    }
}


package com.example.vou.Model;

public class QuizGameComment {
    private String user_name;
    private String user_comment;

    public QuizGameComment(String user_name, String user_comment) {
        this.user_name = user_name;
        this.user_comment = user_comment;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public String getUser_comment() {
        return user_comment;
    }

    public void setUser_comment(String user_comment) {
        this.user_comment = user_comment;
    }
}

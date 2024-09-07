package com.example.vou.Model;

import java.util.List;

public class Question {
    private String questionText;
    private List<String> answers;

    public Question(String questionText, List<String> answers) {
        this.questionText = questionText;
        this.answers = answers;
    }

    public String getQuestionText() {
        return questionText;
    }

    public List<String> getAnswers() {
        return answers;
    }
}


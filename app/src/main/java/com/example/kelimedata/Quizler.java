package com.example.kelimedata;

import java.io.Serializable;

public class Quizler implements Serializable {
    private int quiz_id;
    private String turkce;
    private String fransizca;
    private String resmi;

    public Quizler() {
    }

    public Quizler(int quiz_id, String turkce, String fransizca, String resmi) {
        this.quiz_id = quiz_id;
        this.turkce = turkce;
        this.fransizca = fransizca;
        this.resmi = resmi;
    }

    public int getQuiz_id() {
        return quiz_id;
    }

    public void setQuiz_id(int quiz_id) {
        this.quiz_id = quiz_id;
    }

    public String getTurkce() {
        return turkce;
    }

    public void setTurkce(String turkce) {
        this.turkce = turkce;
    }

    public String getFransizca() {
        return fransizca;
    }

    public void setFransizca(String fransizca) {
        this.fransizca = fransizca;
    }

    public String getResmi() {
        return resmi;
    }

    public void setResmi(String resmi) {
        this.resmi = resmi;
    }
}

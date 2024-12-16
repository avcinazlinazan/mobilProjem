package com.example.kelimedata;

import java.io.Serializable;

public class Sorular implements Serializable {
    private int soru_id;
    private String soru_turkce;
    private String soru_fransizca;
    private String soru_resmi;

    public Sorular() {
    }

    public Sorular(int soru_id, String soru_turkce, String soru_fransizca, String soru_resmi) {
        this.soru_id = soru_id;
        this.soru_turkce = soru_turkce;
        this.soru_fransizca = soru_fransizca;
        this.soru_resmi = soru_resmi;
    }

    public int getSoru_id() {
        return soru_id;
    }

    public void setSoru_id(int soru_id) {
        this.soru_id = soru_id;
    }

    public String getSoru_turkce() {
        return soru_turkce;
    }

    public void setSoru_turkce(String soru_turkce) {
        this.soru_turkce = soru_turkce;
    }

    public String getSoru_fransizca() {
        return soru_fransizca;
    }

    public void setSoru_fransizca(String soru_fransizca) {
        this.soru_fransizca = soru_fransizca;
    }

    public String getSoru_resmi() {
        return soru_resmi;
    }

    public void setSoru_resmi(String soru_resmi) {
        this.soru_resmi = soru_resmi;
    }
}

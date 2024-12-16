package com.example.kelimedata;

import java.io.Serializable;

public class Cumleler implements Serializable {
    private int cumle_id;
    private String cumle_turkce;
    private String cumle_fransizca;
    private String cumle_resmi;

    public Cumleler() {
    }

    public Cumleler(int cumle_id, String cumle_turkce, String cumle_fransizca, String cumle_resmi) {
        this.cumle_id = cumle_id;
        this.cumle_turkce = cumle_turkce;
        this.cumle_fransizca = cumle_fransizca;
        this.cumle_resmi = cumle_resmi;
    }

    public int getCumle_id() {
        return cumle_id;
    }

    public void setCumle_id(int cumle_id) {
        this.cumle_id = cumle_id;
    }

    public String getCumle_turkce() {
        return cumle_turkce;
    }

    public void setCumle_turkce(String cumle_turkce) {
        this.cumle_turkce = cumle_turkce;
    }

    public String getCumle_fransizca() {
        return cumle_fransizca;
    }

    public void setCumle_fransizca(String cumle_fransizca) {
        this.cumle_fransizca = cumle_fransizca;
    }

    public String getCumle_resmi() {
        return cumle_resmi;
    }

    public void setCumle_resmi(String cumle_resmi) {
        this.cumle_resmi = cumle_resmi;
    }

}

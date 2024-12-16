package com.example.kelimedata;

import java.io.Serializable;

public class Kelimeler implements Serializable {
    private int kelime_id;
    private String kelime_turkce;
    private String kelime_fransizca;
    private String kelime_turu;
    private String kelime_cinsiyeti;
    private String kelime_resmi;
    private Sorular soru;
    private Cumleler cumle;
    public Kelimeler() {
    }

    public Kelimeler(int kelime_id, String kelime_turkce, String kelime_fransizca, String kelime_turu, String kelime_cinsiyeti, String kelime_resmi, Sorular soru, Cumleler cumle) {
        this.kelime_id = kelime_id;
        this.kelime_turkce = kelime_turkce;
        this.kelime_fransizca = kelime_fransizca;
        this.kelime_turu = kelime_turu;
        this.kelime_cinsiyeti = kelime_cinsiyeti;
        this.kelime_resmi = kelime_resmi;
        this.soru = soru;
        this.cumle = cumle;
    }

    public Kelimeler(int kelime_id, String kelime_turkce, String kelime_fransizca, String kelime_turu, String kelime_cinsiyeti, String kelime_resmi, Cumleler cu, Sorular s) {
    }

    public int getKelime_id() {
        return kelime_id;
    }

    public void setKelime_id(int kelime_id) {
        this.kelime_id = kelime_id;
    }

    public String getKelime_turkce() {
        return kelime_turkce;
    }

    public void setKelime_turkce(String kelime_turkce) {
        this.kelime_turkce = kelime_turkce;
    }

    public String getKelime_fransizca() {
        return kelime_fransizca;
    }

    public void setKelime_fransizca(String kelime_fransizca) {
        this.kelime_fransizca = kelime_fransizca;
    }

    public String getKelime_turu() {
        return kelime_turu;
    }

    public void setKelime_turu(String kelime_turu) {
        this.kelime_turu = kelime_turu;
    }

    public String getKelime_cinsiyeti() {
        return kelime_cinsiyeti;
    }

    public void setKelime_cinsiyeti(String kelime_cinsiyeti) {
        this.kelime_cinsiyeti = kelime_cinsiyeti;
    }

    public String getKelime_resmi() {
        return kelime_resmi;
    }

    public void setKelime_resmi(String kelime_resmi) {
        this.kelime_resmi = kelime_resmi;
    }

    public Sorular getSoru() {
        return soru;
    }

    public void setSoru(Sorular soru) {
        this.soru = soru;
    }

    public Cumleler getCumle() {
        return cumle;
    }

    public void setCumle(Cumleler cumle) {
        this.cumle = cumle;
    }
}

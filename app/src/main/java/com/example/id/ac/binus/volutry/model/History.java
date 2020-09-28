package com.example.id.ac.binus.volutry.model;

import java.io.Serializable;

public class History implements Serializable {
    private String idKegiatan;
    private String idFormKegiatan;
    private int gaji;
    private String descriptionPenerimaan;
    private String idVoluntir;
    private int images;
    private String Division;
    private String Date;

    public String getDivision() {
        return Division;
    }

    public void setDivision(String division) {
        Division = division;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public History(){

    }

    public int getImages() {
        return images;
    }

    public void setImages(int images) {
        this.images = images;
    }

    public String getIdKegiatan() {
        return idKegiatan;
    }

    public void setIdKegiatan(String idKegiatan) {
        this.idKegiatan = idKegiatan;
    }

    public String getIdFormKegiatan() {
        return idFormKegiatan;
    }

    public void setIdFormKegiatan(String idFormKegiatan) {
        this.idFormKegiatan = idFormKegiatan;
    }

    public int getGaji() {
        return gaji;
    }

    public void setGaji(int gaji) {
        this.gaji = gaji;
    }

    public String getDescriptionPenerimaan() {
        return descriptionPenerimaan;
    }

    public void setDescriptionPenerimaan(String descriptionPenerimaan) {
        this.descriptionPenerimaan = descriptionPenerimaan;
    }

    public String getIdVoluntir() {
        return idVoluntir;
    }

    public void setIdVoluntir(String idVoluntir) {
        this.idVoluntir = idVoluntir;
    }
}

package com.example.id.ac.binus.volutry.model;

public class FormPenerimaan {
    private String idFormKegiatan;
    private String tanggalPenerimaan;
    private String descriptionPenerimaan;
    private String idVoluntir;
    private String statusPenerimaan;

    public String getStatusPenerimaan() {
        return statusPenerimaan;
    }

    public void setStatusPenerimaan(String statusPenerimaan) {
        this.statusPenerimaan = statusPenerimaan;
    }

    public String getIdFormKegiatan() {
        return idFormKegiatan;
    }

    public void setIdFormKegiatan(String idFormKegiatan) {
        this.idFormKegiatan = idFormKegiatan;
    }

    public String getTanggalPenerimaan() {
        return tanggalPenerimaan;
    }

    public void setTanggalPenerimaan(String tanggalPenerimaan) {
        this.tanggalPenerimaan = tanggalPenerimaan;
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

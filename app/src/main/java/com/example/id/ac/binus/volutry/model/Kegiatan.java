package com.example.id.ac.binus.volutry.model;

public class Kegiatan {

    String NamaKegiatan;
    String TanggalKegiatan;
    String SyaratKegiatan;
    String TipeKegiatan;
    String DeskripsiKegiatan;
    String LokasiKegiatan;
    String Divisi;

    public Kegiatan(){
        //Nothing
    }

    public Kegiatan(String namaKegiatan, String tanggalKegiatan, String syaratKegiatan, String tipeKegiatan, String deskripsiKegiatan, String lokasiKegiatan, String divisi) {
        NamaKegiatan = namaKegiatan;
        TanggalKegiatan = tanggalKegiatan;
        SyaratKegiatan = syaratKegiatan;
        TipeKegiatan = tipeKegiatan;
        DeskripsiKegiatan = deskripsiKegiatan;
        LokasiKegiatan = lokasiKegiatan;
        Divisi = divisi;
    }

    public String getNamaKegiatan() {
        return NamaKegiatan;
    }

    public void setNamaKegiatan(String namaKegiatan) {
        NamaKegiatan = namaKegiatan;
    }

    public String getTanggalKegiatan() {
        return TanggalKegiatan;
    }

    public void setTanggalKegiatan(String tanggalKegiatan) {
        TanggalKegiatan = tanggalKegiatan;
    }

    public String getSyaratKegiatan() {
        return SyaratKegiatan;
    }

    public void setSyaratKegiatan(String syaratKegiatan) {
        SyaratKegiatan = syaratKegiatan;
    }

    public String getTipeKegiatan() {
        return TipeKegiatan;
    }

    public void setTipeKegiatan(String tipeKegiatan) {
        TipeKegiatan = tipeKegiatan;
    }

    public String getDeskripsiKegiatan() {
        return DeskripsiKegiatan;
    }

    public void setDeskripsiKegiatan(String deskripsiKegiatan) {
        DeskripsiKegiatan = deskripsiKegiatan;
    }

    public String getLokasiKegiatan() {
        return LokasiKegiatan;
    }

    public void setLokasiKegiatan(String lokasiKegiatan) {
        LokasiKegiatan = lokasiKegiatan;
    }

    public String getDivisi() {
        return Divisi;
    }

    public void setDivisi(String divisi) {
        Divisi = divisi;
    }
}

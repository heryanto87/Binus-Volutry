package com.example.id.ac.binus.volutry.repository;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/*  Modified by Heryanto
    Date : Saturday February 8,
    2020 Purpose : Creating database and table as well, can be used in the future for updates */


public class    DatabaseHelper extends SQLiteOpenHelper {


    public DatabaseHelper(Context Context) {
        super(Context, "volutry.db", null, 1);
    }

    public static class FeedEntryFormResumeVoluntir implements BaseColumns {

        public static final String TABLE_NAME = "Ms_Voluntir";
        public static final String COL_1 = "voluntirId";
        public static final String COL_2 = "voluntirName";
        public static final String COL_3 = "voluntirAddress";
        public static final String COL_4 = "voluntirPhone";
        public static final String COL_5 = "voluntirGender";
        public static final String COL_6 = "voluntirEmail";
        public static final String COL_7 = "voluntirPassword";
        public static final String COL_8 = "voluntirDescription";
        public static final String COL_9 = "voluntirEducation";
        public static final String COL_10 = "voluntirWorkExp";
        public static final String COL_11 = "voluntirSuppMaterial";
        public static final String COL_12 = "voluntirSkill";
        public static final String COL_13 = "voluntirDOB";
        public static final String COL_14 = "voluntirImage";

    }

    public static final String SQL_CREATE_FORM_RESUME_VOLUNTIR =
            "CREATE TABLE " + FeedEntryFormResumeVoluntir.TABLE_NAME + "(" +
                    FeedEntryFormResumeVoluntir.COL_1 + " CHAR(5) PRIMARY KEY," +
                    FeedEntryFormResumeVoluntir.COL_2 + " VARCHAR(255)," +
                    FeedEntryFormResumeVoluntir.COL_3 + " VARCHAR(255)," +
                    FeedEntryFormResumeVoluntir.COL_4 + " VARCHAR(255)," +
                    FeedEntryFormResumeVoluntir.COL_5 + " VARCHAR(20)," +
                    FeedEntryFormResumeVoluntir.COL_6 + " VARCHAR(20)," +
                    FeedEntryFormResumeVoluntir.COL_7 + " VARCHAR(20)," +
                    FeedEntryFormResumeVoluntir.COL_8 + " VARCHAR(255)," +
                    FeedEntryFormResumeVoluntir.COL_9 + " VARCHAR(50)," +
                    FeedEntryFormResumeVoluntir.COL_10 + " VARCHAR(255)," +
                    FeedEntryFormResumeVoluntir.COL_11 + " BLOB," +
                    FeedEntryFormResumeVoluntir.COL_12 + " VARCHAR(255)," +
                    FeedEntryFormResumeVoluntir.COL_13 + " DATE," +
                    FeedEntryFormResumeVoluntir.COL_14 + " BLOB)";

    public static final String SQL_DELETE_FORM_RESUME_VOLUNTIR =
            "DROP TABLE IF EXISTS " + FeedEntryFormResumeVoluntir.TABLE_NAME;

    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL(SQL_CREATE_KEGIATAN);
        DB.execSQL(SQL_CREATE_FORM_PENERIMAAN);
        DB.execSQL(SQL_CREATE_DETAIL_FORM_PENERIMAAN);
        DB.execSQL(SQL_CREATE_FORM_RESUME_VOLUNTIR);
    }

    public void onUpgrade(SQLiteDatabase DB, int OldVersion, int NewVersion) {
        DB.execSQL(SQL_DELETE_KEGIATAN);
        DB.execSQL(SQL_DELETE_FORM_RESUME_VOLUNTIR);
        DB.execSQL(SQL_DELETE_FORM_PENERIMAAN_DETAIL);
        DB.execSQL(SQL_DELETE_FORM_PENERIMAAN);
        onCreate(DB);
    }

    /*
    Edited By: Eric
    Date: 09 Februari 2020 1:10 PM
    Purpose: Lengkapi Keperluan Database
     */

    //kegiatan
    public static class FeedEntryKegiatan implements BaseColumns {

        public static final String TABLE_NAME = "Ms_Kegiatan";
        public static final String COL_1 = "idKegiatan";
        public static final String COL_2 = "namaKegiatan";
        public static final String COL_3 = "tanggalKegiatan";
        public static final String COL_4 = "syaratKegiatan";
        public static final String COL_5 = "tipeKegiatan";
        public static final String COL_6 = "deskripsiKegiatan";
        public static final String COL_7 = "lokasiKegiatan";
        public static final String COL_8 = "aktivitasKegiatan";
        public static final String COL_9 = "divisiKegiatan";
    }

    //Header Penerimaan
    public static class FeedEntryFormPenerimaan implements BaseColumns{
        public static final String TABLE_NAME = "Tr_FormPenerimaan";
        public static final String COL_1 = "idFormKegiatan";
        public static final String COL_2 = "statusPenerimaan";
        public static final String COL_3 = "tanggalPenerimaan";
        public static final String COL_4 = "descriptionPenerimaan";
        public static final String COL_5 = "idVoluntir";
    }
    //Detail Penerimaan
    public static class FeedEntryDetailFormPenerimaan implements BaseColumns {
        public static final String TABLE_NAME = "Tr_DetailFormPenerimaan";
        public static final String COL_1 = "idFormKegiatan";
        public static final String COL_2 = "idKegiatan";
        public static final String COL_3 = "gaji";
    }

    public static final String SQL_CREATE_FORM_PENERIMAAN =
            "CREATE TABLE " + FeedEntryFormPenerimaan.TABLE_NAME + "(" +
                    FeedEntryFormPenerimaan.COL_1 + " CHAR(5) PRIMARY KEY," +
                    FeedEntryFormPenerimaan.COL_2 + " VARCHAR(500)," +
                    FeedEntryFormPenerimaan.COL_3 + " DATE," +
                    FeedEntryFormPenerimaan.COL_4 + " VARCHAR(500)," + //salah tipe data
                    FeedEntryFormPenerimaan.COL_5 + " CHAR(5), CONSTRAINT FK_Voluntir FOREIGN KEY(idVoluntir) REFERENCES Ms_Voluntir(voluntirId))";

    public static final String SQL_CREATE_DETAIL_FORM_PENERIMAAN =
            "CREATE TABLE " + FeedEntryDetailFormPenerimaan.TABLE_NAME + "(" +
                    FeedEntryDetailFormPenerimaan.COL_1 + " CHAR(5)," +
                    FeedEntryDetailFormPenerimaan.COL_2 + " CHAR(5), " +
                    FeedEntryDetailFormPenerimaan.COL_3 + " INT," +
                    "CONSTRAINT FK_idFormKegiatan FOREIGN KEY ("+FeedEntryDetailFormPenerimaan.COL_1+")REFERENCES Tr_FormPenerimaan(idFormKegiatan)," +
                    " CONSTRAINT FK_idKegiatan FOREIGN KEY ("+FeedEntryDetailFormPenerimaan.COL_2+")REFERENCES Ms_Kegiatan(idKegiatan)," +
                    "PRIMARY KEY("+FeedEntryDetailFormPenerimaan.COL_1+","+FeedEntryDetailFormPenerimaan.COL_2+"))";

    public static final String SQL_DELETE_FORM_PENERIMAAN_DETAIL =
            "DROP TABLE IF EXISTS " + FeedEntryDetailFormPenerimaan.TABLE_NAME;

    public static final String SQL_DELETE_FORM_PENERIMAAN =
            "DROP TABLE IF EXISTS " + FeedEntryFormPenerimaan.TABLE_NAME;

    public static final String SQL_CREATE_KEGIATAN =
            "CREATE TABLE " + FeedEntryKegiatan.TABLE_NAME + "(" +
                    FeedEntryKegiatan.COL_1 + " CHAR(5) PRIMARY KEY," +
                    FeedEntryKegiatan.COL_2 + " VARCHAR(500)," +
                    FeedEntryKegiatan.COL_3 + " DATE," +
                    FeedEntryKegiatan.COL_4 + " VARCHAR(500)," +
                    FeedEntryKegiatan.COL_5 + " VARCHAR(500)," +
                    FeedEntryKegiatan.COL_6 + " VARCHAR(500)," +
                    FeedEntryKegiatan.COL_7 + " VARCHAR(500)," +
                    FeedEntryKegiatan.COL_8 + " VARCHAR(500)," +
                    FeedEntryKegiatan.COL_9 + " VARCHAR(500))";

    public static final String SQL_DELETE_KEGIATAN =
            "DROP TABLE IF EXISTS " + FeedEntryKegiatan.TABLE_NAME;

}


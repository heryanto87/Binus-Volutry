package com.example.id.ac.binus.volutry.repository;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.id.ac.binus.volutry.model.History;

public class HistoryRepository extends DatabaseHelper{

    public HistoryRepository(Context Context) {
        super(Context);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        super.onCreate(DB);
    }

    public History getActivity(String id){
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery(
                "SELECT descriptionPenerimaan, " +
                            "tanggalKegiatan, " +
                            "divisiKegiatan," +
                            "gaji, " +
                            "trd.idFormKegiatan, " +
                            "trd.idKegiatan, " +
                            "CAST(SUBSTR(trd.idKegiatan, 5, 1) AS INT) AS Images " +
                            "FROM Tr_FormPenerimaan as trf " +
                            "JOIN Tr_DetailFormPenerimaan as trd ON trd.idFormKegiatan = trf.idFormKegiatan " +
                            "JOIN Ms_Kegiatan as mk ON trd.idKegiatan = mk.idKegiatan " +
                            "WHERE idVoluntir LIKE '" + id + "' AND statusPenerimaan LIKE 'Succeed'", null);
        cursor.moveToFirst();

        History history = new History();
        if(cursor.getCount() > 0){
            System.out.println("ada");
            history.setDescriptionPenerimaan(cursor.getString(cursor.getColumnIndex("descriptionPenerimaan")));
            history.setDate(cursor.getString(cursor.getColumnIndex("tanggalKegiatan")));
            history.setDivision(cursor.getString(cursor.getColumnIndex("divisiKegiatan")));
            history.setGaji(cursor.getInt(cursor.getColumnIndex("gaji")));
            history.setIdFormKegiatan(cursor.getString(cursor.getColumnIndex("idFormKegiatan")));
            history.setIdKegiatan(cursor.getString(cursor.getColumnIndex("idKegiatan")));
            history.setImages(cursor.getInt(cursor.getColumnIndex("Images")));
        }else{
            System.out.println("gak");
            return null;
        }

        return history;
    }
}

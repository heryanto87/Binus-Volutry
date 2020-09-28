package com.example.id.ac.binus.volutry.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.id.ac.binus.volutry.model.DetailFormPenerimaan;

public class DetailPenerimaanRepository extends DatabaseHelper{
    public DetailPenerimaanRepository(Context Context) {
        super(Context);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        super.onCreate(DB);
    }

    public boolean insert(DetailFormPenerimaan detailFormPenerimaan){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues Values = new ContentValues();

        Values.put("idFormKegiatan", detailFormPenerimaan.getIdFormKegiatan());
        Values.put("idKegiatan", detailFormPenerimaan.getIdKegiatan());
        Values.put("gaji", detailFormPenerimaan.getGaji());

        DB.insert("Tr_DetailFormPenerimaan", null, Values);

        return true;
    }
}

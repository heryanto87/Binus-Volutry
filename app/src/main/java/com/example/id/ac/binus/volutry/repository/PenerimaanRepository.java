package com.example.id.ac.binus.volutry.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.id.ac.binus.volutry.model.FormPenerimaan;

public class PenerimaanRepository extends DatabaseHelper{
    public PenerimaanRepository(Context Context) {
        super(Context);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        super.onCreate(DB);
    }

    public boolean insert(FormPenerimaan FormPenerimaan){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues Values = new ContentValues();

        Values.put("idFormKegiatan", FormPenerimaan.getIdFormKegiatan());
        Values.put("statusPenerimaan", FormPenerimaan.getStatusPenerimaan());
        Values.put("tanggalPenerimaan", FormPenerimaan.getTanggalPenerimaan());
        Values.put("descriptionPenerimaan", FormPenerimaan.getDescriptionPenerimaan());
        Values.put("idVoluntir", FormPenerimaan.getIdVoluntir());

        DB.insert("Tr_FormPenerimaan", null, Values);
        return true;
    }

    public String getIndex(){
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM Tr_FormPenerimaan", null);
        int index = cursor.getCount();
        if(index == 0)
            return "TR001";
        String id = "TR";
        if(index < 10)
            id += "00" + index;
        else if(index < 100)
            id += "0" + index;
        else
            id += index;
        return id;
    }

    public boolean haveRegistered(String id){
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM Tr_FormPenerimaan WHERE idVoluntir LIKE '" + id + "'", null);

        if(cursor.getCount() == 0)
            return true;
        return false;
    }
}

package com.example.id.ac.binus.volutry.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.id.ac.binus.volutry.model.Event;

public class EventRepository extends DatabaseHelper {

    public EventRepository(Context Context) { super(Context); }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        super.onCreate(DB);
    }

    public boolean checkInserted(){
        SQLiteDatabase DatabaseCheck = this.getReadableDatabase();
        Cursor cursor = DatabaseCheck.rawQuery("SELECT * FROM Ms_Kegiatan", null);
        if(cursor.getCount() > 0)
            return true;

        return false;
    }
    public boolean insert(Event event){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues Values = new ContentValues();


        if(event != null){
            Values.put("idKegiatan", event.getEventID());
            Values.put("namaKegiatan", event.getEventName());
            Values.put("tanggalKegiatan", event.getEventDate());
            Values.put("syaratKegiatan", event.getEventCondition());
            Values.put("tipeKegiatan", event.getEventType());
            Values.put("deskripsiKegiatan", event.getEventDescription());
            Values.put("lokasiKegiatan", event.getEventLocation());
            Values.put("aktivitasKegiatan", event.getEventActivity());
            Values.put("divisiKegiatan", event.getEventDivision());
            DB.insert("Ms_Kegiatan", null, Values);
        }
        return true;
    }

    public Event getOneEvent(String id){
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor cursor = DB.rawQuery("SELECT * FROM Ms_Kegiatan WHERE idKegiatan = '" + id + "'", null);
        cursor.moveToFirst();

        Event event = new Event();
        event.setEventID(cursor.getString(cursor.getColumnIndex("idKegiatan")));
        event.setEventName(cursor.getString(cursor.getColumnIndex("namaKegiatan")));
        event.setEventDate(cursor.getString(cursor.getColumnIndex("tanggalKegiatan")));
        event.setEventCondition(cursor.getString(cursor.getColumnIndex("syaratKegiatan")));
        event.setEventType(cursor.getString(cursor.getColumnIndex("tipeKegiatan")));
        event.setEventDescription(cursor.getString(cursor.getColumnIndex("deskripsiKegiatan")));
        event.setEventLocation(cursor.getString(cursor.getColumnIndex("lokasiKegiatan")));
        event.setEventActivity(cursor.getString(cursor.getColumnIndex("aktivitasKegiatan")));
        event.setEventDivision(cursor.getString(cursor.getColumnIndex("divisiKegiatan")));
        return event;
    }
}

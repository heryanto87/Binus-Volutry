package com.example.id.ac.binus.volutry.repository;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.BitmapFactory;
import android.widget.Toast;

import com.example.id.ac.binus.volutry.activity.SignupActivity;
import com.example.id.ac.binus.volutry.model.Voluntir;
import com.example.id.ac.binus.volutry.sharedPreferences.SharedPref;

import java.io.ByteArrayOutputStream;

/*  Modified by Heryanto
    Date : Saturday February 8,
    2020 Purpose : To create next function of application with database query connection*/

public class UserRepository extends DatabaseHelper {

    public UserRepository(Context Context){
        super(Context);
    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        super.onCreate(DB);

    }

    //Insert into Ms_Voluntir Table
    public boolean insert(Voluntir Voluntir){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues Values = new ContentValues();

        if(checkFirstUser() == false) {
            Values.put("voluntirId", "VL001");
        } else {
            Voluntir TempVoluntir = getLastUser();
            String NewVoluntirId = modifyVoluntirId(TempVoluntir);

            System.out.println(NewVoluntirId);

            Values.put("voluntirId", NewVoluntirId);
        }

        Values.put("voluntirName", Voluntir.getVoluntirName());
        Values.put("voluntirAddress", Voluntir.getVoluntirAddress());
        Values.put("voluntirPhone", Voluntir.getVoluntirPhone());
        Values.put("voluntirGender", Voluntir.getVoluntirGender());
        Values.put("voluntirEmail", Voluntir.getVoluntirEmail());
        Values.put("voluntirPassword", Voluntir.getVoluntirPassword());
        Values.put("voluntirDescription", Voluntir.getVoluntirDescription());
        Values.put("voluntirEducation", Voluntir.getVoluntirEducation());
        Values.put("voluntirWorkExp", Voluntir.getVoluntirWorkExp());
        Values.put("voluntirSkill", Voluntir.getVoluntirSkill());
        Values.put("voluntirDOB", Voluntir.getVoluntirDateOfBirth());

        ByteArrayOutputStream StreamImg = new ByteArrayOutputStream();
        Voluntir.getVoluntirImage().compress(android.graphics.Bitmap.CompressFormat.PNG, 100, StreamImg);
        byte[] ByteImage = StreamImg.toByteArray();

        ByteArrayOutputStream StreamSM = new ByteArrayOutputStream();
        Voluntir.getVoluntirSuppMaterial().compress(android.graphics.Bitmap.CompressFormat.PNG, 100, StreamSM);
        byte[] ByteSupport = StreamSM.toByteArray();

        Values.put("voluntirImage", ByteImage);
        Values.put("voluntirSuppMaterial", ByteSupport);

        DB.insert("Ms_Voluntir", null, Values);

        return true;
    }

    //Update into Voluntir Table
    public boolean update(Voluntir Voluntir){
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues Values = new ContentValues();

        Values.put("voluntirAddress", Voluntir.getVoluntirAddress());
        Values.put("voluntirPhone", Voluntir.getVoluntirPhone());
        Values.put("voluntirGender", Voluntir.getVoluntirGender());
        Values.put("voluntirEmail", Voluntir.getVoluntirEmail());
        Values.put("voluntirPassword", Voluntir.getVoluntirPassword());
        Values.put("voluntirDescription", Voluntir.getVoluntirDescription());
        Values.put("voluntirEducation", Voluntir.getVoluntirEducation());
        Values.put("voluntirWorkExp", Voluntir.getVoluntirWorkExp());
        Values.put("voluntirSkill", Voluntir.getVoluntirSkill());
        Values.put("voluntirDOB", Voluntir.getVoluntirDateOfBirth());

        ByteArrayOutputStream StreamImg = new ByteArrayOutputStream();
        Voluntir.getVoluntirImage().compress(android.graphics.Bitmap.CompressFormat.PNG, 100, StreamImg);
        byte[] ByteImage = StreamImg.toByteArray();

        ByteArrayOutputStream StreamSM = new ByteArrayOutputStream();
        Voluntir.getVoluntirSuppMaterial().compress(android.graphics.Bitmap.CompressFormat.PNG, 100, StreamSM);
        byte[] ByteSupport = StreamSM.toByteArray();

        Values.put("voluntirImage", ByteImage);
        Values.put("voluntirSuppMaterial", ByteSupport);

        String[] whereArgs = new String[] {
                String.valueOf(Voluntir.getVoluntirId())
        };

        DB.update("Ms_Voluntir", Values, "voluntirId = ?", whereArgs);

        return true;

    }

    //Cek keberadaan user berdasarkan email dan password
    public boolean checkUser(String Email, String Password) {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor Cursor = DB.rawQuery("SELECT * FROM Ms_Voluntir WHERE voluntirEmail = '" + Email + "' AND voluntirPassword = '" + Password + "'", null);
        if(Cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    //Cek validitas user berdasarkan email dan password
    public Voluntir getLoginUser(String Email, String Password) {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor Cursor = DB.rawQuery("SELECT * FROM Ms_Voluntir WHERE voluntirEmail = '" + Email + "' AND voluntirPassword = '" + Password + "'", null);
        Cursor.moveToFirst();

        Voluntir Voluntir = new Voluntir();

        Voluntir.setVoluntirId(Cursor.getString(Cursor.getColumnIndex("voluntirId")));
        Voluntir.setVoluntirName(Cursor.getString(Cursor.getColumnIndex("voluntirName")));
        Voluntir.setVoluntirAddress(Cursor.getString(Cursor.getColumnIndex("voluntirAddress")));
        Voluntir.setVoluntirGender(Cursor.getString(Cursor.getColumnIndex("voluntirGender")));
        Voluntir.setVoluntirPhone(Cursor.getString(Cursor.getColumnIndex("voluntirPhone")));
        Voluntir.setVoluntirEmail(Cursor.getString(Cursor.getColumnIndex("voluntirEmail")));
        Voluntir.setVoluntirPassword(Cursor.getString(Cursor.getColumnIndex("voluntirPassword")));
        Voluntir.setVoluntirDescription(Cursor.getString(Cursor.getColumnIndex("voluntirDescription")));
        Voluntir.setVoluntirEducation(Cursor.getString(Cursor.getColumnIndex("voluntirEducation")));
        Voluntir.setVoluntirWorkExp(Cursor.getString(Cursor.getColumnIndex("voluntirWorkExp")));
        Voluntir.setVoluntirSkill(Cursor.getString(Cursor.getColumnIndex("voluntirSkill")));
        Voluntir.setVoluntirDateOfBirth(Cursor.getString(Cursor.getColumnIndex("voluntirDOB")));

        return Voluntir;
    }

    //cek user pada row pertama di tabel Ms_Voluntir
    public boolean checkFirstUser() {
        SQLiteDatabase DB = this.getReadableDatabase();
        Cursor Cursor = DB.rawQuery("SELECT * FROM Ms_Voluntir LIMIT 1", null);
        Cursor.moveToFirst();

        if(Cursor.getCount() > 0) {
            return true;
        } else {
            return false;
        }
    }

    //mengambil data terakhir di Ms_Voluntir
    public Voluntir getLastUser() {
        SQLiteDatabase DB = this.getReadableDatabase();

        Cursor Cursor = DB.rawQuery("SELECT * FROM Ms_Voluntir ORDER BY voluntirId DESC LIMIT 1", null);
        Cursor.moveToFirst();

        Voluntir Voluntir = new Voluntir();

        Voluntir.setVoluntirId(Cursor.getString(Cursor.getColumnIndex("voluntirId")));
        Voluntir.setVoluntirName(Cursor.getString(Cursor.getColumnIndex("voluntirName")));
        Voluntir.setVoluntirAddress(Cursor.getString(Cursor.getColumnIndex("voluntirAddress")));
        Voluntir.setVoluntirGender(Cursor.getString(Cursor.getColumnIndex("voluntirGender")));
        Voluntir.setVoluntirPhone(Cursor.getString(Cursor.getColumnIndex("voluntirPhone")));
        Voluntir.setVoluntirEmail(Cursor.getString(Cursor.getColumnIndex("voluntirEmail")));
        Voluntir.setVoluntirPassword(Cursor.getString(Cursor.getColumnIndex("voluntirPassword")));
        Voluntir.setVoluntirDescription(Cursor.getString(Cursor.getColumnIndex("voluntirDescription")));
        Voluntir.setVoluntirEducation(Cursor.getString(Cursor.getColumnIndex("voluntirEducation")));
        Voluntir.setVoluntirWorkExp(Cursor.getString(Cursor.getColumnIndex("voluntirWorkExp")));
        Voluntir.setVoluntirSkill(Cursor.getString(Cursor.getColumnIndex("voluntirSkill")));
        Voluntir.setVoluntirDateOfBirth(Cursor.getString(Cursor.getColumnIndex("voluntirDOB")));

        return Voluntir;
    }

    //fungsi untuk mengganti id voluntir, auto increment
    public String modifyVoluntirId(Voluntir Voluntir){
        SQLiteDatabase DB = this.getReadableDatabase();
        String TempString = Voluntir.getVoluntirId();

        int IncrementNumberId = Integer.parseInt(TempString.substring(TempString.length()-3))+1;

        String NewId = "";

        if(IncrementNumberId < 10) {
            NewId = "VL00" + IncrementNumberId;
        } else if(IncrementNumberId < 100) {
            NewId = "VL0" + IncrementNumberId;
        } else if(IncrementNumberId < 1000) {
            NewId = "VL" + IncrementNumberId;
        }

        return NewId;
    }

    //mengambil data Ms_Voluntir dan mengembalikannya dalam bentuk data class Voluntir
    public Voluntir getVoluntir(String id){
        Voluntir Voluntir = new Voluntir();
        SQLiteDatabase DB = this.getReadableDatabase();

        Cursor Cursor = DB.rawQuery("SELECT * FROM Ms_Voluntir WHERE voluntirId = '"+ id +"'", null);
        Cursor.moveToFirst();
        Voluntir.setVoluntirId(Cursor.getString(Cursor.getColumnIndex("voluntirId")));
        Voluntir.setVoluntirName(Cursor.getString(Cursor.getColumnIndex("voluntirName")));
        Voluntir.setVoluntirAddress(Cursor.getString(Cursor.getColumnIndex("voluntirAddress")));
        Voluntir.setVoluntirGender(Cursor.getString(Cursor.getColumnIndex("voluntirGender")));
        Voluntir.setVoluntirPhone(Cursor.getString(Cursor.getColumnIndex("voluntirPhone")));
        Voluntir.setVoluntirEmail(Cursor.getString(Cursor.getColumnIndex("voluntirEmail")));
        Voluntir.setVoluntirPassword(Cursor.getString(Cursor.getColumnIndex("voluntirPassword")));
        Voluntir.setVoluntirDescription(Cursor.getString(Cursor.getColumnIndex("voluntirDescription")));
        Voluntir.setVoluntirEducation(Cursor.getString(Cursor.getColumnIndex("voluntirEducation")));
        Voluntir.setVoluntirWorkExp(Cursor.getString(Cursor.getColumnIndex("voluntirWorkExp")));
        Voluntir.setVoluntirSkill(Cursor.getString(Cursor.getColumnIndex("voluntirSkill")));
        Voluntir.setVoluntirDateOfBirth(Cursor.getString(Cursor.getColumnIndex("voluntirDOB")));

        byte[] ByteImage = Cursor.getBlob(Cursor.getColumnIndex("voluntirImage"));
        byte[] ByteSupport = Cursor.getBlob(Cursor.getColumnIndex("voluntirSuppMaterial"));

        Voluntir.setVoluntirImage(BitmapFactory.decodeByteArray(ByteImage, 0, ByteImage.length));
        Voluntir.setVoluntirSuppMaterial(BitmapFactory.decodeByteArray(ByteSupport, 0, ByteSupport.length));

        return Voluntir;
    }

}

package com.example.id.ac.binus.volutry.sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import com.example.id.ac.binus.volutry.model.Voluntir;

import java.util.Arrays;

/*  Modified by Heryanto
    Date : Friday February 8,
    2020 Purpose : Saving user login info and can load them when needed */

public class SharedPref extends AppCompatActivity {

    private SharedPreferences SharedPreferences;

    public SharedPref(Context context){
        SharedPreferences = context.getSharedPreferences("sharedPref", Context.MODE_PRIVATE);

    }

    public void save(Voluntir voluntir){
        SharedPreferences.Editor editor = SharedPreferences.edit();
        editor.putString("VoluntirId", voluntir.getVoluntirId());
        editor.putString("VoluntirName", voluntir.getVoluntirName());
        editor.putString("VoluntirAddress", voluntir.getVoluntirAddress());
        editor.putString("VoluntirGender", voluntir.getVoluntirGender());
        editor.putString("VoluntirEmail", voluntir.getVoluntirEmail());
        editor.putString("VoluntirPassword", voluntir.getVoluntirPassword());
        editor.putString("VoluntirDescription", voluntir.getVoluntirDescription());
        editor.putString("VoluntirEducation", voluntir.getVoluntirEducation());
        editor.putString("VoluntirWorkExp", voluntir.getVoluntirWorkExp());
        editor.putString("VoluntirSkill", voluntir.getVoluntirSkill());
        editor.putString("VoluntirDateOfBirth", voluntir.getVoluntirDateOfBirth());
        editor.apply();
    }

    public Voluntir load(){
        Voluntir voluntir = new Voluntir();
        voluntir.setVoluntirId(SharedPreferences.getString("VoluntirId", ""));
        voluntir.setVoluntirName(SharedPreferences.getString("VoluntirName", ""));
        voluntir.setVoluntirAddress(SharedPreferences.getString("VoluntirAddress", ""));
        voluntir.setVoluntirGender(SharedPreferences.getString("VoluntirGender", ""));
        voluntir.setVoluntirEmail(SharedPreferences.getString("VoluntirEmail", ""));
        voluntir.setVoluntirPassword(SharedPreferences.getString("VoluntirPassword", ""));
        voluntir.setVoluntirDescription(SharedPreferences.getString("VoluntirDescription", ""));
        voluntir.setVoluntirEducation(SharedPreferences.getString("VoluntirEducation", ""));
        voluntir.setVoluntirWorkExp(SharedPreferences.getString("VoluntirWorkExp", ""));
        voluntir.setVoluntirSkill(SharedPreferences.getString("VoluntirSkill", ""));
        voluntir.setVoluntirDateOfBirth(SharedPreferences.getString("VoluntirDateOfBirth", ""));
        return voluntir;
    }

}

package com.example.id.ac.binus.volutry.model;

import androidx.databinding.BaseObservable;

import android.graphics.Bitmap;

/*  Modified by Heryanto
    Date : Friday February 7,
    2020 Purpose : Voluntir Model */

public class Voluntir extends BaseObservable{

    String VoluntirId;
    String VoluntirName;
    String VoluntirAddress;
    String VoluntirPhone;
    String VoluntirGender;
    String VoluntirEmail;
    String VoluntirPassword;
    String VoluntirDescription;
    String VoluntirEducation;
    String VoluntirWorkExp;
    Bitmap VoluntirSuppMaterial;
    String VoluntirSkill;
    String VoluntirDateOfBirth;
    Bitmap VoluntirImage;

    public Voluntir(){
        //Nothing
    }

    public Voluntir(String voluntirId, String voluntirName, String voluntirAddress, String voluntirPhone, String voluntirGender, String voluntirEmail, String voluntirPassword, String voluntirDescription, String voluntirEducation, String voluntirWorkExp, Bitmap voluntirSuppMaterial, String voluntirSkill, String voluntirDateOfBirth, Bitmap voluntirImage) {
        VoluntirId = voluntirId;
        VoluntirName = voluntirName;
        VoluntirAddress = voluntirAddress;
        VoluntirPhone = voluntirPhone;
        VoluntirGender = voluntirGender;
        VoluntirEmail = voluntirEmail;
        VoluntirPassword = voluntirPassword;
        VoluntirDescription = voluntirDescription;
        VoluntirEducation = voluntirEducation;
        VoluntirWorkExp = voluntirWorkExp;
        VoluntirSuppMaterial = voluntirSuppMaterial;
        VoluntirSkill = voluntirSkill;
        VoluntirDateOfBirth = voluntirDateOfBirth;
        VoluntirImage = voluntirImage;
    }

    public String getVoluntirId() {
        return VoluntirId;
    }

    public void setVoluntirId(String voluntirId) {
        VoluntirId = voluntirId;
    }

    public String getVoluntirName() {
        return VoluntirName;
    }

    public void setVoluntirName(String voluntirName) {
        VoluntirName = voluntirName;
    }

    public String getVoluntirAddress() {
        return VoluntirAddress;
    }

    public void setVoluntirAddress(String voluntirAddress) {
        VoluntirAddress = voluntirAddress;
    }

    public String getVoluntirPhone() {
        return VoluntirPhone;
    }

    public void setVoluntirPhone(String voluntirPhone) {
        VoluntirPhone = voluntirPhone;
    }

    public String getVoluntirGender() {
        return VoluntirGender;
    }

    public void setVoluntirGender(String voluntirGender) {
        VoluntirGender = voluntirGender;
    }

    public String getVoluntirEmail() {
        return VoluntirEmail;
    }

    public void setVoluntirEmail(String voluntirEmail) {
        VoluntirEmail = voluntirEmail;
    }

    public String getVoluntirPassword() {
        return VoluntirPassword;
    }

    public void setVoluntirPassword(String voluntirPassword) {
        VoluntirPassword = voluntirPassword;
    }

    public String getVoluntirDescription() {
        return VoluntirDescription;
    }

    public void setVoluntirDescription(String voluntirDescription) {
        VoluntirDescription = voluntirDescription;
    }

    public String getVoluntirEducation() {
        return VoluntirEducation;
    }

    public void setVoluntirEducation(String voluntirEducation) {
        VoluntirEducation = voluntirEducation;
    }

    public String getVoluntirWorkExp() {
        return VoluntirWorkExp;
    }

    public void setVoluntirWorkExp(String voluntirWorkExp) {
        VoluntirWorkExp = voluntirWorkExp;
    }

    public Bitmap getVoluntirSuppMaterial() {
        return VoluntirSuppMaterial;
    }

    public void setVoluntirSuppMaterial(Bitmap voluntirSuppMaterial) {
        VoluntirSuppMaterial = voluntirSuppMaterial;
    }

    public String getVoluntirSkill() {
        return VoluntirSkill;
    }

    public void setVoluntirSkill(String voluntirSkill) {
        VoluntirSkill = voluntirSkill;
    }

    public String getVoluntirDateOfBirth() {
        return VoluntirDateOfBirth;
    }

    public void setVoluntirDateOfBirth(String voluntirDateOfBirth) {
        VoluntirDateOfBirth = voluntirDateOfBirth;
    }

    public Bitmap getVoluntirImage() {
        return VoluntirImage;
    }

    public void setVoluntirImage(Bitmap voluntirImage) {
        VoluntirImage = voluntirImage;
    }
}

package com.example.id.ac.binus.volutry.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.id.ac.binus.volutry.R;
import com.example.id.ac.binus.volutry.model.Voluntir;
import com.example.id.ac.binus.volutry.repository.UserRepository;
import com.example.id.ac.binus.volutry.sharedPreferences.SharedPref;

import java.io.IOException;
import java.util.Calendar;

import de.hdodenhof.circleimageview.CircleImageView;

/*  Modified by Heryanto
    Date : Sunday February 9,
    2020 Purpose : Update Profile*/

public class UpdateProfileActivity extends AppCompatActivity {

    TextView TextViewName;
    EditText EditTextEmail;
    RadioGroup RadioGroupGender;
    RadioButton RadioButtonMale;
    RadioButton RadioButtonFemale;
    TextView TextViewDOB;
    EditText EditTextPhone;
    EditText EditTextAddress;
    EditText EditTextDescription;
    EditText EditTextLastEducation;
    EditText EditTextWorkingExp;
    ImageView ImageViewSupportingMaterial;
    EditText EditTextSkill;

    Button ButtonChooseProfileImage;
    Button ButtonChooseSuppMaterial;

    Button ButtonSave;

    String ButtonClicked;

    private DatePicker DatePicker;
    private java.util.Calendar Calendar;
    private TextView DateView;
    private int Year, Month, Day;


    private static final int PICK_IMAGE_REQUEST = 100;
    CircleImageView ImageViewProfile;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_profile);

        SharedPref SharedPref = new SharedPref(UpdateProfileActivity.this);

        TextViewName = findViewById(R.id.textview_name);
        ImageViewProfile = findViewById(R.id.civ_profile);
        EditTextEmail = findViewById(R.id.edittext_email);
        RadioGroupGender = findViewById(R.id.radiogroup_gender);
        RadioButtonMale = findViewById(R.id.radiobutton_male);
        RadioButtonFemale = findViewById(R.id.radiobutton_female);
        TextViewDOB = findViewById(R.id.textview_dob);
        EditTextPhone = findViewById(R.id.edittext_phone);
        EditTextAddress = findViewById(R.id.edittext_address);
        EditTextDescription = findViewById(R.id.edittext_desc);
        EditTextLastEducation = findViewById(R.id.edittext_education);
        EditTextWorkingExp = findViewById(R.id.edittext_workingexp);
        ImageViewSupportingMaterial = findViewById(R.id.imageview_supporting_material);
        EditTextSkill = findViewById(R.id.edittext_skill);

        ButtonChooseProfileImage = findViewById(R.id.button_profile_image);
        ButtonChooseSuppMaterial = findViewById(R.id.button_supp_material);
        ButtonSave = findViewById(R.id.btn_save);

        UserRepository UserRepository = new UserRepository(UpdateProfileActivity.this);
        Voluntir Voluntir = UserRepository.getVoluntir(SharedPref.load().getVoluntirId());

        TextViewName.setText(Voluntir.getVoluntirName());
        EditTextEmail.setText(Voluntir.getVoluntirEmail());
        TextViewDOB.setText(Voluntir.getVoluntirDateOfBirth());
        EditTextPhone.setText(Voluntir.getVoluntirPhone());
        EditTextAddress.setText(Voluntir.getVoluntirAddress());
        EditTextDescription.setText(Voluntir.getVoluntirDescription());
        EditTextLastEducation.setText(Voluntir.getVoluntirEducation());
        EditTextWorkingExp.setText(Voluntir.getVoluntirWorkExp());
        EditTextSkill.setText(Voluntir.getVoluntirSkill());
        ImageViewSupportingMaterial.setImageBitmap(Voluntir.getVoluntirSuppMaterial());
        ImageViewProfile.setImageBitmap(Voluntir.getVoluntirImage());


        //Tombol untuk menambahkan profile image
        ButtonChooseProfileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, PICK_IMAGE_REQUEST);
                ButtonClicked = "ButtonChooseProfileImage";
            }
        });

        //Tombol untuk menambahkan supporting material
        ButtonChooseSuppMaterial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, PICK_IMAGE_REQUEST);
                ButtonClicked = "ButtonChooseSuppMaterial";
            }
        });

        //Memilih Date of Birth
        TextViewDOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar = Calendar.getInstance();
                Year = Calendar.get(Calendar.YEAR);
                Month = Calendar.get(Calendar.MONTH);
                Day = Calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog=new DatePickerDialog(
                        UpdateProfileActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month+1;
                        String Date=day+"/"+month+"/"+year;
                        TextViewDOB.setText(Date);
                    }
                },Year,Month,Day);
                datePickerDialog.show();
            }
        });

        ButtonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Email = EditTextEmail.getText().toString().trim();
                String DOB = TextViewDOB.getText().toString().trim();
                String Phone = EditTextPhone.getText().toString().trim();
                String Address = EditTextAddress.getText().toString().trim();
                String Description = EditTextDescription.getText().toString().trim();
                String Education = EditTextLastEducation.getText().toString().trim();
                String WorkExp = EditTextWorkingExp.getText().toString().trim();
                String Gender = "";
                if(RadioButtonMale.isChecked()) {
                    Gender = "Male";
                } else if(RadioButtonFemale.isChecked()) {
                    Gender = "Female";
                }

                UserRepository UserRepository = new UserRepository(UpdateProfileActivity.this);

                ImageViewProfile = findViewById(R.id.civ_profile);
                ImageViewSupportingMaterial = findViewById(R.id.imageview_supporting_material);
                ImageViewProfile.invalidate();
                ImageViewSupportingMaterial.invalidate();

                BitmapDrawable BitmapImageDrawable = (BitmapDrawable) ImageViewProfile.getDrawable();
                BitmapDrawable BitmapSuppMaterialDrawable = (BitmapDrawable) ImageViewSupportingMaterial.getDrawable();

                Bitmap ImageViewBitmap = BitmapImageDrawable.getBitmap();
                Bitmap ImageSuppMaterialBitmap = BitmapSuppMaterialDrawable.getBitmap();

                Voluntir Voluntir = new Voluntir();

                SharedPref SharedPrefInner = new SharedPref(UpdateProfileActivity.this);

                Voluntir.setVoluntirId(SharedPrefInner.load().getVoluntirId());
                Voluntir.setVoluntirEmail(Email);
                Voluntir.setVoluntirGender(Gender);
                Voluntir.setVoluntirDateOfBirth(DOB);
                Voluntir.setVoluntirPhone(Phone);
                Voluntir.setVoluntirAddress(Address);
                Voluntir.setVoluntirDescription(Description);
                Voluntir.setVoluntirEducation(Education);
                Voluntir.setVoluntirWorkExp(WorkExp);
                Voluntir.setVoluntirImage(ImageViewBitmap);
                Voluntir.setVoluntirSuppMaterial(ImageSuppMaterialBitmap);

                SharedPrefInner.save(Voluntir);

                UserRepository.update(Voluntir);

                Toast.makeText(UpdateProfileActivity.this, "Update Success", Toast.LENGTH_SHORT).show();

                Intent Intent = new Intent(UpdateProfileActivity.this, MainActivity.class);
                startActivity(Intent);
                finish();
            }
        });

        if(SharedPref.load().getVoluntirGender().equals("Male")) {
            RadioButtonMale.setChecked(true);
        } else if (SharedPref.load().getVoluntirGender().equals("Female")) {
            RadioButtonFemale.setChecked(true);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch(requestCode){
            case PICK_IMAGE_REQUEST:
                if(resultCode == RESULT_OK){
                    Uri selectedImage = data.getData();

                    try {
                        Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), selectedImage);
                        if(ButtonClicked.equals("ButtonChooseProfileImage")) {
                            ImageViewProfile.setImageBitmap(bitmap);
                        } else if (ButtonClicked.equals("ButtonChooseSuppMaterial")) {
                            ImageViewSupportingMaterial.setImageBitmap(bitmap);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                break;
        }
    }

}

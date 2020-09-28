package com.example.id.ac.binus.volutry.activity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.id.ac.binus.volutry.R;
import com.example.id.ac.binus.volutry.model.Voluntir;
import com.example.id.ac.binus.volutry.repository.UserRepository;

import java.util.Calendar;
import java.util.regex.Pattern;

/*  Modified by Heryanto
    Date : Saturday February 8,
    2020 Purpose : Signup and directing to login activity */

public class SignupActivity extends AppCompatActivity {

    private Button ButtonSignUp;

    private EditText EditTextName;
    private RadioGroup RadioGroupGender;
    private RadioButton RadioButtonMale;
    private RadioButton RadioButtonFemale;
    private TextView TextViewDate;
    private EditText EditTextPhone;
    private EditText EditTextEmail;
    private EditText EditTextPassword;
    private EditText EditTextRePassword;

    private DatePicker DatePicker;
    private Calendar Calendar;
    private TextView DateView;
    private int Year, Month, Day;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        EditTextName = findViewById(R.id.edittext_name);
        RadioGroupGender = findViewById(R.id.radiogroup_gender);
        RadioButtonMale = findViewById(R.id.radiobutton_male);
        RadioButtonFemale = findViewById(R.id.radiobutton_female);
        TextViewDate = findViewById(R.id.textview_date);
        EditTextPhone = findViewById(R.id.edittext_phone);
        EditTextEmail = findViewById(R.id.edittext_email);
        EditTextPassword = findViewById(R.id.edittext_password);
        EditTextRePassword = findViewById(R.id.edittext_re_password);

        Calendar = Calendar.getInstance();
        Year = Calendar.get(Calendar.YEAR);
        Month = Calendar.get(Calendar.MONTH);
        Day = Calendar.get(Calendar.DAY_OF_MONTH);

        TextViewDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog=new DatePickerDialog(
                        SignupActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int day) {
                        month = month+1;
                        String Date=day+"/"+month+"/"+year;
                        TextViewDate.setText(Date);
                    }
                },Year,Month,Day);
                datePickerDialog.show();
            }
        });

        ButtonSignUp = findViewById(R.id.button_signup);


        //Saat tombol sign up ditekan
        ButtonSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Name = EditTextName.getText().toString().trim();
                int Gender = RadioGroupGender.getCheckedRadioButtonId();
                String Date = TextViewDate.getText().toString().trim();
                String Phone = EditTextPhone.getText().toString().trim();
                String Email = EditTextEmail.getText().toString().trim();
                String Password = EditTextPassword.getText().toString().trim();

                UserRepository UserRepository = new UserRepository(SignupActivity.this);
                Voluntir Voluntir = new Voluntir();

                Voluntir.setVoluntirName(Name);
                Voluntir.setVoluntirDateOfBirth(Date);
                Voluntir.setVoluntirPhone(Phone);
                Voluntir.setVoluntirEmail(Email);
                Voluntir.setVoluntirPassword(Password);

                Bitmap BitmapProfile = BitmapFactory.decodeResource(getResources(), R.drawable.ic_profile);
                Bitmap BitmapSuppMaterial = BitmapFactory.decodeResource(getResources(), R.drawable.upload_file);

                Voluntir.setVoluntirImage(BitmapProfile);
                Voluntir.setVoluntirSuppMaterial(BitmapSuppMaterial);

                if(Gender == RadioButtonMale.getId()){
                    Voluntir.setVoluntirGender("Male");
                }else if(Gender==RadioButtonFemale.getId()){
                    Voluntir.setVoluntirGender("Female");
                }

                if(!checkName(Name)) {
                    Toast.makeText(SignupActivity.this, "Name must be 4 alphabet or higher", Toast.LENGTH_SHORT).show();
                } else if (!checkDateOfBirth(Date)) {
                    Toast.makeText(SignupActivity.this, "Date cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (!checkEmail(Email)) {
                    Toast.makeText(SignupActivity.this, "Wrong email input i.e : me@me.me", Toast.LENGTH_SHORT).show();
                } else if (!checkGender(Gender)) {
                    Toast.makeText(SignupActivity.this, "Gender cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (!checkPhoneNumber(Phone)) {
                    Toast.makeText(SignupActivity.this, "Phone cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (!checkPassword(Password, EditTextRePassword.getText().toString().trim())) {
                    Toast.makeText(SignupActivity.this, "Wrong Password", Toast.LENGTH_SHORT).show();
                } else {
                    boolean Insert = UserRepository.insert(Voluntir);

                    if(Insert == true) {
                        Toast.makeText(SignupActivity.this, "Register Success", Toast.LENGTH_SHORT).show();

                        Intent Intent = new Intent(SignupActivity.this, LoginActivity.class);
                        startActivity(Intent);
                        finish();

                    }else {
                        Toast.makeText(SignupActivity.this, "Register Failed", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    //Validasi Nama
    public boolean checkName(String Name) {
        if(Name.length() < 4) {
            return false;
        } else {
            return true;
        }
    }

    //Validasi Email
    public boolean checkEmail(String Email) {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(emailRegex);

        if(!pat.matcher(Email).matches() || Email.length()<1) {
            Toast.makeText(this, "Wrong email input i.e : me@me.me", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    //Validasi Gender
    public boolean checkGender(int Gender){
        if(Gender == 0) {
            return false;
        } else {
            return true;
        }
    }

    //Validasi Date Of Birth
    public boolean checkDateOfBirth(String DOB){
        if(DOB.length()<1) {
            return false;
        } else {
            return true;
        }
    }

    //Validasi Phone Number
    public boolean checkPhoneNumber(String Phone){
        if(Phone.length()<1) {
            return false;
        } else {
            return true;
        }
    }

    //Validasi Password
    public boolean checkPassword(String Password, String RePassword){
        if(Password.length()<1 || !Password.equals(RePassword)) {
            return false;
        } else {
            return true;
        }
    }
}

package com.example.id.ac.binus.volutry.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.id.ac.binus.volutry.R;
import com.example.id.ac.binus.volutry.model.Voluntir;
import com.example.id.ac.binus.volutry.sharedPreferences.SharedPref;
import com.example.id.ac.binus.volutry.repository.UserRepository;

/*  Modified by Heryanto
    Date : Saturday February 8,
    2020 Purpose : Login and directing to main activity */

public class LoginActivity extends AppCompatActivity {

    private LinearLayout ButtonSignup;
    private Button ButtonLogin;
    private EditText EditTextEmail;
    private EditText EditTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButtonSignup = findViewById(R.id.button_signup);
        ButtonLogin = findViewById(R.id.button_login);
        EditTextEmail = findViewById(R.id.edittext_email);
        EditTextPassword = findViewById(R.id.edittext_password);

        ButtonSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Intent = new Intent(LoginActivity.this, SignupActivity.class);
                startActivity(Intent);
            }
        });

        ButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String EditTextEmailString = EditTextEmail.getText().toString().trim();
                String EditTextPasswordString = EditTextPassword.getText().toString().trim();

                if(EditTextEmailString == null || EditTextPasswordString == null) {
                    Toast.makeText(LoginActivity.this, "Email or Password cannot be empty", Toast.LENGTH_SHORT).show();
                } else if (EditTextEmailString.equals(" ") || EditTextPasswordString.equals(" ")) {
                    Toast.makeText(LoginActivity.this, "Email or Password cannot be empty", Toast.LENGTH_SHORT).show();
                } else {
                    login(EditTextEmailString, EditTextPasswordString);
                }
            }
        });
    }

    //Validasi Email dan Password ke database
    private void login(String Email, String Password) {

        UserRepository UserRepository = new UserRepository(LoginActivity.this);

        boolean LoginStatus = UserRepository.checkUser(Email, Password);

        if(LoginStatus == true) {

            Voluntir Voluntir = new Voluntir();
            Voluntir = UserRepository.getLoginUser(Email, Password);

            SharedPref SharedPref = new SharedPref(LoginActivity.this);
            SharedPref.save(Voluntir);

            Toast.makeText(LoginActivity.this, "Welcome " + SharedPref.load().getVoluntirName(), Toast.LENGTH_SHORT).show();

            Intent Intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(Intent);
            finish();
        } else {
            Toast.makeText(LoginActivity.this, "Fail to retrieve user data", Toast.LENGTH_SHORT).show();
        }
    }

}

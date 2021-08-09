package com.example.catering.Registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.catering.R;

public class RegistrationActivity extends AppCompatActivity {
    private Button btn_signup_email,btn_signup_phone,btn_login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initView();

        btn_signup_email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RegistrationActivity.this,SelectUser.class);
                intent.putExtra("Home","Signup");
                startActivity(intent);

            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RegistrationActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });

    }



    private void initView() {

        btn_signup_email = findViewById(R.id.btn_signup_email);

        btn_login = findViewById(R.id.btn_login);
    }
}
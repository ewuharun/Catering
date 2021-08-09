package com.example.catering.Registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.catering.R;

public class LoginActivity extends AppCompatActivity {
    private Button btn_login_email,btn_login_phone,btn_register;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        initView();

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(intent);
            }
        });

        btn_login_phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,LoginByPhoneActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initView() {
        btn_login_email= findViewById(R.id.btn_login_email);
        btn_login_phone = findViewById(R.id.btn_login_phone);
        btn_register = findViewById(R.id.btn_register);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
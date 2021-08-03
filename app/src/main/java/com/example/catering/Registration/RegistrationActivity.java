package com.example.catering.Registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.catering.R;

public class RegistrationActivity extends AppCompatActivity {
    private Button btn_signUp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        initView();



        btn_signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gotoChooseUser();
            }
        });
    }

    private void gotoChooseUser() {
        Intent intent = new Intent(RegistrationActivity.this,SelectUser.class);
        intent.putExtra("Home","Signup");
        startActivity(intent);
    }

    private void initView() {
        btn_signUp = findViewById(R.id.btn_signup);
    }
}
package com.example.catering;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.catering.Customer.CustomerMainActivity;
import com.example.catering.Registration.RegistrationActivity;
import com.example.catering.Utils.SessionManager;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    private ImageView logoIV;
    private TextView titleTV;

    private FirebaseAuth fAuth;
    private FirebaseDatabase fDatabase;
    private DatabaseReference fRef;
    private SessionManager sessionManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initVariable();
        animateLogo();

        boolean hasUser = sessionManager.isUserLoggedIn();

        if(hasUser){
            gotoCustomerMainActivity();
        }else{
            gotoRegistrationPage();
        }
    }

    private void gotoCustomerMainActivity() {
        Intent intent = new Intent(MainActivity.this, CustomerMainActivity.class);
        startActivity(intent);
        finish();
    }

    private void initVariable() {
        sessionManager = new SessionManager(getApplicationContext());
    }

    private void gotoRegistrationPage() {
        Intent intent = new Intent(MainActivity.this, RegistrationActivity.class);
        startActivity(intent);
        finish();
    }

    private void animateLogo() {
        ObjectAnimator animation = ObjectAnimator.ofFloat(logoIV,"translationY",100f);
        animation.setDuration(1000);
        animation.start();
    }

    private void initView() {
        logoIV = findViewById(R.id.logoIV);
        titleTV = findViewById(R.id.titleTV);
    }
}
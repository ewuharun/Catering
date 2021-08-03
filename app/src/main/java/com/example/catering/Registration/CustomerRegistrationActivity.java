package com.example.catering.Registration;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Spinner;

import com.example.catering.R;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class CustomerRegistrationActivity extends AppCompatActivity {

    private Spinner sp_thana,sp_area;
    private TextInputEditText nameEt,emailEt,passwordEt,confirmPasswordEt;
    private ArrayList<Thana> thanaList;
    private ArrayList<Area> areaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_registration);

        initView();
        initVariable();
        getThanaList();
        getAreaList();

    }

    private void initVariable() {
        thanaList = new ArrayList<Thana>();
    }

    private void getThanaList() {

    }


    private void initView() {
        sp_thana = findViewById(R.id.sp_thana);
        sp_area = findViewById(R.id.sp_area);

        nameEt = findViewById(R.id.nameEt);
        emailEt = findViewById(R.id.emailEt);
        passwordEt = findViewById(R.id.passwordEt);
        confirmPasswordEt = findViewById(R.id.confirmPasswordEt);
    }
}
package com.example.catering.Registration;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.catering.R;

public class SelectUser extends AppCompatActivity {
    private Button btn_cheff,btn_customer,btn_delivery;
    private String type="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_user);

        initView();

        type = getIntent().getStringExtra("Home").trim().toString();

        btn_customer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.equals("Signup")){
                    Intent intent = new Intent(SelectUser.this,CustomerRegistrationActivity.class);
                    intent.putExtra("Role","customer");
                    startActivity(intent);
                }
            }
        });

        btn_cheff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.equals("Signup")){
                    Intent intent = new Intent(SelectUser.this,CustomerRegistrationActivity.class);
                    intent.putExtra("Role","cheff");
                    startActivity(intent);
                }
            }
        });

        btn_delivery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(type.equals("Signup")){
                    Intent intent = new Intent(SelectUser.this,CustomerRegistrationActivity.class);
                    intent.putExtra("Role","delivery_man");
                    startActivity(intent);
                }
            }
        });


    }



    private void initView() {
        btn_cheff = findViewById(R.id.btn_cheff);
        btn_customer = findViewById(R.id.btn_customer);
        btn_delivery = findViewById(R.id.btn_delivery);
    }
}
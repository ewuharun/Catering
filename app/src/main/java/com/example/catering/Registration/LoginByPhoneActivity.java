package com.example.catering.Registration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.catering.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginByPhoneActivity extends AppCompatActivity {

    EditText et_number;
    TextView txt_signup;
    Button btn_send_otp,btn_email_signing;
    FirebaseAuth fAuth;
    FirebaseDatabase firebaseDatabase;
    String number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_by_phone);

        initView();


        btn_send_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginByPhoneActivity.this, "clicked", Toast.LENGTH_SHORT).show();
                number=et_number.getText().toString().trim();

                FirebaseDatabase.getInstance().getReference("User").addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot data : snapshot.getChildren()){
                            String phone = data.child("phone").getValue().toString();
                            String role = data.child("role").getValue().toString();

                            Toast.makeText(LoginByPhoneActivity.this, number, Toast.LENGTH_SHORT).show();


                            if(phone.equals(number)){

                                Intent intent=new Intent(LoginByPhoneActivity.this,SendOtpActivity.class);
                                intent.putExtra("phoneNumber",number);
                                intent.putExtra("Role",role);
                                startActivity(intent);
                                finish();
                                return;
                            }

                        }

                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });




            }
        });

        txt_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LoginByPhoneActivity.this,RegistrationActivity.class);
                startActivity(intent);
                finish();
            }
        });

        btn_email_signing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private void initView() {
        et_number=(EditText)findViewById(R.id.et_phoneNO);
        btn_send_otp=(Button)findViewById(R.id.btn_send_otp);
        btn_email_signing=(Button)findViewById(R.id.btn_email_signup);
        txt_signup=(TextView)findViewById(R.id.txt_signup);
        fAuth=FirebaseAuth.getInstance();
    }
}
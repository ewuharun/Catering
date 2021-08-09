package com.example.catering.Registration;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.catering.R;
import com.example.catering.Registration.Model.Area;
import com.example.catering.Registration.Model.Thana;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.HashMap;

public class CustomerRegistrationActivity extends AppCompatActivity {

    private Spinner sp_thana,sp_area;
    private TextInputEditText nameEt,emailEt,passwordEt,confirmPasswordEt,phoneEt;
    private Button btn_login,btn_register;
    private ArrayList<Thana> thanaList;
    private ArrayList<Area> areaList;

    private String name,email,phone,password,houseNo,than_id,area_id;

    private FirebaseAuth fAuth;
    private FirebaseDatabase fDatabase;
    private DatabaseReference fRef;

    private boolean validity;
    private ProgressDialog mDialog;

    String role;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_registration);

        initView();

        role = getIntent().getStringExtra("Role");

        initVariable();
        getThanaList();
        getAreaList();
        submitData();


        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(CustomerRegistrationActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });



    }

    private void submitData() {
        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validData()){

                    mDialog.show();

                    fAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull @org.jetbrains.annotations.NotNull Task<AuthResult> task) {
                            if(task.isSuccessful()){

                                String uid=FirebaseAuth.getInstance().getCurrentUser().getUid();

                                fRef = FirebaseDatabase.getInstance().getReference("User").child(uid);
                                final HashMap<String,String> val= new HashMap<>();
                                val.put("role",role);
                                val.put("phone",phone);

                                fRef.setValue(val).addOnCompleteListener(new OnCompleteListener<Void>() {
                                    @Override
                                    public void onComplete(@NonNull Task<Void> task) {
                                        HashMap<String,String> values = new HashMap<>();
                                        values.put("name",name);
                                        values.put("email",email);
                                        values.put("phone",phone);
                                        values.put("password",password);

                                        FirebaseDatabase.getInstance().getReference(role).child(uid).setValue(values).addOnCompleteListener(new OnCompleteListener<Void>() {
                                            @Override
                                            public void onComplete(@NonNull Task<Void> task) {
                                                if(task.isSuccessful()){
                                                    fAuth.getCurrentUser().sendEmailVerification().addOnCompleteListener(new OnCompleteListener<Void>() {
                                                        @Override
                                                        public void onComplete(@NonNull Task<Void> task) {
                                                            if(task.isSuccessful()){
                                                                mDialog.dismiss();

                                                                AlertDialog.Builder builder = new AlertDialog.Builder(CustomerRegistrationActivity.this);
                                                                builder.setMessage("Successfully Registered");
                                                                builder.setCancelable(false);
                                                                builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                                                    @Override
                                                                    public void onClick(DialogInterface dialog, int which) {
                                                                        dialog.dismiss();
                                                                    }
                                                                });
                                                                AlertDialog dialog = builder.create();
                                                                dialog.show();

                                                            }else{
                                                                mDialog.dismiss();
                                                                Log.e("Error",task.getException().getMessage());
                                                            }
                                                        }
                                                    });

                                                }
                                            }
                                        });

                                    }
                                });

                            }else{
                                Toast.makeText(CustomerRegistrationActivity.this, task.getException().getMessage(), Toast.LENGTH_LONG).show();
                                mDialog.dismiss();
                            }

                        }
                    });
                }
            }
        });

    }

    private boolean validData() {
        getData();
        validity = true;



        return validity;

    }

    private void getData() {
        name="Harun or rashid";
        email="harunk873@gmail.com";
        phone="01531946638";
        houseNo="1044/47";
        than_id="1";
        area_id="4";
        password = "harunk873";

    }

    private void getAreaList() {
    }

    private void initVariable() {
        thanaList = new ArrayList<Thana>();
        fAuth=FirebaseAuth.getInstance();
        mDialog = new ProgressDialog(CustomerRegistrationActivity.this);
        mDialog.setMessage("Please wait while registering...");
        mDialog.setCancelable(false);
        mDialog.setCanceledOnTouchOutside(false);
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
        phoneEt = findViewById(R.id.phoneEt);
        btn_register = findViewById(R.id.btn_register);
        btn_login = findViewById(R.id.btn_login);
    }
}
package com.cs.project.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeUi extends AppCompatActivity {
    Button btnRegisteration,btnLogin,btnDepartment,btnAdmin;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_ui);
        preferences=getSharedPreferences("USER_DETIALS",MODE_PRIVATE);
        String regno=preferences.getString("REGISTERNO",null);
        if (regno!=null){
            startActivity(new Intent(getApplicationContext(),Home2.class));
        }

        btnAdmin=(Button)findViewById(R.id.adminHomeUi);
        btnDepartment=(Button)findViewById(R.id.departmentHomeUi);
        btnLogin=(Button)findViewById(R.id.loginHomeUi);
        btnRegisteration=(Button)findViewById(R.id.registerHomeUi);

        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),AdminLogin.class));
            }
        });

        btnRegisteration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Registeration.class));
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Login.class));
            }
        });
        btnDepartment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),DepartmentLogin.class));
            }
        });
    }
}

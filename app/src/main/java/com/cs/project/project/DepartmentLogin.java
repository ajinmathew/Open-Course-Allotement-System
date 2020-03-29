package com.cs.project.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class DepartmentLogin extends AppCompatActivity {
Spinner spinner;
EditText edUserId,edPassword;
Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_login);

        spinner=(Spinner)findViewById(R.id.deptDepartmentLogin);
        edPassword=(EditText)findViewById(R.id.passwordDepartmentLogin);
        edUserId=(EditText)findViewById(R.id.userIdDepartmentLogin);
        btnLogin=(Button) findViewById(R.id.loginDepartmentLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Dept=spinner.getSelectedItem().toString().trim();
                if (Dept.equals("Select Department")){
                    Toast.makeText(getApplicationContext(),"Select Department",Toast.LENGTH_LONG).show();
                }else if (edUserId.getText().toString().isEmpty()){
                    edUserId.setError("required Field");
                    edUserId.requestFocus();
                }else if (edPassword.getText().toString().isEmpty()){
                    edPassword.setError("required Field");
                    edPassword.requestFocus();
                }else {
                    if (edUserId.getText().toString().trim().equals("dept")&&edPassword.getText().toString().trim().equals("12345")){
                        Intent intent=new Intent(getApplicationContext(),DepartmentHome.class);
                        intent.putExtra("DEPARTMENT",Dept);
                        startActivity(intent);
                    }
                }
            }
        });


    }
}

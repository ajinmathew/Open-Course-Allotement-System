package com.cs.project.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AdminLogin extends AppCompatActivity {
EditText userId,password;
Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login);

        btnLogin=(Button)findViewById(R.id.loginAdminLogin);
        userId=(EditText)findViewById(R.id.userIdAdminLogin);
        password=(EditText)findViewById(R.id.passwordAdminLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userid=userId.getText().toString().trim();
                String pass=password.getText().toString().trim();
                if (userid.equals("admin")&&pass.equals("12345")){
                    startActivity(new Intent(getApplicationContext(),AdminHome.class));
                }else {
                    Toast.makeText(getApplicationContext(),"Authentication Error",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}

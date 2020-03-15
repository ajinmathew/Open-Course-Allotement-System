package com.cs.project.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
Button btnLogin;
EditText edRegNo,edPass;
    FirebaseAuth mAuth;
    DatabaseReference reference;
    SharedPreferences.Editor editor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edPass=(EditText)findViewById(R.id.passwordLogin);
        edRegNo=(EditText)findViewById(R.id.regNoLogin);
        btnLogin=(Button)findViewById(R.id.loginLogin);
        mAuth=FirebaseAuth.getInstance();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edRegNo.getText().toString().trim().isEmpty()){
                    edRegNo.setError("Register No Required");
                    edRegNo.requestFocus();
                }else if (edPass.getText().toString().trim().isEmpty()){
                    edPass.setError("Password Required");
                    edPass.requestFocus();
                }else {
                    editor=getSharedPreferences("USER_DETIALS",MODE_PRIVATE).edit();
                    final String RegNo=edRegNo.getText().toString().trim();
                    final String PassWord=edPass.getText().toString().trim();
                    reference= FirebaseDatabase.getInstance().getReference().child("Allotement").child("Student Detials").child(RegNo);
                    reference.addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if (dataSnapshot.exists()){
                                Toast.makeText(getApplicationContext(),"Already Exist",Toast.LENGTH_LONG).show();
                                final String email=dataSnapshot.child("emailid").getValue().toString().trim();
                                mAuth.signInWithEmailAndPassword(email,PassWord).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull Task<AuthResult> task) {
                                        if (task.isSuccessful()){
                                            Toast.makeText(getApplicationContext(),"Authentication Completed",Toast.LENGTH_LONG).show();
                                            editor.putString("EMAIL",email);
                                            editor.putString("REGISTERNO",RegNo);
                                            editor.commit();
                                            startActivity(new Intent(getApplicationContext(),Home2.class));
                                        }else {
                                            Toast.makeText(getApplicationContext(),"Authentication Error",Toast.LENGTH_LONG).show();
                                        }
                                    }
                                });
                            }else {
                                Toast.makeText(getApplicationContext(),"Not Exist",Toast.LENGTH_LONG).show();
                            }
                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }
            }
        });
    }
}

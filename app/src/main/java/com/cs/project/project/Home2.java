package com.cs.project.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Home2 extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    TextView txtUserName,txtRegNo;
    DatabaseReference reference;
    Button btnApply,btnStatus,btnLogout,btnEdit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        txtUserName=(TextView)findViewById(R.id.usernameHome2);
        txtRegNo=(TextView)findViewById(R.id.userregnoHome2);
        sharedPreferences=getSharedPreferences("USER_DETIALS",MODE_PRIVATE);
        String regno=sharedPreferences.getString("REGISTERNO",null);
        //Toast.makeText(getApplicationContext(),regno,Toast.LENGTH_LONG).show();
        btnApply=(Button)findViewById(R.id.applyHome2);
        btnEdit=(Button)findViewById(R.id.editHome2);
        btnLogout=(Button)findViewById(R.id.logoutHome2);
        btnStatus=(Button)findViewById(R.id.statusHome2);
        reference= FirebaseDatabase.getInstance().getReference().child("Allotement").child("Student Detials").child(regno);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                txtUserName.setText(dataSnapshot.child("name").getValue().toString().trim());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        txtRegNo.setText(regno);
        //Apply application...
        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),ApplyApplication.class));
            }
        });
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor=getSharedPreferences("USER_DETIALS",MODE_PRIVATE).edit();
                editor.clear();
                editor.commit();
                Toast.makeText(getApplicationContext(),"Successfully Logout",Toast.LENGTH_LONG).show();

                moveTaskToBack(true);
                android.os.Process.killProcess(android.os.Process.myPid());
                System.exit(1);
            }
        });
        btnEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),EditApplication.class));
            }
        });
        btnStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),StatusApplication.class));
            }
        });
    }
}

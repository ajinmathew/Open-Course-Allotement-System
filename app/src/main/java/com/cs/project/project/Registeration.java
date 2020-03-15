package com.cs.project.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.niwattep.materialslidedatepicker.SlideDatePickerDialog;
import com.niwattep.materialslidedatepicker.SlideDatePickerDialogCallback;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Registeration extends AppCompatActivity implements SlideDatePickerDialogCallback {
    Button btnCalender,btnRegister;
    Spinner spDepartment;
    EditText edName,edRegNo,edeMailid,edPassword,edCnfPassword;
    String DOB="";
    String regNo,Name,eMail,Password;
    User user;
    SharedPreferences.Editor editor;
    DatabaseReference databaseReference;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);

        edName=(EditText)findViewById(R.id.nameReg);
        edRegNo=(EditText)findViewById(R.id.regNoReg);
        edeMailid=(EditText)findViewById(R.id.emailReg);
        edPassword=(EditText)findViewById(R.id.passwordReg);
        edCnfPassword=(EditText)findViewById(R.id.cnfpasswordReg);

        spDepartment=(Spinner)findViewById(R.id.departmentReg);
        btnCalender=(Button) findViewById(R.id.dobReg);
        btnRegister=(Button) findViewById(R.id.registerReg);
        mAuth=FirebaseAuth.getInstance();

        btnCalender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SlideDatePickerDialog.Builder builder=new SlideDatePickerDialog.Builder();
                SlideDatePickerDialog dialog=builder.build();
                dialog.show(getSupportFragmentManager(),"Dialog");
            }
        });

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                user=new User();
                Name=edName.getText().toString().trim();
                regNo=edRegNo.getText().toString().trim();
                eMail=edeMailid.getText().toString().trim();
                Password=edPassword.getText().toString().trim();

                if (Name.isEmpty()){
                    edName.setError("Name Required");
                    edName.requestFocus();
                }else if (DOB.equals("")){
                    Toast.makeText(getApplicationContext(),"Select DoB",Toast.LENGTH_LONG).show();
                }else if (regNo.isEmpty()){
                    edRegNo.setError("RegisterNo Required");
                    edRegNo.requestFocus();
                }else if (spDepartment.getSelectedItem().toString().equals("Select Department")){
                    Toast.makeText(getApplicationContext(),"Select Department",Toast.LENGTH_LONG).show();
                }else if (eMail.isEmpty()){
                    edeMailid.setError("eMail id Required");
                    edeMailid.requestFocus();
                }else if (Password.isEmpty()){
                    edPassword.setError("Password Required");
                    edPassword.requestFocus();
                }else if (edCnfPassword.getText().toString().trim().isEmpty()){
                    edCnfPassword.setError("Password Required");
                    edCnfPassword.requestFocus();
                }else {
                    if (Password.equals(edCnfPassword.getText().toString().trim())) {

                        user.setDepartment(spDepartment.getSelectedItem().toString().trim());
                        user.setDob(DOB);
                        user.setEmailid(eMail);
                        user.setName(Name);
                        user.setPassword(Password);
                        user.setRegisterno(regNo);

                        editor=getSharedPreferences("USER_DETIALS",MODE_PRIVATE).edit();

                        mAuth.createUserWithEmailAndPassword(eMail,Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()){
                                    Toast.makeText(getApplicationContext(),"Authentication Completed",Toast.LENGTH_LONG).show();
                                    editor.putString("EMAIL",eMail);
                                    editor.putString("REGISTERNO",regNo);
                                    editor.commit();
                                    startActivity(new Intent(getApplicationContext(),Home2.class));
                                }else {
                                    Toast.makeText(getApplicationContext(),"Authentication Error",Toast.LENGTH_LONG).show();
                                }
                            }
                        });
                        databaseReference= FirebaseDatabase.getInstance().getReference().child("Allotement").child("Student Detials").child(regNo);
                        databaseReference.setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(getApplicationContext(),"Data Inserted",Toast.LENGTH_LONG).show();
                            }
                        });
                    }
                    else {
                        edCnfPassword.setError("Incorrect Password");
                        edCnfPassword.requestFocus();
                        edCnfPassword.setText("");
                    }
                }
            }
        });

    }

    @Override
    public void onPositiveClick(int day, int month, int year, Calendar calendar) {
//use EEEE in pattern for impliment the day such as Sunday....
        SimpleDateFormat format=new SimpleDateFormat("dd MMM,YYYY", Locale.getDefault());
        btnCalender.setText(format.format(calendar.getTime()));
        DOB=format.format(calendar.getTime());
    }
}

package com.cs.project.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ApplyApplication extends AppCompatActivity {
EditText edName,edDob,edDept,edRegNo,edeMail,edTotalMark,edObtMark;
SharedPreferences preferences;
DatabaseReference reference,databaseReference;
Button btnApply;
String gender="";
String stream="";
String disaster="";
String physical="";
String physics="";
String accounting="";
String maths="";
String web="";
RadioButton male,female,hse,vhse,thse,disaster1,disaster2,disaster3,disaster4,accounting1,accounting2,accounting3,accounting4,maths1,maths2,maths3,maths4,web1,web2,web3,web4,physical1,physical2,physical3,physical4,physics1,physics2,physics3,physics4,physics5,physics6,maths5,maths6,accounting5,accounting6,disaster5,disaster6,web5,web6,physical5,physical6;
Apply apply;
User user;
float indexmark,obtmark,totalmark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_application);


        edDept=(EditText)findViewById(R.id.departmentApply);
        edDob=(EditText)findViewById(R.id.dobApply);
        edeMail=(EditText)findViewById(R.id.emailApply);
        edName=(EditText)findViewById(R.id.nameApply);
        edRegNo=(EditText)findViewById(R.id.regNoApply);
        edTotalMark=(EditText)findViewById(R.id.aggmarkApply);
        edObtMark=(EditText)findViewById(R.id.obtmarkApply);

        male=(RadioButton)findViewById(R.id.maleGenderApply);
        female=(RadioButton)findViewById(R.id.femaleGenderApply);
        hse=(RadioButton)findViewById(R.id.hseApply);
        vhse=(RadioButton)findViewById(R.id.vhseApply);
        thse=(RadioButton)findViewById(R.id.thseApply);
        disaster1=(RadioButton)findViewById(R.id.dis1Apply);
        disaster2=(RadioButton)findViewById(R.id.dis2Apply);
        disaster3=(RadioButton)findViewById(R.id.dis3Apply);
        disaster4=(RadioButton)findViewById(R.id.dis4Apply);
        disaster5=(RadioButton)findViewById(R.id.dis5Apply);
        disaster6=(RadioButton)findViewById(R.id.dis6Apply);
        accounting1=(RadioButton)findViewById(R.id.acc1Apply);
        accounting2=(RadioButton)findViewById(R.id.acc2Apply);
        accounting3=(RadioButton)findViewById(R.id.acc3Apply);
        accounting4=(RadioButton)findViewById(R.id.acc4Apply);
        accounting5=(RadioButton)findViewById(R.id.acc5Apply);
        accounting6=(RadioButton)findViewById(R.id.acc6Apply);
        maths1=(RadioButton)findViewById(R.id.mat1Apply);
        maths2=(RadioButton)findViewById(R.id.mat2Apply);
        maths3=(RadioButton)findViewById(R.id.mat3Apply);
        maths4=(RadioButton)findViewById(R.id.mat4Apply);
        maths5=(RadioButton)findViewById(R.id.mat5Apply);
        maths6=(RadioButton)findViewById(R.id.mat6Apply);
        web1=(RadioButton)findViewById(R.id.web1Apply);
        web2=(RadioButton)findViewById(R.id.web2Apply);
        web3=(RadioButton)findViewById(R.id.web3Apply);
        web4=(RadioButton)findViewById(R.id.web4Apply);
        web5=(RadioButton)findViewById(R.id.web5Apply);
        web6=(RadioButton)findViewById(R.id.web6Apply);
        physics1=(RadioButton)findViewById(R.id.phy1Apply);
        physics2=(RadioButton)findViewById(R.id.phy2Apply);
        physics3=(RadioButton)findViewById(R.id.phy3Apply);
        physics4=(RadioButton)findViewById(R.id.phy4Apply);
        physics5=(RadioButton)findViewById(R.id.phy5Apply);
        physics6=(RadioButton)findViewById(R.id.phy6Apply);
        physical1=(RadioButton)findViewById(R.id.edu1Apply);
        physical2=(RadioButton)findViewById(R.id.edu2Apply);
        physical3=(RadioButton)findViewById(R.id.edu3Apply);
        physical4=(RadioButton)findViewById(R.id.edu4Apply);
        physical5=(RadioButton)findViewById(R.id.edu5Apply);
        physical6=(RadioButton)findViewById(R.id.edu6Apply);

        btnApply=(Button)findViewById(R.id.applyApply);

        preferences=getSharedPreferences("USER_DETIALS",MODE_PRIVATE);
        String RegNo=preferences.getString("REGISTERNO",null);
        reference= FirebaseDatabase.getInstance().getReference().child("Allotement").child("Student Detials").child(RegNo);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                user=dataSnapshot.getValue(User.class);
                edDept.setText(user.department);
                edName.setText(user.name);
                edDob.setText(user.dob);
                edRegNo.setText(user.registerno);
                edeMail.setText(user.emailid);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        databaseReference=FirebaseDatabase.getInstance().getReference().child("Allotement").child("Allotement Data").child(RegNo);

        btnApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(getApplicationContext(),user.registerno,Toast.LENGTH_LONG).show();

                if (male.isChecked()){
                    gender="male";
                }
                if (female.isChecked()){
                    gender="female";
                }
                if (hse.isChecked()){
                    stream="hse";
                }
                if (vhse.isChecked()){
                    stream="vhse";
                }
                if (thse.isChecked()){
                    stream="thse";
                }
                if (disaster1.isChecked()){
                    disaster="1";
                }
                if (disaster2.isChecked()){
                    disaster="2";
                }
                if (disaster3.isChecked()){
                    disaster="3";
                }
                if (disaster4.isChecked()){
                    disaster="4";
                }
                if (disaster5.isChecked()){
                    disaster="5";
                }
                if (disaster6.isChecked()){
                    disaster="6";
                }
                if (accounting1.isChecked()){
                    accounting="1";
                }
                if (accounting2.isChecked()){
                    accounting="2";
                }
                if (accounting3.isChecked()){
                    accounting="3";
                }
                if (accounting4.isChecked()){
                    accounting="4";
                }
                if (accounting5.isChecked()){
                    accounting="5";
                }
                if (accounting6.isChecked()){
                    accounting="6";
                }
                if (web1.isChecked()){
                    web="1";
                }
                if (web2.isChecked()){
                    web="2";
                }
                if (web3.isChecked()){
                    web="3";
                }
                if (web4.isChecked()){
                    web="4";
                }
                if (web5.isChecked()){
                    web="5";
                }
                if (web6.isChecked()){
                    web="6";
                }
                if (maths1.isChecked()){
                    maths="1";
                }
                if (maths2.isChecked()){
                    maths="2";
                }
                if (maths3.isChecked()){
                    maths="3";
                }
                if (maths4.isChecked()){
                    maths="4";
                }
                if (maths5.isChecked()){
                    maths="5";
                }
                if (maths6.isChecked()){
                    maths="6";
                }
                if (physical1.isChecked()){
                    physical="1";
                }if (physical2.isChecked()){
                    physical="2";
                }if (physical3.isChecked()){
                    physical="3";
                }if (physical4.isChecked()){
                    physical="4";
                }if (physical5.isChecked()){
                    physical="5";
                }if (physical6.isChecked()){
                    physical="6";
                }if (physics1.isChecked()){
                    physics="1";
                }if (physics2.isChecked()){
                    physics="2";
                }if (physics3.isChecked()){
                    physics="3";
                }if (physics4.isChecked()){
                    physics="4";
                }if (physics5.isChecked()){
                    physics="5";
                }if (physics6.isChecked()){
                    physics="6";
                }
                //Validations..
                if (gender.equals("")){
                    Toast.makeText(getApplicationContext(),"Select Gender",Toast.LENGTH_LONG).show();
                }else if (stream.equals("")){
                    Toast.makeText(getApplicationContext(),"Select Stream",Toast.LENGTH_LONG).show();
                }else if (edTotalMark.getText().toString().trim().isEmpty()){
                    edTotalMark.setError("Mark Required");
                    edTotalMark.requestFocus();
                }else if (edObtMark.getText().toString().trim().isEmpty()){
                    edObtMark.setError("Mark Required");
                    edObtMark.requestFocus();
                }else if (disaster.equals("")){
                    Toast.makeText(getApplicationContext(),"Select Options",Toast.LENGTH_LONG).show();
                }else if (accounting.equals("")){
                    Toast.makeText(getApplicationContext(),"Select Options",Toast.LENGTH_LONG).show();
                }else if (maths.equals("")){
                    Toast.makeText(getApplicationContext(),"Select Options",Toast.LENGTH_LONG).show();
                }else if (web.equals("")){
                    Toast.makeText(getApplicationContext(),"Select Options",Toast.LENGTH_LONG).show();
                }else if (physics.equals("")){
                    Toast.makeText(getApplicationContext(),"Select Options",Toast.LENGTH_LONG).show();
                }
                else if (physical.equals("")){
                    Toast.makeText(getApplicationContext(),"Select Options",Toast.LENGTH_LONG).show();
                }else if (disaster.equals(accounting)||disaster.equals(maths)||disaster.equals(web)||disaster.equals(physical)||disaster.equals(physics)){
                    Toast.makeText(getApplicationContext(),"Preferences are Same!",Toast.LENGTH_LONG).show();
                }else if (accounting.equals(maths)||accounting.equals(web)||accounting.equals(physics)||accounting.equals(physical)){
                    Toast.makeText(getApplicationContext(),"Preferences are Same!",Toast.LENGTH_LONG).show();
                }else if (maths.equals(web)||maths.equals(physical)||maths.equals(physics)){
                    Toast.makeText(getApplicationContext(),"Preferences are Same!",Toast.LENGTH_LONG).show();
                }else if (web.equals(physics)||web.equals(physical)||physical.equals(physics)){
                    Toast.makeText(getApplicationContext(),"Preferences are Same!",Toast.LENGTH_LONG).show();
                }
                else {


                    obtmark=Float.parseFloat(edObtMark.getText().toString().trim());
                    totalmark=Float.parseFloat(edTotalMark.getText().toString().trim());

                    indexmark=(obtmark/totalmark)*100;

                    apply=new Apply();
                    apply.setName(user.name);
                    apply.setDOB(user.dob);
                    apply.setDepartment(user.department);
                    apply.seteMailid(user.emailid);
                    apply.setRegisterno(user.registerno);
                    apply.setGender(gender);
                    apply.setStream(stream);
                    apply.setObtained_Mark(edObtMark.getText().toString().trim());
                    apply.setTotal_Mark(edTotalMark.getText().toString().trim());
                    apply.setAccounting(accounting);
                    apply.setDisaster(disaster);
                    apply.setMathematics(maths);
                    apply.setWeb(web);
                    apply.setPhysical(physical);
                    apply.setPhysics(physics);
                    apply.setIndex_Mark(String.valueOf(indexmark));
                    apply.setVerify("Not Verify");
                    apply.setAllotement("Not Alloted");

                    databaseReference.setValue(apply).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getApplicationContext(),"Application Submitted",Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });
    }
}

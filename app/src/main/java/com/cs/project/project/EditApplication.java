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

public class EditApplication extends AppCompatActivity {
    SharedPreferences preferences;
    DatabaseReference reference;
    Button btnUpdate,btnDelete;
    String gender="";
    String stream="";
    String disaster="";
    String accounting="";
    String maths="";
    String web="";
    String physical="";
    String physics="";
    RadioButton male,female,hse,vhse,thse,disaster1,disaster2,disaster3,disaster4,disaster5,disaster6,accounting1,accounting2,accounting3,accounting4,accounting5,accounting6,maths1,maths2,maths3,maths4,maths5,maths6,web1,web2,web3,web4,web5,web6,physical1,physical2,physical3,physical4,physical5,physical6,physics1,physics2,physics3,physics4,physics5,physics6;
    Apply apply;
    User user;
    float indexmark,obtmark,totalmark;
    EditText edName,edDob,edDept,edRegNo,edeMail,edTotalMark,edObtMark;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_application);
        edDept=(EditText)findViewById(R.id.departmentEdit);
        edDob=(EditText)findViewById(R.id.dobEdit);
        edeMail=(EditText)findViewById(R.id.emailEdit);
        edName=(EditText)findViewById(R.id.nameEdit);
        edRegNo=(EditText)findViewById(R.id.regNoEdit);
        edTotalMark=(EditText)findViewById(R.id.aggmarkEdit);
        edObtMark=(EditText)findViewById(R.id.obtmarkEdit);
        male=(RadioButton)findViewById(R.id.maleGenderEdit);
        female=(RadioButton)findViewById(R.id.femaleGenderEdit);
        hse=(RadioButton)findViewById(R.id.hseEdit);
        vhse=(RadioButton)findViewById(R.id.vhseEdit);
        thse=(RadioButton)findViewById(R.id.thseEdit);
        disaster1=(RadioButton)findViewById(R.id.dis1Edit);
        disaster2=(RadioButton)findViewById(R.id.dis2Edit);
        disaster3=(RadioButton)findViewById(R.id.dis3Edit);
        disaster4=(RadioButton)findViewById(R.id.dis4Edit);
        disaster5=(RadioButton)findViewById(R.id.dis5Edit);
        disaster6=(RadioButton)findViewById(R.id.dis6Edit);
        accounting1=(RadioButton)findViewById(R.id.acc1Edit);
        accounting2=(RadioButton)findViewById(R.id.acc2Edit);
        accounting3=(RadioButton)findViewById(R.id.acc3Edit);
        accounting4=(RadioButton)findViewById(R.id.acc4Edit);
        accounting5=(RadioButton)findViewById(R.id.acc5Edit);
        accounting6=(RadioButton)findViewById(R.id.acc6Edit);
        maths1=(RadioButton)findViewById(R.id.mat1Edit);
        maths2=(RadioButton)findViewById(R.id.mat2Edit);
        maths3=(RadioButton)findViewById(R.id.mat3Edit);
        maths4=(RadioButton)findViewById(R.id.mat4Edit);
        maths5=(RadioButton)findViewById(R.id.mat5Edit);
        maths6=(RadioButton)findViewById(R.id.mat6Edit);
        web1=(RadioButton)findViewById(R.id.web1Edit);
        web2=(RadioButton)findViewById(R.id.web2Edit);
        web3=(RadioButton)findViewById(R.id.web3Edit);
        web4=(RadioButton)findViewById(R.id.web4Edit);
        web5=(RadioButton)findViewById(R.id.web5Edit);
        web6=(RadioButton)findViewById(R.id.web6Edit);
        physical1=(RadioButton)findViewById(R.id.edu1Edit);
        physical2=(RadioButton)findViewById(R.id.edu2Edit);
        physical3=(RadioButton)findViewById(R.id.edu3Edit);
        physical4=(RadioButton)findViewById(R.id.edu4Edit);
        physical5=(RadioButton)findViewById(R.id.edu5Edit);
        physical6=(RadioButton)findViewById(R.id.edu6Edit);
        physics1=(RadioButton)findViewById(R.id.phy1Edit);
        physics2=(RadioButton)findViewById(R.id.phy2Edit);
        physics3=(RadioButton)findViewById(R.id.phy3Edit);
        physics4=(RadioButton)findViewById(R.id.phy4Edit);
        physics5=(RadioButton)findViewById(R.id.phy5Edit);
        physics6=(RadioButton)findViewById(R.id.phy6Edit);



        btnUpdate=(Button)findViewById(R.id.updateEdit);
        btnDelete=(Button)findViewById(R.id.deleteEdit);
        preferences=getSharedPreferences("USER_DETIALS",MODE_PRIVATE);
        String RegNo=preferences.getString("REGISTERNO",null);
        reference=FirebaseDatabase.getInstance().getReference().child("Allotement").child("Allotement Data").child(RegNo);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    Apply apply=dataSnapshot.getValue(Apply.class);
                    edName.setText(apply.Name);
                    edDob.setText(apply.DOB);
                    edRegNo.setText(apply.Registerno);
                    edeMail.setText(apply.eMailid);
                    edDept.setText(apply.Department);
                    edObtMark.setText(apply.Obtained_Mark);
                    edTotalMark.setText(apply.Total_Mark);
                    if (apply.getGender().equals("male")){
                        male.setChecked(true);
                    }else if (apply.getGender().equals("female")){
                        female.setChecked(true);
                    }
                    if (apply.getStream().equals("hse")){
                        hse.setChecked(true);
                    }else if (apply.getStream().equals("vhse")){
                        vhse.setChecked(true);
                    }else if (apply.getStream().equals("thse")){
                        thse.setChecked(true);
                    }
                    if (apply.getDisaster().equals("1")){
                        disaster1.setChecked(true);
                    }else if (apply.getDisaster().equals("2")){
                        disaster2.setChecked(true);
                    }else if (apply.getDisaster().equals("3")){
                        disaster3.setChecked(true);
                    }else if (apply.getDisaster().equals("4")){
                        disaster4.setChecked(true);
                    }else if (apply.getDisaster().equals("5")){
                        disaster5.setChecked(true);
                    }else if (apply.getDisaster().equals("6")){
                        disaster6.setChecked(true);
                    }
                    if (apply.getMathematics().equals("1")){
                        maths1.setChecked(true);
                    }else if (apply.getMathematics().equals("2")){
                        maths2.setChecked(true);
                    }else if (apply.getMathematics().equals("3")){
                        maths3.setChecked(true);
                    }else if (apply.getMathematics().equals("4")){
                        maths4.setChecked(true);
                    }else if (apply.getMathematics().equals("5")){
                        maths5.setChecked(true);
                    }else if (apply.getMathematics().equals("6")){
                        maths6.setChecked(true);
                    }
                    if (apply.getPhysical().equals("1")){
                        physical1.setChecked(true);
                    }else if (apply.getPhysical().equals("2")){
                        physical2.setChecked(true);
                    }else if (apply.getPhysical().equals("3")){
                        physical3.setChecked(true);
                    }else if (apply.getPhysical().equals("4")){
                        physical4.setChecked(true);
                    }else if (apply.getPhysical().equals("5")){
                        physical5.setChecked(true);
                    }else if (apply.getPhysical().equals("6")){
                        physical6.setChecked(true);
                    }

                    if (apply.getPhysics().equals("1")){
                        physics1.setChecked(true);
                    }else if (apply.getPhysics().equals("2")){
                        physics2.setChecked(true);
                    }else if (apply.getPhysics().equals("3")){
                        physics3.setChecked(true);
                    }else if (apply.getPhysics().equals("4")){
                        physics4.setChecked(true);
                    }else if (apply.getPhysics().equals("5")){
                        physics5.setChecked(true);
                    }else if (apply.getPhysics().equals("6")){
                        physics6.setChecked(true);
                    }

                    if (apply.getAccounting().equals("1")){
                        accounting1.setChecked(true);
                    }else if (apply.getAccounting().equals("2")){
                        accounting2.setChecked(true);
                    }else if (apply.getAccounting().equals("3")){
                        accounting3.setChecked(true);
                    }else if (apply.getAccounting().equals("4")){
                        accounting4.setChecked(true);
                    }else if (apply.getAccounting().equals("5")){
                        accounting5.setChecked(true);
                    }else if (apply.getAccounting().equals("6")){
                        accounting6.setChecked(true);
                    }
                    if (apply.getWeb().equals("1")){
                        web1.setChecked(true);
                    }else if (apply.getWeb().equals("2")){
                        web2.setChecked(true);
                    }else if (apply.getWeb().equals("3")){
                        web3.setChecked(true);
                    }else if (apply.getWeb().equals("4")){
                        web4.setChecked(true);
                    }else if (apply.getWeb().equals("5")){
                        web5.setChecked(true);
                    }else if (apply.getWeb().equals("6")){
                        web6.setChecked(true);
                    }

                }else {
                    Toast.makeText(getApplicationContext(),"File not found",Toast.LENGTH_LONG).show();
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(getApplicationContext(),"File not found",Toast.LENGTH_LONG).show();
            }
        });


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.removeValue().addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(),"Application Removed",Toast.LENGTH_LONG).show();
                    }
                });
            }
        });


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                }else if (physical.equals("")){
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
                    apply.setName(edName.getText().toString().trim());
                    apply.setDOB(edDob.getText().toString().trim());
                    apply.setDepartment(edDept.getText().toString().trim());
                    apply.seteMailid(edeMail.getText().toString().trim());
                    apply.setRegisterno(edRegNo.getText().toString().trim());
                    apply.setGender(gender);
                    apply.setStream(stream);
                    apply.setObtained_Mark(edObtMark.getText().toString().trim());
                    apply.setTotal_Mark(edTotalMark.getText().toString().trim());
                    apply.setAccounting(accounting);
                    apply.setDisaster(disaster);
                    apply.setMathematics(maths);
                    apply.setPhysical(physical);
                    apply.setPhysics(physics);
                    apply.setWeb(web);
                    apply.setIndex_Mark(String.valueOf(indexmark));
                    apply.setVerify("Not Verify");
                    apply.setAllotement("Not Alloted");

                    reference.setValue(apply).addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void aVoid) {
                            Toast.makeText(getApplicationContext(),"Application Updated",Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }
        });


    }
}

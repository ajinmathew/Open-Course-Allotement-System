package com.cs.project.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class DepartmentView extends AppCompatActivity {
String regNo;
DatabaseReference reference,databasereference;
TextView txtVerify,txtWeb,txtMaths,txtAccounting,txtDisaster,txtRegNo,txtName,txtDob,txtDept,txteMail,txtGender,txtStream,txtObtMark,txtTotalMark,txtIndexMark;
Button btnVerify;
TextView txtPhysics,txtPhysical;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_view);
        regNo=getIntent().getStringExtra("RegNo");
        txtRegNo=(TextView)findViewById(R.id.regNoDepartmentView);
        txtName=(TextView)findViewById(R.id.nameDepartmentView);
        txtDob=(TextView)findViewById(R.id.dobDepartmentView);
        txtDept=(TextView)findViewById(R.id.deptDepartmentView);
        txteMail=(TextView)findViewById(R.id.emailDepartmentView);
        txtGender=(TextView)findViewById(R.id.genderDepartmentView);
        txtTotalMark=(TextView)findViewById(R.id.totalMarkDepartmentView);
        txtObtMark=(TextView)findViewById(R.id.obtMarkDepartmentView);
        txtIndexMark=(TextView)findViewById(R.id.indexMarkDepartmentView);
        txtStream=(TextView)findViewById(R.id.streamDepartmentView);
        txtVerify=(TextView)findViewById(R.id.verifyStatusDepartmentView);
        txtAccounting=(TextView)findViewById(R.id.accountingDepartmentView);
        txtWeb=(TextView)findViewById(R.id.webDepartmentView);
        txtDisaster=(TextView)findViewById(R.id.disasterDepartmentView);
        txtMaths=(TextView)findViewById(R.id.mathsDepartmentView);
        txtPhysical=(TextView)findViewById(R.id.physicalDepartmentView);
        txtPhysics=(TextView)findViewById(R.id.physicsDepartmentView);
        btnVerify=(Button)findViewById(R.id.verifyBtnDepartmentView);
        reference= FirebaseDatabase.getInstance().getReference().child("Allotement").child("Allotement Data").child(regNo);
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Apply apply=dataSnapshot.getValue(Apply.class);
                txtRegNo.setText(apply.Registerno);
                txtName.setText(apply.Name);
                txtDob.setText(apply.DOB);
                txtDept.setText(apply.Department);
                txtGender.setText(apply.Gender);
                txteMail.setText(apply.eMailid);
                txtStream.setText(apply.Stream);
                txtObtMark.setText(apply.Obtained_Mark);
                txtTotalMark.setText(apply.Total_Mark);
                txtIndexMark.setText(apply.Index_Mark);
                txtVerify.setText(apply.Verify);
                txtWeb.setText(apply.Web);
                txtMaths.setText(apply.Mathematics);
                txtDisaster.setText(apply.Disaster);
                txtAccounting.setText(apply.Accounting);
                txtPhysical.setText(apply.Physical);
                txtPhysics.setText(apply.Physics);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                databasereference=FirebaseDatabase.getInstance().getReference().child("Allotement").child("Allotement Data").child(regNo).child("verify");
                databasereference.setValue("Verified");
                Toast.makeText(getApplicationContext(),"Verified",Toast.LENGTH_LONG).show();
            }
        });
    }
}

package com.cs.project.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class AdminHome extends AppCompatActivity {
EditText edMaths,edWeb,edDisaster,edAccounting;
Button btnOrder,btnAllotement,btnGet;
List<Apply> pre_list;
DatabaseReference reference;
int count;
int weblimit,mathslimit,disasterlimit,accountinglimit;
String allotement="null";
TextView txtNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);

        edAccounting=(EditText)findViewById(R.id.accountingAdminHome);
        edDisaster=(EditText)findViewById(R.id.disasterAdminHome);
        edMaths=(EditText)findViewById(R.id.mathsAdminHome);
        edWeb=(EditText)findViewById(R.id.webAdminHome);

        txtNo=(TextView)findViewById(R.id.noAdminHome);

        btnAllotement=(Button)findViewById(R.id.allotementAdminHome);
        btnOrder=(Button)findViewById(R.id.orderAdminHome);
        btnGet=(Button)findViewById(R.id.acceptAdminHome);

        reference=FirebaseDatabase.getInstance().getReference().child("Allotement").child("Allotement Data");
        pre_list=new ArrayList<>();

        btnGet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edMaths.getText().toString().isEmpty()){
                    edMaths.setError("Required field");
                    edMaths.requestFocus();
                }else if (edWeb.getText().toString().isEmpty()){
                    edWeb.setError("Required field");
                    edWeb.requestFocus();
                }else if (edAccounting.getText().toString().isEmpty()){
                    edAccounting.setError("Required field");
                    edAccounting.requestFocus();
                }else if (edDisaster.getText().toString().isEmpty()){
                    edDisaster.setError("Required field");
                    edDisaster.requestFocus();
                }else {
                    weblimit=Integer.parseInt(edWeb.getText().toString().trim());
                    mathslimit=Integer.parseInt(edMaths.getText().toString().trim());
                    disasterlimit=Integer.parseInt(edDisaster.getText().toString().trim());
                    accountinglimit=Integer.parseInt(edAccounting.getText().toString().trim());
                }

            }
        });


        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        count = (int) dataSnapshot.getChildrenCount();
                        txtNo.setText(String.valueOf(count));
                        for (DataSnapshot preSort:dataSnapshot.getChildren()){
                            Apply apply=preSort.getValue(Apply.class);
                            pre_list.add(apply);
                        }
                        for (int i=0;i<count;i++){
                            for (int j=i+1;j<count;j++){
                                Apply api=pre_list.get(i);
                                Apply apj=pre_list.get(j);
                                if (Float.parseFloat(api.getIndex_Mark())<Float.parseFloat(apj.getIndex_Mark())){
                                    pre_list.set(i,apj);
                                    pre_list.set(j,api);
                                }
                            }
                        }
                        Toast.makeText(getApplicationContext(),"Sorting Completed",Toast.LENGTH_LONG).show();
                        btnAllotement.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });


            }
        });


        btnAllotement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                for (int i=0;i<count;i++){
                    Apply ap1=pre_list.get(i);

                    if ((ap1.getMathematics().equals("1"))&&(mathslimit>0)){
                        allotement="Business Mathematics";
                        mathslimit--;
                    }else if ((ap1.getWeb().equals("1"))&&(weblimit>0)){
                        allotement="Web Technology";
                        weblimit--;
                    }else if ((ap1.getDisaster().equals("1"))&&(disasterlimit>0)){
                        allotement="Disaster Management";
                        disasterlimit--;
                    }else if ((ap1.getAccounting().equals("1"))&&(accountinglimit>0)){
                        allotement="Basic Accounting";
                        accountinglimit--;
                    }else {
                        if ((ap1.getMathematics().equals("2"))&&(mathslimit>0)){
                            allotement="Business Mathematics";
                            mathslimit--;
                        }else if ((ap1.getWeb().equals("2"))&&(weblimit>0)){
                            allotement="Web Technology";
                            weblimit--;
                        }else if ((ap1.getDisaster().equals("2"))&&(disasterlimit>0)){
                            allotement="Disaster Management";
                            disasterlimit--;
                        }else if ((ap1.getAccounting().equals("2"))&&(accountinglimit>0)){
                            allotement="Basic Accounting";
                            accountinglimit--;
                        }else {
                            if ((ap1.getMathematics().equals("3"))&&(mathslimit>0)){
                                allotement="Business Mathematics";
                                mathslimit--;
                            }else if ((ap1.getWeb().equals("3"))&&(weblimit>0)){
                                allotement="Web Technology";
                                weblimit--;
                            }else if ((ap1.getDisaster().equals("3"))&&(disasterlimit>0)){
                                allotement="Disaster Management";
                                disasterlimit--;
                            }else if ((ap1.getAccounting().equals("3"))&&(accountinglimit>0)){
                                allotement="Basic Accounting";
                                accountinglimit--;
                            }else {
                                if ((ap1.getMathematics().equals("4"))&&(mathslimit>0)){
                                    allotement="Business Mathematics";
                                    mathslimit--;
                                }else if ((ap1.getWeb().equals("4"))&&(weblimit>0)){
                                    allotement="Web Technology";
                                    weblimit--;
                                }else if ((ap1.getDisaster().equals("4"))&&(disasterlimit>0)){
                                    allotement="Disaster Management";
                                    disasterlimit--;
                                }else if ((ap1.getAccounting().equals("4"))&&(accountinglimit>0)){
                                    allotement="Basic Accounting";
                                    accountinglimit--;
                                }
                            }
                        }
                    }
                    reference=FirebaseDatabase.getInstance().getReference().child("Allotement").child("Allotement Data").child(ap1.Registerno).child("allotement");
                    reference.setValue(allotement);
                    Toast.makeText(getApplicationContext(),"Allotement Completed",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}

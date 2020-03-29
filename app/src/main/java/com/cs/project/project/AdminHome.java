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
Button btnOrder,btnAllotement,btnGet;
List<Apply> pre_list;
DatabaseReference reference;
int count,vercount;
int weblimit=28,mathslimit=38,disasterlimit=25,accountinglimit=60,physicslimit=38,physicallimit=30;
String allotement="null";
TextView txtNo,txtVer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home);


        txtNo=(TextView)findViewById(R.id.noAdminHome);
        txtVer=(TextView)findViewById(R.id.verAdminHome);



        vercount=0;

        btnAllotement=(Button)findViewById(R.id.allotementAdminHome);
        btnOrder=(Button)findViewById(R.id.orderAdminHome);
        reference=FirebaseDatabase.getInstance().getReference().child("Allotement").child("Allotement Data");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                count = (int) dataSnapshot.getChildrenCount();
                txtNo.setText(String.valueOf(count));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        //Toast.makeText(getApplicationContext(),String.valueOf(weblimit),Toast.LENGTH_LONG).show();

        pre_list=new ArrayList<>();


        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reference.addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        for (DataSnapshot preSort:dataSnapshot.getChildren()){
                            Apply apply=preSort.getValue(Apply.class);
                            assert apply != null;
                            if (apply.getVerify().equals("Verified")){
                                pre_list.add(apply);
                                vercount++;
                            }
                            txtVer.setText(String.valueOf(vercount));
                        }
                        for (int i=0;i<vercount;i++){
                            for (int j=i+1;j<vercount;j++){
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

                for (int i=0;i<vercount;i++){
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
                    }else if ((ap1.getPhysics().equals("1"))&&(physicslimit>0)){
                        allotement="Environmental Physics";
                        physicslimit--;
                    }else if ((ap1.getPhysical().equals("1"))&&(physicallimit>0)){
                        allotement="Physical Education";
                        physicallimit--;
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
                        }else if ((ap1.getPhysics().equals("2"))&&(physicslimit>0)){
                            allotement="Environmental Physics";
                            physicslimit--;
                        }else if ((ap1.getPhysical().equals("2"))&&(physicallimit>0)){
                            allotement="Physical Education";
                            physicallimit--;
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
                            }else if ((ap1.getPhysics().equals("3"))&&(physicslimit>0)){
                                allotement="Environmental Physics";
                                physicslimit--;
                            }else if ((ap1.getPhysical().equals("3"))&&(physicallimit>0)){
                                allotement="Physical Education";
                                physicallimit--;
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
                                }else if ((ap1.getPhysics().equals("4"))&&(physicslimit>0)){
                                    allotement="Environmental Physics";
                                    physicslimit--;
                                }else if ((ap1.getPhysical().equals("4"))&&(physicallimit>0)){
                                    allotement="Physical Education";
                                    physicallimit--;
                                }else {
                                    if ((ap1.getMathematics().equals("5"))&&(mathslimit>0)){
                                        allotement="Business Mathematics";
                                        mathslimit--;
                                    }else if ((ap1.getWeb().equals("5"))&&(weblimit>0)){
                                        allotement="Web Technology";
                                        weblimit--;
                                    }else if ((ap1.getDisaster().equals("5"))&&(disasterlimit>0)){
                                        allotement="Disaster Management";
                                        disasterlimit--;
                                    }else if ((ap1.getAccounting().equals("5"))&&(accountinglimit>0)){
                                        allotement="Basic Accounting";
                                        accountinglimit--;
                                    }else if ((ap1.getPhysics().equals("5"))&&(physicslimit>0)){
                                        allotement="Environmental Physics";
                                        physicslimit--;
                                    }else if ((ap1.getPhysical().equals("5"))&&(physicallimit>0)){
                                        allotement="Physical Education";
                                        physicallimit--;
                                    }else {
                                        if ((ap1.getMathematics().equals("6"))&&(mathslimit>0)){
                                            allotement="Business Mathematics";
                                            mathslimit--;
                                        }else if ((ap1.getWeb().equals("6"))&&(weblimit>0)){
                                            allotement="Web Technology";
                                            weblimit--;
                                        }else if ((ap1.getDisaster().equals("6"))&&(disasterlimit>0)){
                                            allotement="Disaster Management";
                                            disasterlimit--;
                                        }else if ((ap1.getAccounting().equals("6"))&&(accountinglimit>0)){
                                            allotement="Basic Accounting";
                                            accountinglimit--;
                                        }else if ((ap1.getPhysics().equals("6"))&&(physicslimit>0)){
                                            allotement="Environmental Physics";
                                            physicslimit--;
                                        }else if ((ap1.getPhysical().equals("6"))&&(physicallimit>0)){
                                            allotement="Physical Education";
                                            physicallimit--;
                                        }
                                    }
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

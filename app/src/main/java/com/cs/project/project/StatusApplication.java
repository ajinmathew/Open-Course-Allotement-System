package com.cs.project.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class StatusApplication extends AppCompatActivity {
    TextView txtVer,txtAllot,txtAppli;
    SharedPreferences preferences;
    DatabaseReference reference;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_application);

        txtAllot=(TextView)findViewById(R.id.allotementStatus);
        txtAppli=(TextView)findViewById(R.id.applicationStatus);
        txtVer=(TextView)findViewById(R.id.verificationStatus);

        preferences=getSharedPreferences("USER_DETIALS",MODE_PRIVATE);
        String RegNo=preferences.getString("REGISTERNO",null);
        reference= FirebaseDatabase.getInstance().getReference().child("Allotement").child("Allotement Data").child(RegNo);

        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    txtAppli.setText("Application Submitted");
                    Apply apply=dataSnapshot.getValue(Apply.class);
                    if (apply.getVerify().equals("Not Verify")){
                        txtVer.setText("Not Verified");
                    }else {
                        txtVer.setText("Application Verified");
                    }
                    if (apply.getAllotement().equals("Not Alloted")){
                        txtAllot.setText("Waiting for Allotment");
                    }else{
                        txtVer.setText("");
                        txtAppli.setText("");
                        txtAllot.setText(apply.getAllotement());
                    }
                }else {
                    txtAppli.setText("Applications are not Submitted");
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });



    }
}

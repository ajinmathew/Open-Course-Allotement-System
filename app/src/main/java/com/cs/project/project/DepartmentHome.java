package com.cs.project.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DepartmentHome extends AppCompatActivity {
String dept;

DatabaseReference reference;
RecyclerView recyclerView;
RecyclerView.Adapter adapter;

List<Apply> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_department_home);

        dept=getIntent().getStringExtra("DEPARTMENT");
        Toast.makeText(getApplicationContext(),dept,Toast.LENGTH_LONG).show();

        recyclerView=(RecyclerView)findViewById(R.id.recyclerviewDepartmentHome);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(),1));
        list=new ArrayList<>();

        reference= FirebaseDatabase.getInstance().getReference().child("Allotement").child("Allotement Data");
        reference.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot dataApplication:dataSnapshot.getChildren()){
                    Apply apply=dataApplication.getValue(Apply.class);
                    if (apply.Department.equals(dept)){
                        list.add(apply);
                    }
                }

                adapter=new CustomAdapter(list,getApplicationContext());
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}

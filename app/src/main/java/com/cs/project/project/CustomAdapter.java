package com.cs.project.project;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
    List<Apply> list;
    Context context;

    public CustomAdapter(List<Apply> list, Context applicationContext) {
        this.list=list;
        this.context=applicationContext;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewdepartment,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        final Apply apply=list.get(position);

        holder.txtName.setText(apply.Name);
        holder.txtStatus.setText(apply.Verify);
        holder.txtRegNo.setText(apply.Registerno);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(v.getContext(),DepartmentView.class);
                intent.putExtra("RegNo",apply.Registerno);
                v.getContext().startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txtStatus,txtName,txtRegNo;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName=itemView.findViewById(R.id.usernameCard);
            txtRegNo=itemView.findViewById(R.id.regNoCard);
            txtStatus=itemView.findViewById(R.id.verifyCard);
        }
    }
}

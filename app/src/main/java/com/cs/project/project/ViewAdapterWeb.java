package com.cs.project.project;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class ViewAdapterDisaster extends RecyclerView.Adapter<ViewAdapterDisaster.MyViewHolder> {
    List<Apply> list;
    Context context;
    public ViewAdapterDisaster(List<Apply> list, Context applicationContext) {
        this.context=applicationContext;
        this.list=list;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.cardallomentview,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Apply apply=list.get(position);
        holder.dept.setText(apply.getDepartment());
        holder.regno.setText(apply.getRegisterno());
        holder.name.setText(apply.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView name,dept,regno;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.nameviewcard);
            regno=itemView.findViewById(R.id.regnoviewcard);
            dept=itemView.findViewById(R.id.deptviewcard);
        }
    }
}

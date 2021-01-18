package com.example.milestoneproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    List<Person> personList;
    Context context;

    public RecycleViewAdapter(List<Person> personList, Context context) {
        this.personList = personList;
        this.context = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.one_line_person, parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tv_personName.setText(personList.get(position).getName());
        holder.tv_personNumber.setText(personList.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_personPic;
        TextView tv_personName;
        TextView tv_personNumber;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_personPic = itemView.findViewById(R.id.iv_personPic);
            tv_personName = itemView.findViewById(R.id.tv_personName);
            tv_personNumber = itemView.findViewById(R.id.tv_personNumber);
        }
    }
}

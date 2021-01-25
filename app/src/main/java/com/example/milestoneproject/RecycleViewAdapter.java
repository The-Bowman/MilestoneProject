package com.example.milestoneproject;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RecycleViewAdapter extends RecyclerView.Adapter<RecycleViewAdapter.MyViewHolder> {

    List<PersonContact> personContactList;
    Context context;

    public RecycleViewAdapter(List<PersonContact> personContactList, Context context) {
        this.personContactList = personContactList;
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
        holder.tv_personName.setText(personContactList.get(position).getName());
        holder.tv_personNumber.setText(personContactList.get(position).getPhone());
        Glide.with(this.context).load(personContactList.get(position).getImageURL()).into(holder.iv_personPic);

        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // send the control to the Edit Activity
                Intent intent = new Intent(context, AddEdit.class);
                intent.putExtra("id", personContactList.get(position).getId());
                context.startActivity(intent);
            }
        });



    }

    @Override
    public int getItemCount() {
        return personContactList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_personPic;
        TextView tv_personName;
        TextView tv_personNumber;
        ConstraintLayout parentLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_personPic = itemView.findViewById(R.id.iv_personPic);
            tv_personName = itemView.findViewById(R.id.tv_personName);
            tv_personNumber = itemView.findViewById(R.id.tv_phoneNumber);
            parentLayout = itemView.findViewById(R.id.oneLinePersonLayout);
        }
    }
}

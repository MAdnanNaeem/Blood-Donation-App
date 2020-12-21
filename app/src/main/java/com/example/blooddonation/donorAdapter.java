package com.example.blooddonation;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class donorAdapter extends RecyclerView.Adapter<donorAdapter.ViewHolder>
{
    ArrayList<Person> people;

    ItemSelected activity;

    public interface ItemSelected
    {
        void OnItemClicked(int index);
    }

    public donorAdapter(Context context, ArrayList<Person>list)
    {
        activity = (ItemSelected) context;
           people = list;
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        TextView LName;
        TextView LGroup;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            LName = (TextView) itemView.findViewById(R.id.namev);
            LGroup = (TextView) itemView.findViewById(R.id.groupv);

            itemView.setOnClickListener( v ->
                    activity.OnItemClicked(people.indexOf((Person) itemView.getTag()))
            );

        }


    }

    @NonNull
    @Override
    public donorAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_display,parent,false);


        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull donorAdapter.ViewHolder holder, int position) {



        holder.itemView.setTag(people.get(position));
        holder.LName.setText(people.get(position).getdName());
        holder.LGroup.setText(people.get(position).getdBloodGroup());

    }

    @Override
    public int getItemCount() {
        return people.size();
    }





}

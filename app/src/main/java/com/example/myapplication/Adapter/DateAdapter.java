package com.example.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.FilmActivity;
import com.example.myapplication.R;
import com.example.myapplication.model.Date;
import com.example.myapplication.model.Kinoteatr;


import java.util.List;


public class DateAdapter extends RecyclerView.Adapter<DateAdapter.DateViewHolder> {
    Context context;
    List<Date> dates;

    public DateAdapter(Context context, List<Date> dates) {
        this.context = context;
        this.dates = dates;
    }

    @NonNull
    @Override
    public DateAdapter.DateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View DateItem = LayoutInflater.from(context).inflate(R.layout.date_item, parent,false);
        return new DateAdapter.DateViewHolder(DateItem);
    }

    @Override
    public void onBindViewHolder(@NonNull DateAdapter.DateViewHolder holder, int position) {
        holder.dateName.setText(dates.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return dates.size();
    }


    public static final class DateViewHolder extends RecyclerView.ViewHolder {

        TextView dateName;

        public DateViewHolder(@NonNull View itemView) {
            super(itemView);
            dateName = itemView.findViewById(R.id.dateName);
        }
    }
}

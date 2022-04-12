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
import com.example.myapplication.model.Kinoteatr;


import java.util.List;

public class KinoteatrAdapter extends RecyclerView.Adapter<KinoteatrAdapter.KinoteatrViewHolder> {

    Context context;
    List<Kinoteatr> kinoteatrs;

    public KinoteatrAdapter(Context context, List<Kinoteatr> kinoteatrs) {
        this.context = context;
        this.kinoteatrs = kinoteatrs;
    }

    @NonNull
    @Override
    public KinoteatrAdapter.KinoteatrViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View KinoteatrItem = LayoutInflater.from(context).inflate(R.layout.kinoteatr_item, parent,false);
        return new KinoteatrAdapter.KinoteatrViewHolder(KinoteatrItem);
    }

    @Override
    public void onBindViewHolder(@NonNull KinoteatrAdapter.KinoteatrViewHolder holder, int position) {
        holder.kinoteatrName.setText(kinoteatrs.get(position).getName());
        holder.kinoteatrAdress.setText(kinoteatrs.get(position).getAdress());

    }

    @Override
    public int getItemCount() {
        return kinoteatrs.size();
    }


    public static final class KinoteatrViewHolder extends RecyclerView.ViewHolder {
        TextView kinoteatrName, kinoteatrAdress;



        public KinoteatrViewHolder(@NonNull View itemView) {
            super(itemView);
            kinoteatrName = itemView.findViewById(R.id.kinoteatrName);
            kinoteatrAdress = itemView.findViewById(R.id.kinoteatrAdress);
        }
    }

}

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
import com.example.myapplication.model.Afisha;
import com.example.myapplication.model.Date;
import com.example.myapplication.model.Kinoteatr;


import java.util.List;


public class AfishaAdapter extends RecyclerView.Adapter<AfishaAdapter.AfishaViewHolder> {


    Context context;
    List<Afisha> afishas;

    public AfishaAdapter(Context context, List<Afisha> afishas) {
        this.context = context;
        this.afishas = afishas;
    }

    @NonNull
    @Override
    public AfishaAdapter.AfishaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View AfishaItem = LayoutInflater.from(context).inflate(R.layout.afisha_item, parent,false);
        return new AfishaAdapter.AfishaViewHolder(AfishaItem);
    }

    @Override
    public void onBindViewHolder(@NonNull AfishaAdapter.AfishaViewHolder holder, int position) {

        int imgId = context.getResources().getIdentifier("ic_" + afishas.get(position).getImg(), "drawable", context.getPackageName());
        holder.afishaImg.setImageResource(imgId);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FilmActivity.class);

                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return afishas.size();
    }


    public final static class AfishaViewHolder extends RecyclerView.ViewHolder {

        ImageView afishaImg;

        public AfishaViewHolder(@NonNull View itemView) {
            super(itemView);
            afishaImg = itemView.findViewById(R.id.afishaImg);

        }
    }
}

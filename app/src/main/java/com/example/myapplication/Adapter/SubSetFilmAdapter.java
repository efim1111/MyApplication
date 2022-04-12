package com.example.myapplication.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.FilmActivity;
import com.example.myapplication.R;
import com.example.myapplication.model.SubSetFilm;

import java.util.List;

public class SubSetFilmAdapter extends RecyclerView.Adapter<SubSetFilmAdapter.SubSetFilmViewHolder> {
    Context context;
    List<SubSetFilm> subSetFilmList;

    public SubSetFilmAdapter(Context context, List<SubSetFilm> subSetFilmList) {
        this.context = context;
        this.subSetFilmList = subSetFilmList;
    }

    @NonNull
    @Override
    public SubSetFilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View subSetFilmItem = LayoutInflater.from(context).inflate(R.layout.sub_set_film_item, parent,false);
        return new SubSetFilmAdapter.SubSetFilmViewHolder(subSetFilmItem);
    }

    @Override
    public void onBindViewHolder(@NonNull SubSetFilmViewHolder holder, int position) {
        int imgId = context.getResources().getIdentifier("ic_" + subSetFilmList.get(position).getImg(), "drawable", context.getPackageName());
        holder.subSetFilmImg.setImageResource(imgId);

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
        return subSetFilmList.size();
    }

    public class SubSetFilmViewHolder extends RecyclerView.ViewHolder {
        ImageView subSetFilmImg;


        public SubSetFilmViewHolder(@NonNull View itemView) {
            super(itemView);
            subSetFilmImg = itemView.findViewById(R.id.subSetFilmImg);
        }
    }
}

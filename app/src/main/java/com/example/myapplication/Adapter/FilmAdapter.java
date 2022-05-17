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
import com.example.myapplication.model.Film;

import java.util.List;

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.SubSetFilmViewHolder> {
    Context context;
    List<Film> filmList;

    public FilmAdapter(Context context, List<Film> filmList) {
        this.context = context;
        this.filmList = filmList;
    }

    @NonNull
    @Override
    public SubSetFilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View subSetFilmItem = LayoutInflater.from(context).inflate(R.layout.film_item, parent,false);
        return new FilmAdapter.SubSetFilmViewHolder(subSetFilmItem);
    }

    @Override
    public void onBindViewHolder(@NonNull SubSetFilmViewHolder holder, int position) {
        int imgId = context.getResources().getIdentifier("ic_" + filmList.get(position).getImg(), "drawable", context.getPackageName());
        int imgBd = context.getResources().getIdentifier("ic_" + filmList.get(position).getImgBd(), "drawable", context.getPackageName());
        holder.filmImg.setImageResource(imgId);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, FilmActivity.class);
                intent.putExtra("filmName", filmList.get(position).getName());
                intent.putExtra("filmText", filmList.get(position).getText());
                intent.putExtra("filmImgBd", imgBd);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return filmList.size();
    }

    public class SubSetFilmViewHolder extends RecyclerView.ViewHolder {
        ImageView filmImg;
        ImageView filmImgBd;
        TextView filmName;
        TextView filmText;


        public SubSetFilmViewHolder(@NonNull View itemView) {
            super(itemView);
            filmImg = itemView.findViewById(R.id.subSetFilmImg);
        }
    }
}

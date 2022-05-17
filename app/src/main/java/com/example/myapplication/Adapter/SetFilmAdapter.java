package com.example.myapplication.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.model.SetFilm;
import com.example.myapplication.model.Film;

import java.util.List;

public class SetFilmAdapter extends RecyclerView.Adapter<SetFilmAdapter.SetFilmViewHolder> {

    Context context;
    List<SetFilm> setFilms;

    public SetFilmAdapter(Context context, List<SetFilm> setFilms) {
        this.context = context;
        this.setFilms = setFilms;
    }

    @NonNull
    @Override
    public SetFilmViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View setFilmItem = LayoutInflater.from(context).inflate(R.layout.set_film_item, parent,false);
        return new SetFilmViewHolder(setFilmItem);
    }

    @Override
    public void onBindViewHolder(@NonNull SetFilmViewHolder holder, int position) {
        holder.setFilmTitle.setText(setFilms.get(position).getTitle());
        setSubRecycler(holder.subSetFilmRecycler, setFilms.get(position).getSubSetFilmList());



    }

    @Override
    public int getItemCount() {
        return setFilms.size();
    }

    public static final class SetFilmViewHolder extends RecyclerView.ViewHolder {

        TextView setFilmTitle;
        RecyclerView subSetFilmRecycler;


        public SetFilmViewHolder(@NonNull View itemView) {
            super(itemView);
            setFilmTitle = itemView.findViewById(R.id.setFilmTitle);
            subSetFilmRecycler = itemView.findViewById(R.id.subSetFilmRecycler);

        }
    }

    public void setSubRecycler(RecyclerView subRecycler, List<Film> filmList){
        FilmAdapter filmAdapter = new FilmAdapter(context, filmList);
        subRecycler.setLayoutManager(new LinearLayoutManager(context,RecyclerView.HORIZONTAL,false));
        subRecycler.setAdapter(filmAdapter);
    }

}

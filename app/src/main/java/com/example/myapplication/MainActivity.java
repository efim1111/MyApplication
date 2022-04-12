package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.myapplication.Adapter.SetFilmAdapter;
import com.example.myapplication.model.SetFilm;
import com.example.myapplication.model.SubSetFilm;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView setFilmRecycler;
    SetFilmAdapter setFilmAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<SubSetFilm> subSetFilms = new ArrayList<>();
        subSetFilms.add(new SubSetFilm(1,"forsach"));
        subSetFilms.add(new SubSetFilm(2,"star"));
        subSetFilms.add(new SubSetFilm(3,"bogatir"));
        subSetFilms.add(new SubSetFilm(4,"forsch"));


        List<SetFilm> setFilmList =  new ArrayList<>();
        setFilmList.add(new SetFilm(1, "Специально для вас", subSetFilms));
        setFilmList.add(new SetFilm(2, "Премьеры", subSetFilms));
        setFilmList.add(new SetFilm(3, "Новинки", subSetFilms));
        setFilmList.add(new SetFilm(4, "Премьеры", subSetFilms));

        setSetFilmRecycler(setFilmList);
    }

    private void setSetFilmRecycler(List<SetFilm> setFilmList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        setFilmRecycler = findViewById(R.id.setFilmRecycler);
        setFilmRecycler.setLayoutManager(layoutManager);

        setFilmAdapter = new SetFilmAdapter(this,setFilmList);
        setFilmRecycler.setAdapter(setFilmAdapter);
    }

    public void mainClick(View view)
    {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void mapClick(View view)
    {
        Intent intent = new Intent(this,MapActivity.class);
        startActivity(intent);
    }

    public void ticketClick(View view)
    {
        Intent intent = new Intent(this,TicketActivity.class);
        startActivity(intent);
    }

    public void loginClick(View view)
    {
        Intent intent = new Intent(this,ProfileLoginActivity.class);
        startActivity(intent);
    }

}
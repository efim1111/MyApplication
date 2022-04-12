package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.Adapter.AfishaAdapter;
import com.example.myapplication.Adapter.DateAdapter;
import com.example.myapplication.Adapter.SetFilmAdapter;
import com.example.myapplication.model.Afisha;
import com.example.myapplication.model.Date;
import com.example.myapplication.model.SetFilm;

import java.util.ArrayList;
import java.util.List;

public class KinoteatrActivity extends AppCompatActivity {

    RecyclerView dateRecycler, afishaRecycler;
    DateAdapter dateAdapter;
    AfishaAdapter afishaAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kinoteatr);

        List<Date> dateList =  new ArrayList<>();
        dateList.add(new Date(1, "Сегодня"));
        dateList.add(new Date(2, "Завтра"));
        dateList.add(new Date(3, "17 марта"));
        dateList.add(new Date(4, "18 марта"));

        setDateRecycler(dateList);

        List<Afisha> afishaList =  new ArrayList<>();
        afishaList.add(new Afisha(1, "forsach"));
        afishaList.add(new Afisha(2, "forsach"));
        afishaList.add(new Afisha(3, "forsach"));
        afishaList.add(new Afisha(4, "forsach"));
        afishaList.add(new Afisha(5, "forsach"));


        setAfishaRecycler(afishaList);

    }

    private void setAfishaRecycler(List<Afisha> afishaList) {

        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        afishaRecycler = findViewById(R.id.afishaRecycler);
        afishaRecycler.setLayoutManager(layoutManager1);

        afishaAdapter = new AfishaAdapter(this,afishaList);
        afishaRecycler.setAdapter(afishaAdapter);

    }

    private void setDateRecycler(List<Date> dateList) {

        RecyclerView.LayoutManager layoutManager2 = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        dateRecycler = findViewById(R.id.dateRecycler);
        dateRecycler.setLayoutManager(layoutManager2);

        dateAdapter = new DateAdapter(this,dateList);
        dateRecycler.setAdapter(dateAdapter);

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
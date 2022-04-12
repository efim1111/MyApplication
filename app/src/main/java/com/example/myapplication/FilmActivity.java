package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.Adapter.KinoteatrAdapter;
import com.example.myapplication.model.Kinoteatr;

import java.util.ArrayList;
import java.util.List;

public class FilmActivity extends AppCompatActivity {

    RecyclerView kinoteatrRecycler;
    KinoteatrAdapter kinoteatrAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film);

        List<Kinoteatr> kinoteatrList =  new ArrayList<>();

        kinoteatrList.add(new Kinoteatr(10, "Премьера", "улица Сухарева, д.10"));
        kinoteatrList.add(new Kinoteatr(11, "Ленин", "улица Сухарева, д.7"));
        kinoteatrList.add(new Kinoteatr(12, "РИО", "улица Сухарева, д.7"));
        kinoteatrList.add(new Kinoteatr(13, "Премьера", "улица Сухарева, д.7"));
        kinoteatrList.add(new Kinoteatr(14, "Премьера", "улица Сухарева, д.10"));
        kinoteatrList.add(new Kinoteatr(15, "Ленин", "улица Сухарева, д.7"));
        kinoteatrList.add(new Kinoteatr(16, "РИО", "улица Сухарева, д.7"));
        kinoteatrList.add(new Kinoteatr(17, "Премьера", "улица Сухарева, д.7"));

        setKinoteatrFilmRecycler(kinoteatrList);

    }

    private void setKinoteatrFilmRecycler(List<Kinoteatr> kinoteatrList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        kinoteatrRecycler = findViewById(R.id.kinoteatrRecycler);
        kinoteatrRecycler.setLayoutManager(layoutManager);

        kinoteatrAdapter = new KinoteatrAdapter(this,kinoteatrList);
        kinoteatrRecycler.setAdapter(kinoteatrAdapter);
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
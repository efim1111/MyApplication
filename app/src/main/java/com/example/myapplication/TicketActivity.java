package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.myapplication.Adapter.SetFilmAdapter;
import com.example.myapplication.Adapter.TicketAdapter;
import com.example.myapplication.model.SetFilm;
import com.example.myapplication.model.Ticket;

import java.util.ArrayList;
import java.util.List;

public class TicketActivity extends AppCompatActivity {
    RecyclerView ticketRecycler;
    TicketAdapter ticketAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ticket);

        List<Ticket> ticketList =  new ArrayList<>();
        ticketList.add(new Ticket(1, "13 марта, пятница, 23:00", "Форсаж 9", "Юпитер", "dopfors"));
        ticketList.add(new Ticket(2, "14 марта, пятница, 23:00", "Форсаж 10", "Юпитерc", "dopfors"));
        ticketList.add(new Ticket(3, "15 марта, пятница, 23:00", "Форсаж 9", "Юпитер", "dopfors"));
        ticketList.add(new Ticket(4, "16 марта, пятница, 23:00", "Форсаж 9", "Юпитер", "dopfors"));

        setTicketRecycler(ticketList);


    }

    private void setTicketRecycler(List<Ticket> ticketList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.HORIZONTAL, false);

        ticketRecycler = findViewById(R.id.ticketRecycler);
        ticketRecycler.setLayoutManager(layoutManager);

        ticketAdapter = new TicketAdapter(this, ticketList);
        ticketRecycler.setAdapter(ticketAdapter);
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
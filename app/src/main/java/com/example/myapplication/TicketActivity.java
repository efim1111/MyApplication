package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.example.myapplication.Adapter.TicketAdapter;
import com.example.myapplication.model.Ticket;
import com.example.myapplication.mvvm.views.MapActivity;
import com.example.myapplication.mvvm.views.ProfileLoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

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
        ticketList.add(new Ticket(1, "13 марта, пятница, 23:00", "Форсаж 9", "Юпитер", "dopforsach"));
        ticketList.add(new Ticket(2, "14 марта, пятница, 23:00", "Человек паук", "Юпитерc", "doppauk"));
        ticketList.add(new Ticket(3, "15 марта, пятница, 23:00", "Человек паук", "Юпитер", "doppauk"));
        ticketList.add(new Ticket(4, "16 марта, пятница, 23:00", "Форсаж 9", "Юпитер", "dopforsach"));

        setTicketRecycler(ticketList);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.ticket);
        bottomNavigationView.setItemIconTintList(null);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.main:
                        startActivity(new Intent(getApplicationContext(), MainActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.map:
                        startActivity(new Intent(getApplicationContext(), MapActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.ticket:
                        return true;
                    case R.id.profileLogin:
                        startActivity(new Intent(getApplicationContext(), ProfileLoginActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });


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
        Intent intent = new Intent(this, ProfileLoginActivity.class);
        startActivity(intent);
    }

}
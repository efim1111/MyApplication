package com.example.myapplication.mvvm.views;


import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;

import com.example.myapplication.Adapter.KinoteatrAdapter;
import com.example.myapplication.KinoteatrActivity;
import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.TicketActivity;
import com.example.myapplication.model.Kinoteatr;
import com.example.myapplication.mvvm.viewModels.MapViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class MapActivity extends AppCompatActivity {
    MapViewModel mapViewModel;

    FrameLayout frameLayout;

    RecyclerView kinoteatrRecycler;
    KinoteatrAdapter kinoteatrAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);

        List<Kinoteatr> kinoteatrList =  new ArrayList<>();

        kinoteatrList.add(new Kinoteatr(10, "Премьера", "улица Сухарева, д.10"));
        kinoteatrList.add(new Kinoteatr(11, "Ленин", "переулок Дударева, д.7"));
        kinoteatrList.add(new Kinoteatr(12, "РИО", "улица Лесная, д.45"));
        kinoteatrList.add(new Kinoteatr(13, "Премьера", "проспект Ложкина, д.7"));
        kinoteatrList.add(new Kinoteatr(14, "Премьера", "улица Сухарева, д.7"));
        kinoteatrList.add(new Kinoteatr(15, "Премьера", "улица Сухарева, д.7"));
        kinoteatrList.add(new Kinoteatr(16, "Премьера", "улица Сухарева, д.7"));
        kinoteatrList.add(new Kinoteatr(17, "Премьера", "улица Сухарева, д.10"));
        kinoteatrList.add(new Kinoteatr(18, "Ленин", "переулок Дударева, д.7"));
        kinoteatrList.add(new Kinoteatr(19, "РИО", "улица Лесная, д.45"));
        kinoteatrList.add(new Kinoteatr(20, "Премьера", "проспект Ложкина, д.7"));

        setKinoteatrFilmRecycler(kinoteatrList);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.map);
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
                        return true;
                    case R.id.ticket:
                        startActivity(new Intent(getApplicationContext(), TicketActivity.class));
                        overridePendingTransition(0, 0);
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

    private void setKinoteatrFilmRecycler(List<Kinoteatr> kinoteatrList) {
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);

        kinoteatrRecycler = findViewById(R.id.kinoteatrRecycler);
        kinoteatrRecycler.setLayoutManager(layoutManager);

        kinoteatrAdapter = new KinoteatrAdapter(this,kinoteatrList);
        kinoteatrRecycler.setAdapter(kinoteatrAdapter);
    }


    public void kinoteatrClick(View view)
    {
        Intent intent = new Intent(this, KinoteatrActivity.class);
        startActivity(intent);
    }


}



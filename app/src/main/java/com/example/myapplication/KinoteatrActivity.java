package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.myapplication.Adapter.AfishaAdapter;
import com.example.myapplication.Adapter.DateAdapter;
import com.example.myapplication.model.Afisha;
import com.example.myapplication.model.Date;
import com.example.myapplication.model.Film;
import com.example.myapplication.mvvm.views.MapActivity;
import com.example.myapplication.mvvm.views.ProfileLoginActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class KinoteatrActivity extends AppCompatActivity {

    RecyclerView dateRecycler, afishaRecycler;
    DateAdapter dateAdapter;
    static AfishaAdapter afishaAdapter;
    static List<Afisha> afishaList =  new ArrayList<>();
    static List<Afisha> fullAfishaList =  new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kinoteatr);

        TextView kinName = findViewById(R.id.kinName);
        TextView kinAdress = findViewById(R.id.kinAdress);

        kinName.setText(getIntent().getStringExtra("kinName"));
        kinAdress.setText(getIntent().getStringExtra("kinAdress"));

        List<Date> dateList =  new ArrayList<>();
        dateList.add(new Date(1, "Сегодня"));
        dateList.add(new Date(2, "Завтра"));
        dateList.add(new Date(3, "21 мая"));
        dateList.add(new Date(4, "22 мая"));

        setDateRecycler(dateList);


        afishaList.add(new Afisha(1, "forsach", "dopforsach", "Форсаж", "Доминик Торетто ведет спокойную жизнь в глуши вместе с Летти и сыном Брайаном, но опасность всегда где-то рядом. Команде приходится снова собраться, чтобы спасти Мистера Никто после крушения самолёта, на котором перевозили пойманную хакершу Сайфер. На месте аварии команда обнаруживает загадочное устройство и вскоре сталкивается с опасным преступником и самым безбашенным водителем из всех, Доминик Торетто ведет спокойную жизнь в глуши вместе с Летти и сыном Брайаном, но опасность всегда где-то рядом. Команде приходится снова собраться, чтобы спасти Мистера Никто после крушения самолёта, на котором перевозили пойманную хакершу Сайфер. На месте аварии команда обнаруживает загадочное устройство и вскоре сталкивается с опасным преступником и самым безбашенным водителем с кем они имели дело. Ситуация усложняется тем, что этот человек — брат Доминика Джейкоб, которого много лет назад изгнали из семьи.", 1));
        afishaList.add(new Afisha(2, "star", "dopstar", "Звёздные войны", "Звёздные войны ведут спокойную жизнь в глуши вместе с Летти и сыном Брайаном, но опасность всегда где-то рядом. Команде приходится снова собраться, чтобы спасти Мистера Никто после крушения самолёта, на котором перевозили пойманную хакершу Сайфер. На месте аварии команда обнаруживает загадочное устройство и вскоре сталкивается с опасным преступником и самым безбашенным водителем из всех, Доминик Торетто ведет спокойную жизнь в глуши вместе с Летти и сыном Брайаном, но опасность всегда где-то рядом. Команде приходится снова собраться, чтобы спасти Мистера Никто после крушения самолёта, на котором перевозили пойманную хакершу Сайфер. На месте аварии команда обнаруживает загадочное устройство и вскоре сталкивается с опасным преступником и самым безбашенным водителем с кем они имели дело. Ситуация усложняется тем, что этот человек — брат Доминика Джейкоб, которого много лет назад изгнали из семьи.", 1));
        afishaList.add(new Afisha(3, "bogatir", "dopbogatir", "Последний богатырь", "Последний богатырь ведет спокойную жизнь в глуши вместе с Летти и сыном Брайаном, но опасность всегда где-то рядом. Команде приходится снова собраться, чтобы спасти Мистера Никто после крушения самолёта, на котором перевозили пойманную хакершу Сайфер. На месте аварии команда обнаруживает загадочное устройство и вскоре сталкивается с опасным преступником и самым безбашенным водителем из всех, Доминик Торетто ведет спокойную жизнь в глуши вместе с Летти и сыном Брайаном, но опасность всегда где-то рядом. Команде приходится снова собраться, чтобы спасти Мистера Никто после крушения самолёта, на котором перевозили пойманную хакершу Сайфер. На месте аварии команда обнаруживает загадочное устройство и вскоре сталкивается с опасным преступником и самым безбашенным водителем с кем они имели дело. Ситуация усложняется тем, что этот человек — брат Доминика Джейкоб, которого много лет назад изгнали из семьи.", 2));
        afishaList.add(new Afisha(4, "pauk", "doppauk", "Человек-паук", "Человек-паук ведет спокойную жизнь в глуши вместе с Летти и сыном Брайаном, но опасность всегда где-то рядом. Команде приходится снова собраться, чтобы спасти Мистера Никто после крушения самолёта, на котором перевозили пойманную хакершу Сайфер. На месте аварии команда обнаруживает загадочное устройство и вскоре сталкивается с опасным преступником и самым безбашенным водителем из всех, Доминик Торетто ведет спокойную жизнь в глуши вместе с Летти и сыном Брайаном, но опасность всегда где-то рядом. Команде приходится снова собраться, чтобы спасти Мистера Никто после крушения самолёта, на котором перевозили пойманную хакершу Сайфер. На месте аварии команда обнаруживает загадочное устройство и вскоре сталкивается с опасным преступником и самым безбашенным водителем с кем они имели дело. Ситуация усложняется тем, что этот человек — брат Доминика Джейкоб, которого много лет назад изгнали из семьи.", 2));
        afishaList.add(new Afisha(4, "forsach", "doppauk", "Форсаж", "Форсаж ведет спокойную жизнь в глуши вместе с Летти и сыном Брайаном, но опасность всегда где-то рядом. Команде приходится снова собраться, чтобы спасти Мистера Никто после крушения самолёта, на котором перевозили пойманную хакершу Сайфер. На месте аварии команда обнаруживает загадочное устройство и вскоре сталкивается с опасным преступником и самым безбашенным водителем из всех, Доминик Торетто ведет спокойную жизнь в глуши вместе с Летти и сыном Брайаном, но опасность всегда где-то рядом. Команде приходится снова собраться, чтобы спасти Мистера Никто после крушения самолёта, на котором перевозили пойманную хакершу Сайфер. На месте аварии команда обнаруживает загадочное устройство и вскоре сталкивается с опасным преступником и самым безбашенным водителем с кем они имели дело. Ситуация усложняется тем, что этот человек — брат Доминика Джейкоб, которого много лет назад изгнали из семьи.", 1));
        afishaList.add(new Afisha(4, "star", "doppauk", "Звёздные войны", "Звёздные войны ведет спокойную жизнь в глуши вместе с Летти и сыном Брайаном, но опасность всегда где-то рядом. Команде приходится снова собраться, чтобы спасти Мистера Никто после крушения самолёта, на котором перевозили пойманную хакершу Сайфер. На месте аварии команда обнаруживает загадочное устройство и вскоре сталкивается с опасным преступником и самым безбашенным водителем из всех, Доминик Торетто ведет спокойную жизнь в глуши вместе с Летти и сыном Брайаном, но опасность всегда где-то рядом. Команде приходится снова собраться, чтобы спасти Мистера Никто после крушения самолёта, на котором перевозили пойманную хакершу Сайфер. На месте аварии команда обнаруживает загадочное устройство и вскоре сталкивается с опасным преступником и самым безбашенным водителем с кем они имели дело. Ситуация усложняется тем, что этот человек — брат Доминика Джейкоб, которого много лет назад изгнали из семьи.", 3));
        afishaList.add(new Afisha(4, "bogatir", "doppauk", "Последний богатырь", "Последний богатырь ведет спокойную жизнь в глуши вместе с Летти и сыном Брайаном, но опасность всегда где-то рядом. Команде приходится снова собраться, чтобы спасти Мистера Никто после крушения самолёта, на котором перевозили пойманную хакершу Сайфер. На месте аварии команда обнаруживает загадочное устройство и вскоре сталкивается с опасным преступником и самым безбашенным водителем из всех, Доминик Торетто ведет спокойную жизнь в глуши вместе с Летти и сыном Брайаном, но опасность всегда где-то рядом. Команде приходится снова собраться, чтобы спасти Мистера Никто после крушения самолёта, на котором перевозили пойманную хакершу Сайфер. На месте аварии команда обнаруживает загадочное устройство и вскоре сталкивается с опасным преступником и самым безбашенным водителем с кем они имели дело. Ситуация усложняется тем, что этот человек — брат Доминика Джейкоб, которого много лет назад изгнали из семьи.",3));
        afishaList.add(new Afisha(4, "pauk", "doppauk", "Человек-паук", "Человек-паук ведет спокойную жизнь в глуши вместе с Летти и сыном Брайаном, но опасность всегда где-то рядом. Команде приходится снова собраться, чтобы спасти Мистера Никто после крушения самолёта, на котором перевозили пойманную хакершу Сайфер. На месте аварии команда обнаруживает загадочное устройство и вскоре сталкивается с опасным преступником и самым безбашенным водителем из всех, Доминик Торетто ведет спокойную жизнь в глуши вместе с Летти и сыном Брайаном, но опасность всегда где-то рядом. Команде приходится снова собраться, чтобы спасти Мистера Никто после крушения самолёта, на котором перевозили пойманную хакершу Сайфер. На месте аварии команда обнаруживает загадочное устройство и вскоре сталкивается с опасным преступником и самым безбашенным водителем с кем они имели дело. Ситуация усложняется тем, что этот человек — брат Доминика Джейкоб, которого много лет назад изгнали из семьи.", 4));


        fullAfishaList.addAll(afishaList);

        setAfishaRecycler(afishaList);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.main);
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

    public static void showCategoryAfisha(int category) {
        List<Afisha> filterAfisha = new ArrayList<>();

        afishaList.clear();
        afishaList.addAll(fullAfishaList);

        for(Afisha a : afishaList) {
            if (a.getCategory() == category)
                filterAfisha.add(a);
        }

        afishaList.clear();
        afishaList.addAll(filterAfisha);

        afishaAdapter.notifyDataSetChanged();

    }

}
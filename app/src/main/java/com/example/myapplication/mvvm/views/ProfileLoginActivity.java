package com.example.myapplication.mvvm.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.ProfileActivity;
import com.example.myapplication.R;
import com.example.myapplication.TicketActivity;
import com.example.myapplication.mvvm.viewModels.LoginViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileLoginActivity extends AppCompatActivity {

    EditText loginEnter;
    EditText passwordEnter;
    Button authorizeButton;

    LoginViewModel loginVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_login);

        loginEnter = (EditText) findViewById(R.id.etLogin);
        passwordEnter = (EditText) findViewById(R.id.etPassword);
        authorizeButton = (Button) findViewById(R.id.buttonEnter);

        loginVM = new ViewModelProvider(this).get(LoginViewModel.class);

        loginVM.getLogin().observe(this, login -> {
            loginEnter.setText(login);
        });

        loginVM.getPassword().observe(this, password -> {
            passwordEnter.setText(password);
        });

        loginVM.getAccess().observe(this, access -> {
            if (access) {

                Intent intent = new Intent(this, ProfileActivity.class);
                intent.putExtra("nameProfile", loginVM.getUserNickname());
                intent.putExtra("loginProfile", loginVM.getUserLogin());
                startActivity(intent);

                Toast.makeText(this, "Приветствуем вас, " + loginVM.getUserNickname() + '!', Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Пользователь не найден :(", Toast.LENGTH_LONG).show();
            }
        });

        authorizeButton.setOnClickListener(view -> {
            String login = loginEnter.getText().toString();
            String password = passwordEnter.getText().toString();
            loginVM.authorize(login, password);
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.profileLogin);
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
                        return true;
                }
                return false;
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        loginEnter.setText("");
        passwordEnter.setText("");
    }

    public void profileClick(View view)
    {
        Intent intent = new Intent(this, ProfileRegisterActivity.class);
        startActivity(intent);
    }
}
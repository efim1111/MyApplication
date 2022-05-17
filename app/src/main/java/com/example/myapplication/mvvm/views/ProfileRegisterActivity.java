package com.example.myapplication.mvvm.views;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.ProfileActivity;
import com.example.myapplication.R;
import com.example.myapplication.TicketActivity;
import com.example.myapplication.mvvm.viewModels.CreateViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileRegisterActivity extends AppCompatActivity {

    EditText registerName;
    EditText registerLogin;
    EditText registerPassword;
    Button createAccountButton;

    CreateViewModel createVM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_register);

        registerName = (EditText) findViewById(R.id.registerName);
        registerLogin = (EditText) findViewById(R.id.registerLogin);
        registerPassword = (EditText) findViewById(R.id.registerPassword);
        createAccountButton = (Button) findViewById(R.id.buttonCreateAccount);

        createVM = new ViewModelProvider(this).get(CreateViewModel.class);

        createVM.getName().observe(this, name -> {
            registerName.setText(name);
        });

        createVM.getLogin().observe(this, login -> {
            registerLogin.setText(login);
        });

        createVM.getPassword().observe(this, password -> {
            registerPassword.setText(password);
        });

        createVM.getHaveAccount().observe(this, haveAccount -> {
            if (!haveAccount) {
                Intent intent = new Intent(this, ProfileActivity.class);
                intent.putExtra("nameProfile", createVM.getNewCreateUserNickname());
                intent.putExtra("loginProfile", createVM.getNewCreateUserLogin());
                startActivity(intent);

                Toast.makeText(this, "Аккаунт создан", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Введите другие данные, эти заняты :(", Toast.LENGTH_LONG).show();
            }
        });

        createAccountButton.setOnClickListener(view -> {
            String name = registerName.getText().toString();
            String login = registerLogin.getText().toString();
            String password = registerPassword.getText().toString();
            createVM.creationAccount(name, login, password);
        });

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

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

    @Override
    protected void onStop() {
        super.onStop();
        registerName.setText("");
        registerLogin.setText("");
        registerPassword.setText("");
    }


}
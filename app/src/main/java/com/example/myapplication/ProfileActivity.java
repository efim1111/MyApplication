package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
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
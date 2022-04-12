package com.example.myapplication;

import android.content.Intent;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Clicker extends AppCompatActivity {
    public void kinoteatrClick(View view)
    {
        Intent intent = new Intent(this,KinoteatrActivity.class);
        startActivity(intent);
    }
}

package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button button = findViewById(R.id.letsgo);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(getBaseContext(),MainActivity.class);
            intent.putExtra("colorPLayerOne",0);
            intent.putExtra("colorPLayerTwo",1);
        });
    }
}
package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MenuActivity extends AppCompatActivity {

    private Spinner spinnerPlayerOne;
    private Spinner spinnerPlayerTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Button button = findViewById(R.id.letsgo);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(getBaseContext(),MainActivity.class);
            intent.putExtra("colorPLayerOne",0);
            intent.putExtra("colorPLayerTwo",1);
            startActivity(intent);
        });


        //todo get colors name list form string.xml
        String[] colorNames = {"red","blue","redred","yyy","u","redred","yyy","u"};



        spinnerPlayerOne=findViewById(R.id.spinnerPLayerOne);
        CustomAdapter customAdapter =  new CustomAdapter(this,R.layout.spinner_item,colorNames);
        spinnerPlayerOne.setAdapter(customAdapter);
        spinnerPlayerOne.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MenuActivity.this, colorNames[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MenuActivity.this, "fuck you", Toast.LENGTH_SHORT).show();
            }
        });

        spinnerPlayerTwo=findViewById(R.id.spinnerPlayerTwo);
        CustomAdapter customAdapter1 =  new CustomAdapter(this,R.layout.spinner_item,colorNames);
        spinnerPlayerTwo.setAdapter(customAdapter1);
        spinnerPlayerTwo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MenuActivity.this, colorNames[i], Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                Toast.makeText(MenuActivity.this, "fuck you", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
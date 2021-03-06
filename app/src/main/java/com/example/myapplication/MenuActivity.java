package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;

public class MenuActivity extends AppCompatActivity {

    private Spinner spinnerPlayerOne;
    private Spinner spinnerPlayerTwo;
    private int selectionOne;
    private int selectionTwo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ArrayList<String> list = new ArrayList<>();
        Field[] fields = R.string.class.getFields();
        for (Field field : fields) {
            if (field.getName().contains("__"))
                list.add(field.getName());
        }


        String[] colorNames = Arrays.copyOf(list.toArray(), list.size(), String[].class);
        spinnerPlayerOne = findViewById(R.id.spinnerPLayerOne);
        CustomAdapter customAdapter = new CustomAdapter(this, R.layout.spinner_item, colorNames);
        spinnerPlayerOne.setAdapter(customAdapter);
        spinnerPlayerOne.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectionOne = i + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        spinnerPlayerTwo = findViewById(R.id.spinnerPlayerTwo);
        CustomAdapter customAdapter1 = new CustomAdapter(this, R.layout.spinner_item, colorNames);
        spinnerPlayerTwo.setAdapter(customAdapter1);
        spinnerPlayerTwo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                selectionTwo = i + 1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        Button button = findViewById(R.id.letsgo);
        button.setOnClickListener(view -> {
            if (selectionOne!=selectionTwo) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                intent.putExtra("colorPlayerOne", selectionOne);
                intent.putExtra("colorPlayerTwo", selectionTwo);
                startActivity(intent);
            }else {
                Toast.makeText(this, "PLZ Choose different colors", Toast.LENGTH_SHORT).show();
            }});

    }
}
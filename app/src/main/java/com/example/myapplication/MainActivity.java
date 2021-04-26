package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.playPlace.Table;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Table table = new Table();
    int currentPlayer =1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public  void setTaw(View v){
        setInArray(v);



    }
    public void setInArray( View v){

        Button b = (Button)v;
        int cum = Integer.parseInt((String) b.getText());





        if (!table.isEmp(0,cum)){
            v.setEnabled(false);
        }else {
            for (int i = 0 ; i<7; i++){
                if (i==6){
                    table.setIn(i,cum,currentPlayer);
                }else if (!table.isEmp(i+1,cum)){
                    table.setIn(i,cum,currentPlayer);
                    TextView finalTextView = (TextView)findViewById(R.id.textView);
                    finalTextView.setText(String.valueOf(currentPlayer));

                }
            }


            if (currentPlayer == 1) {
                currentPlayer = 2;
            } else
                currentPlayer = 1;
        }




    }


}
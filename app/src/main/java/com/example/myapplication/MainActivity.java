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
    int ij = 71;



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
            for (int i = 6 ; i>=0; i--){

                if(i==6&&table.isEmp(i,cum)){
                    ij= i*10 + cum;
                    changeColor(ij , currentPlayer);
                    table.setIn(i,cum,currentPlayer);
                    i=-1;
                }
                else if (i==0){
                    table.setIn(i,cum,currentPlayer);
                    ij = i*10 + cum;
                    changeColor(ij, currentPlayer);
                }else if(i<6)
                    if (!table.isEmp(i+1,cum)){
                    table.setIn(i,cum,currentPlayer);
                    ij = i*10 + cum;
                    changeColor(ij, currentPlayer);
                    i=-1;

                }
            }


            if (currentPlayer == 1) {
                currentPlayer = 2;
            } else
                currentPlayer = 1;
        }





    }

    public void changeColor( int id , int currentPlayer){


        if (id==00){
            Button b = (Button)findViewById(R.id.btn00);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==01){
            Button b = (Button)findViewById(R.id.btn01);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==02){
            Button b = (Button)findViewById(R.id.btn02);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==03){
            Button b = (Button)findViewById(R.id.btn03);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==04){
            Button b = (Button)findViewById(R.id.btn04);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==05){
            Button b = (Button)findViewById(R.id.btn05);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==06){
            Button b = (Button)findViewById(R.id.btn06);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==10){
            Button b = (Button)findViewById(R.id.btn10);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }

        else if (id==11){
            Button b = (Button)findViewById(R.id.btn11);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==12){
            Button b = (Button)findViewById(R.id.btn12);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==13){
            Button b = (Button)findViewById(R.id.btn13);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==14){
            Button b = (Button)findViewById(R.id.btn14);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==15){
            Button b = (Button)findViewById(R.id.btn15);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==16){
            Button b = (Button)findViewById(R.id.btn16);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==20){
            Button b = (Button)findViewById(R.id.btn20);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }

        else if (id==21){
            Button b = (Button)findViewById(R.id.btn21);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==22){
            Button b = (Button)findViewById(R.id.btn22);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==23){
            Button b = (Button)findViewById(R.id.btn23);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==24){
            Button b = (Button)findViewById(R.id.btn24);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==25){
            Button b = (Button)findViewById(R.id.btn25);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==26){
            Button b = (Button)findViewById(R.id.btn26);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==30){
            Button b = (Button)findViewById(R.id.btn30);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }

        else if (id==31){
            Button b = (Button)findViewById(R.id.btn31);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==32){
            Button b = (Button)findViewById(R.id.btn32);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==33){
            Button b = (Button)findViewById(R.id.btn33);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==34){
            Button b = (Button)findViewById(R.id.btn34);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==35){
            Button b = (Button)findViewById(R.id.btn35);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==36){
            Button b = (Button)findViewById(R.id.btn36);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==40){
            Button b = (Button)findViewById(R.id.btn40);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }

        else if (id==41){
            Button b = (Button)findViewById(R.id.btn41);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==42){
            Button b = (Button)findViewById(R.id.btn42);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==43){
            Button b = (Button)findViewById(R.id.btn43);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==44){
            Button b = (Button)findViewById(R.id.btn44);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==45){
            Button b = (Button)findViewById(R.id.btn45);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==46){
            Button b = (Button)findViewById(R.id.btn46);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==50){
            Button b = (Button)findViewById(R.id.btn50);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }

        else if (id==51){
            Button b = (Button)findViewById(R.id.btn51);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==52){
            Button b = (Button)findViewById(R.id.btn52);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==53){
            Button b = (Button)findViewById(R.id.btn53);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==54){
            Button b = (Button)findViewById(R.id.btn54);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==55){
            Button b = (Button)findViewById(R.id.btn55);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==56){
            Button b = (Button)findViewById(R.id.btn56);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==60){
            Button b = (Button)findViewById(R.id.btn60);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }

        else if (id==61){
            Button b = (Button)findViewById(R.id.btn61);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==62){
            Button b = (Button)findViewById(R.id.btn62);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==63){
            Button b = (Button)findViewById(R.id.btn63);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==64){
            Button b = (Button)findViewById(R.id.btn64);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==65){
            Button b = (Button)findViewById(R.id.btn65);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }
        else if (id==66){
            Button b = (Button)findViewById(R.id.btn66);
            if (currentPlayer==1) {
                b.setBackgroundColor(Color.BLUE);
            }else{
                b.setBackgroundColor(Color.RED);
            }
        }

    }



}
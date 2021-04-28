package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myapplication.playPlace.Table;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Table table = new Table(); //زمین بازی
    int currentPlayer =1;//نفر در حال بازی
    int ij = 71;//id خانه



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //متد onClick
    public  void setTaw(View v){//متد on click
        setInArray(v);
    }

    //متد جایگذاری در زمین بازی
    public void setInArray( View v){//متد جایگذاری در آرایه

        Button b = (Button)v;
        int cum = Integer.parseInt((String) b.getText());


        if (!table.isEmp(0,cum)){
            v.setEnabled(false);
        }else {
            for (int i = 6 ; i>=0; i--){

                if(i==6&&table.isEmp(i,cum)){
                    ij= i*10 + cum;

                    table.setIn(i,cum,currentPlayer);
                    changeColor(ij , currentPlayer);
                    checkGoal(i,cum);

                    i=-1;
                }
                else if (i==0){
                    ij = i*10 + cum;

                    table.setIn(i,cum,currentPlayer);
                    changeColor(ij, currentPlayer);
                    checkGoal(i,cum);

                }else if(i<6)
                    if (!table.isEmp(i+1,cum)&&table.isEmp(i,cum)){
                        ij = i*10 + cum;

                        table.setIn(i,cum,currentPlayer);
                        changeColor(ij, currentPlayer);
                        checkGoal(i,cum);

                    i=-1;

                }
            }


            if (currentPlayer == 1) {
                currentPlayer = 2;
            } else
                currentPlayer = 1;
        }





    }

    //متد چک کردن رسیدن به هدف
    public void checkGoal(int i , int j){
        checkGoalUpright(i , j);
        checkGoalStraight(i , j);
        checkGoalRising(i,j);
        checkGoalFalling(i,j);
    }

    //رسیدن به هدف عمودی
    public void checkGoalUpright(int i , int j){// جستجو رو عمودی
        int flag = table.getCurrentInt(i , j);// مقدار آخرین خانه مقدار دهی شده
        int some = 1; // تعداد خانه های پشت سر هم با یک مقدار
        if (i<6) {
            for (int k = i; flag == table.getCurrentInt(i + 1, j); k++) {// جستجوی رو به پایین

                if (flag == table.getCurrentInt(k + 1, j)) {
                    some++;
                }else {
                    break;
                }
                if (k == 5) {
                    break;
                }

            }
            if (some == 4) {
                TextView textView = (TextView) findViewById(R.id.goalText);
                textView.setText("goal");
                //ToDo set colors and set buttons
            }

        }

    }

    //رسیدن به هدف افقی
    public void checkGoalStraight(int i , int j){
        int flag = table.getCurrentInt(i , j);// مقدار آخرین خانه مقدار دهی شده
        int some = 1; // تعداد خانه های پشت سر هم با یک مقدار

        if (j>=0&&j<6) {//جستجو به راست
            for (int k = j; flag == table.getCurrentInt(i, j +1); k++) {
                if (flag==table.getCurrentInt(i,k+1)){

                    some++;
                }else {
                    break;
                }
                if (k==5){
                    break;
                }
            }
        }
        if (j<=6&&j>0){//جستجو به چپ
            for (int k = j; flag == table.getCurrentInt(i, j -1); k--) {
                if (flag==table.getCurrentInt(i,k-1)){

                    some++;
                }else {
                    break;
                }
                if (k==1){
                    break;
                }
            }

        }
        if (some == 4) {
            TextView textView = (TextView) findViewById(R.id.goalText);
            textView.setText("goal");
            //ToDo set colors and set buttons
        }

    }

    //رسیدن به هدف صعودی
    public void checkGoalRising(int i , int j){
        int flag = table.getCurrentInt(i , j);// مقدار آخرین خانه مقدار دهی شده
        int some = 1; // تعداد خانه های پشت سر هم با یک مقدار

        if (j>=0&& j<6 && i<=6&& i>0){//صعودی رو به بالا
            for (int k = i , c = j ; flag==table.getCurrentInt(i-1,j+1); k --,c++){
                if (flag==table.getCurrentInt(k-1,c+1)){
                    some++;
                }else {
                    break;
                }if (some==4){
                    break;
                }
                if (k==1){
                    break;
                }
                if (c==5){
                    break;
                }
            }
        }

        if (j<=6 && j>0 && i>=0 && i<6){//صعودی رو به پایین
            for (int k = i , c = j ; flag==table.getCurrentInt(i+1,j-1); k ++,c--){
                if (flag==table.getCurrentInt(k+1,c-1)){
                    some++;
                }else {
                    break;
                }if (some==4){
                    break;
                }if (k==5){
                    break;
                }if (c==1){
                    break;
                }
            }
        }

        if (some == 4) {
            TextView textView = (TextView) findViewById(R.id.goalText);
            textView.setText("goal");
            //ToDo set colors and set buttons
        }



    }

    //رسیدن به هدف نزولی
    public void checkGoalFalling(int i , int j){
        int flag = table.getCurrentInt(i , j);// مقدار آخرین خانه مقدار دهی شده
        int some = 1; // تعداد خانه های پشت سر هم با یک مقدار

        if (j>0&& j<=6 && i<=6&& i>0){//نزولی رو به بالا
            for (int k = i , c = j ; flag==table.getCurrentInt(i-1,j-1); k --,c--){
                if (flag==table.getCurrentInt(k-1,c-1)){
                    some++;
                }else {
                    break;
                }if (some==4){
                    break;
                }
                if (k==1){
                    break;
                }
                if (c==1){
                    break;
                }
            }
        }
        if (j>=0&& j<6 && i<6&& i>=0){//نزولی رو به پایین
            for (int k = i , c = j ; flag==table.getCurrentInt(i+1,j+1); k ++,c++){
                if (flag==table.getCurrentInt(k+1,c+1)){
                    some++;
                }else {
                    break;
                }if (some==4){
                    break;
                }
                if (k==5){
                    break;
                }
                if (c==5){
                    break;
                }
            }
        }
        if (some == 4) {
            TextView textView = (TextView) findViewById(R.id.goalText);
            textView.setText("goal");
            //ToDo set colors and set buttons
        }


    }

    //متد تعویض رنگ
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
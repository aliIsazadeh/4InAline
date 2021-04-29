package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import com.example.myapplication.playPlace.Table;


public class MainActivity extends AppCompatActivity {
    Table table = new Table(); //زمین بازی
    int  currentPlayer = 0;//نفر در حال بازی
    int ij = 71;//id خانه


    int colorPLayerOne = 0;
    int colorPLayerTwo = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        colorPLayerOne = getIntent().getIntExtra("colorPlayerOne", 0);
        colorPLayerTwo = getIntent().getIntExtra("colorPlayerTwo", 1);
        currentPlayer =colorPLayerOne;
    }

    //متد onClick
    public void setTaw(View v) {//متد on click
        setInArray(v);
    }

    //متد جایگذاری در زمین بازی
    public void setInArray(View v) {//متد جایگذاری در آرایه

        Button b = (Button) v;
        int cum = Integer.parseInt((String) b.getText());


        if (!table.isEmp(0, cum)) {
            v.setEnabled(false);
        } else {
            for (int i = 6; i >= 0; i--) {

                if (i == 6 && table.isEmp(i, cum)) {
                    ij = i * 10 + cum;

                    table.setIn(i, cum, currentPlayer);
                    changeColor(ij, currentPlayer);
                    checkGoal(i, cum,currentPlayer);

                    i = -1;
                } else if (i == 0) {
                    ij = i * 10 + cum;

                    table.setIn(i, cum, currentPlayer);
                    changeColor(ij, currentPlayer);
                    checkGoal(i, cum,currentPlayer);

                } else if (i < 6)
                    if (!table.isEmp(i + 1, cum) && table.isEmp(i, cum)) {
                        ij = i * 10 + cum;

                        table.setIn(i, cum, currentPlayer);
                        changeColor(ij, currentPlayer);
                        checkGoal(i, cum,currentPlayer);

                        i = -1;

                    }
            }


            if (currentPlayer == colorPLayerOne) {
                currentPlayer = colorPLayerTwo;
            } else
                currentPlayer = colorPLayerOne;
        }


    }

    //متد چک کردن رسیدن به هدف
    public void checkGoal(int i, int j, int currentPlayer) {
        checkGoalUpright(i, j ,currentPlayer);
        checkGoalStraight(i, j,currentPlayer);
        checkGoalRising(i, j,currentPlayer);
        checkGoalFalling(i, j,currentPlayer);
    }

    //رسیدن به هدف عمودی
    public void checkGoalUpright(int i, int j , int currentPlayer) {// جستجو رو عمودی
        int flag = table.getCurrentInt(i, j);// مقدار آخرین خانه مقدار دهی شده
        int some = 1; // تعداد خانه های پشت سر هم با یک مقدار
        if (i < 6) {
            for (int k = i; flag == table.getCurrentInt(i + 1, j); k++) {// جستجوی رو به پایین

                if (flag == table.getCurrentInt(k + 1, j)) {
                    some++;
                } else {
                    break;
                }
                if (k == 5) {
                    break;
                }

            }
            if (some == 4) {
                setGoalUpright(i, j,currentPlayer);
            }

        }

    }

    //رسیدن به هدف افقی
    public void checkGoalStraight(int i, int j , int currentPlayer) {
        int flag = table.getCurrentInt(i, j);// مقدار آخرین خانه مقدار دهی شده
        int some = 1; // تعداد خانه های پشت سر هم با یک مقدار

        if (j >= 0 && j < 6) {//جستجو به راست
            for (int k = j; flag == table.getCurrentInt(i, j + 1); k++) {
                if (flag == table.getCurrentInt(i, k + 1)) {

                    some++;
                } else {
                    break;
                }
                if (k == 5) {
                    break;
                }
            }
        }
        if (j <= 6 && j > 0) {//جستجو به چپ
            for (int k = j; flag == table.getCurrentInt(i, j - 1); k--) {
                if (flag == table.getCurrentInt(i, k - 1)) {

                    some++;
                } else {
                    break;
                }
                if (k == 1) {
                    break;
                }
            }

        }
        if (some == 4) {
            setGoalStraight(i, j,currentPlayer);
        }

    }

    //رسیدن به هدف صعودی
    public void checkGoalRising(int i, int j , int currentPlayer) {
        int flag = table.getCurrentInt(i, j);// مقدار آخرین خانه مقدار دهی شده
        int some = 1; // تعداد خانه های پشت سر هم با یک مقدار

        if (j >= 0 && j < 6 && i <= 6 && i > 0) {//صعودی رو به بالا
            for (int k = i, c = j; flag == table.getCurrentInt(i - 1, j + 1); k--, c++) {
                if (flag == table.getCurrentInt(k - 1, c + 1)) {
                    some++;
                } else {
                    break;
                }
                if (some == 4) {
                    break;
                }
                if (k == 1) {
                    break;
                }
                if (c == 5) {
                    break;
                }
            }
        }

        if (j <= 6 && j > 0 && i >= 0 && i < 6) {//صعودی رو به پایین
            for (int k = i, c = j; flag == table.getCurrentInt(i + 1, j - 1); k++, c--) {
                if (flag == table.getCurrentInt(k + 1, c - 1)) {
                    some++;
                } else {
                    break;
                }
                if (some == 4) {
                    break;
                }
                if (k == 5) {
                    break;
                }
                if (c == 1) {
                    break;
                }
            }
        }

        if (some == 4) {
            setGoalRising(i, j,currentPlayer);
        }


    }

    //رسیدن به هدف نزولی
    public void checkGoalFalling(int i, int j , int currentPlayer) {
        int flag = table.getCurrentInt(i, j);// مقدار آخرین خانه مقدار دهی شده
        int some = 1; // تعداد خانه های پشت سر هم با یک مقدار

        if (j > 0 && j <= 6 && i <= 6 && i > 0) {//نزولی رو به بالا
            for (int k = i, c = j; flag == table.getCurrentInt(i - 1, j - 1); k--, c--) {
                if (flag == table.getCurrentInt(k - 1, c - 1)) {
                    some++;
                } else {
                    break;
                }
                if (some == 4) {
                    break;
                }
                if (k == 1) {
                    break;
                }
                if (c == 1) {
                    break;
                }
            }
        }
        if (j >= 0 && j < 6 && i < 6 && i >= 0) {//نزولی رو به پایین
            for (int k = i, c = j; flag == table.getCurrentInt(i + 1, j + 1); k++, c++) {
                if (flag == table.getCurrentInt(k + 1, c + 1)) {
                    some++;
                } else {
                    break;
                }
                if (some == 4) {
                    break;
                }
                if (k == 5) {
                    break;
                }
                if (c == 5) {
                    break;
                }
            }
        }
        if (some == 4) {
            setGoalFalling(i, j ,currentPlayer);
        }


    }

    //برنده شدن عمودی
    public void setGoalUpright(int i, int j , int currentPlayer) {
        int flag = table.getCurrentInt(i, j);// مقدار آخرین خانه مقدار دهی شده
        int some = 1; // تعداد خانه های پشت سر هم با یک مقدار
        changeColorOnGoal(i,j);
        if (i < 6) {
            for (int k = i; flag == table.getCurrentInt(i + 1, j); k++) {// جستجوی رو به پایین

                if (flag == table.getCurrentInt(k + 1, j)) {
                    changeColorOnGoal(k+1, j);
                    some++;
                } else {
                    break;
                }
                if (k == 5) {
                    break;
                }

            }
        }
        disableButtons();
        TextView textView = (TextView) findViewById(R.id.goalText);
        someOneWin(currentPlayer);

    }

    //برنده شدن افقی
    public void setGoalStraight(int i, int j , int currentPlayer) {
        int flag = table.getCurrentInt(i, j);// مقدار آخرین خانه مقدار دهی شده
        int some = 1; // تعداد خانه های پشت سر هم با یک مقدار
        changeColorOnGoal(i,j);
        if (j >= 0 && j < 6) {//جستجو به راست
            for (int k = j; flag == table.getCurrentInt(i, j + 1); k++) {
                if (flag == table.getCurrentInt(i, k + 1)) {
                    some++;
                    changeColorOnGoal(i, k + 1);
                } else {
                    break;
                }
                if (k == 5) {
                    break;
                }
            }
        }
        if (j <= 6 && j > 0) {//جستجو به چپ
            for (int k = j; flag == table.getCurrentInt(i, j - 1); k--) {
                if (flag == table.getCurrentInt(i, k - 1)) {
                    some++;
                    changeColorOnGoal(i, k - 1);
                } else {
                    break;
                }
                if (k == 1) {
                    break;
                }
            }

        }
        disableButtons();
        TextView textView = (TextView) findViewById(R.id.goalText);
        someOneWin(currentPlayer);


    }

    //برنده شدن صعودی
    public void setGoalRising(int i, int j , int currentPlayer) {
        int flag = table.getCurrentInt(i, j);// مقدار آخرین خانه مقدار دهی شده
        int some = 1; // تعداد خانه های پشت سر هم با یک مقدار
        changeColorOnGoal(i, j);
        if (j >= 0 && j < 6 && i <= 6 && i > 0) {//صعودی رو به بالا
            for (int k = i, c = j; flag == table.getCurrentInt(i - 1, j + 1); k--, c++) {
                if (flag == table.getCurrentInt(k - 1, c + 1)) {
                    some++;
                    changeColorOnGoal(k - 1, c + 1);
                } else {
                    break;
                }
                if (some == 4) {
                    break;
                }
                if (k == 1) {
                    break;
                }
                if (c == 5) {
                    break;
                }
            }
        }

        if (j <= 6 && j > 0 && i >= 0 && i < 6) {//صعودی رو به پایین
            for (int k = i, c = j; flag == table.getCurrentInt(i + 1, j - 1); k++, c--) {
                if (flag == table.getCurrentInt(k + 1, c - 1)) {
                    some++;
                    changeColorOnGoal(k + 1, c - 1);
                } else {
                    break;
                }
                if (some == 4) {
                    break;
                }
                if (k == 5) {
                    break;
                }
                if (c == 1) {
                    break;
                }
            }
        }
        disableButtons();
        TextView textView = (TextView) findViewById(R.id.goalText);
        someOneWin(currentPlayer);


    }

    //برنده شدن نزولی
    public void setGoalFalling(int i, int j, int currentPlayer) {
        int flag = table.getCurrentInt(i, j);// مقدار آخرین خانه مقدار دهی شده
        int some = 1; // تعداد خانه های پشت سر هم با یک مقدار
        changeColorOnGoal(i,j);
        if (j > 0 && j <= 6 && i <= 6 && i > 0) {//نزولی رو به بالا
            for (int k = i, c = j; flag == table.getCurrentInt(i - 1, j - 1); k--, c--) {
                if (flag == table.getCurrentInt(k - 1, c - 1)) {
                    some++;
                    changeColor(k - 1, c - 1);
                } else {
                    break;
                }
                if (some == 4) {
                    break;
                }
                if (k == 1) {
                    break;
                }
                if (c == 1) {
                    break;
                }
            }
        }
        if (j >= 0 && j < 6 && i < 6 && i >= 0) {//نزولی رو به پایین
            for (int k = i, c = j; flag == table.getCurrentInt(i + 1, j + 1); k++, c++) {
                if (flag == table.getCurrentInt(k + 1, c + 1)) {
                    some++;
                    changeColor(k + 1, c + 1);
                } else {
                    break;
                }
                if (some == 4) {
                    break;
                }
                if (k == 5) {
                    break;
                }
                if (c == 5) {
                    break;
                }
            }
        }
        if (some == 4) {
            disableButtons();
            TextView textView = (TextView) findViewById(R.id.goalText);
            someOneWin(currentPlayer);
        }
    }

    //متد تعویض رنگ
    public void changeColor(int id, int currentPlayer) {

        if (id == 0) {
            Button b = (Button) findViewById(R.id.btn00);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 1) {
            Button b = (Button) findViewById(R.id.btn01);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 2) {
            Button b = (Button) findViewById(R.id.btn02);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 3) {
            Button b = (Button) findViewById(R.id.btn03);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 4) {
            Button b = (Button) findViewById(R.id.btn04);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 5) {
            Button b = (Button) findViewById(R.id.btn05);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 6) {
            Button b = (Button) findViewById(R.id.btn06);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 10) {
            Button b = (Button) findViewById(R.id.btn10);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 11) {
            Button b = (Button) findViewById(R.id.btn11);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 12) {
            Button b = (Button) findViewById(R.id.btn12);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 13) {
            Button b = (Button) findViewById(R.id.btn12);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 14) {
            Button b = (Button) findViewById(R.id.btn14);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 15) {
            Button b = (Button) findViewById(R.id.btn15);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 16) {
            Button b = (Button) findViewById(R.id.btn16);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 20) {
            Button b = (Button) findViewById(R.id.btn20);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 21) {
            Button b = (Button) findViewById(R.id.btn21);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 22) {
            Button b = (Button) findViewById(R.id.btn22);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 23) {
            Button b = (Button) findViewById(R.id.btn23);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 24) {
            Button b = (Button) findViewById(R.id.btn24);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 25) {
            Button b = (Button) findViewById(R.id.btn25);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 26) {
            Button b = (Button) findViewById(R.id.btn26);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 30) {
            Button b = (Button) findViewById(R.id.btn30);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 31) {
            Button b = (Button) findViewById(R.id.btn31);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 32) {
            Button b = (Button) findViewById(R.id.btn32);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 33) {
            Button b =  findViewById(R.id.btn33);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 34) {
            Button b =  findViewById(R.id.btn34);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 35) {
            Button b =  findViewById(R.id.btn35);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 36) {
            Button b =  findViewById(R.id.btn36);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 40) {
            Button b =  findViewById(R.id.btn40);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 41) {
            Button b =  findViewById(R.id.btn41);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 42) {
            Button b =  findViewById(R.id.btn42);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 43) {
            Button b =  findViewById(R.id.btn43);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 44) {
            Button b =  findViewById(R.id.btn44);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 45) {
            Button b =  findViewById(R.id.btn45);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 46) {
            Button b =  findViewById(R.id.btn46);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 50) {
            Button b =  findViewById(R.id.btn50);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 51) {
            Button b =  findViewById(R.id.btn51);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 52) {
            Button b =  findViewById(R.id.btn52);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 53) {
            Button b =  findViewById(R.id.btn53);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 54) {
            Button b =  findViewById(R.id.btn54);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 55) {
            Button b =  findViewById(R.id.btn55);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 56) {
            Button b =  findViewById(R.id.btn56);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 60) {
            Button b =  findViewById(R.id.btn60);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 61) {
            Button b =  findViewById(R.id.btn61);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 62) {
            Button b =  findViewById(R.id.btn62);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 63) {
            Button b =  findViewById(R.id.btn63);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 64) {
            Button b =  findViewById(R.id.btn64);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 65) {
            Button b =  findViewById(R.id.btn65);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        } else if (id == 66) {
            Button b =  findViewById(R.id.btn66);
            b.setBackgroundColor(getResources().getColor(getResources().getIdentifier("color_" + currentPlayer, "color", getPackageName())));
        }
    }

    //تعویض رنگ خانه های برنده شده
    public void changeColorOnGoal(int i, int j) {
        int id = i * 10 + j;


        if (id == 0) {
            Button b = (Button) findViewById(R.id.btn00);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 1) {
            Button b = (Button) findViewById(R.id.btn01);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 2) {
            Button b = (Button) findViewById(R.id.btn02);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 3) {
            Button b = (Button) findViewById(R.id.btn03);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 4) {
            Button b = (Button) findViewById(R.id.btn04);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 5) {
            Button b = (Button) findViewById(R.id.btn05);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 6) {
            Button b = (Button) findViewById(R.id.btn06);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 10) {
            Button b = (Button) findViewById(R.id.btn10);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 11) {
            Button b = (Button) findViewById(R.id.btn11);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 12) {
            Button b = (Button) findViewById(R.id.btn12);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 13) {
            Button b = (Button) findViewById(R.id.btn13);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 14) {
            Button b = (Button) findViewById(R.id.btn14);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 15) {
            Button b = (Button) findViewById(R.id.btn15);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 16) {
            Button b = (Button) findViewById(R.id.btn16);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 20) {
            Button b = (Button) findViewById(R.id.btn20);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 21) {
            Button b = (Button) findViewById(R.id.btn21);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 22) {
            Button b = (Button) findViewById(R.id.btn22);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 23) {
            Button b = (Button) findViewById(R.id.btn23);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 24) {
            Button b = (Button) findViewById(R.id.btn24);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 25) {
            Button b = (Button) findViewById(R.id.btn25);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 26) {
            Button b = (Button) findViewById(R.id.btn26);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 30) {
            Button b = (Button) findViewById(R.id.btn30);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 31) {
            Button b = (Button) findViewById(R.id.btn31);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 32) {
            Button b = (Button) findViewById(R.id.btn32);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 33) {
            Button b = (Button) findViewById(R.id.btn33);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 34) {
            Button b = (Button) findViewById(R.id.btn34);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 35) {
            Button b = (Button) findViewById(R.id.btn35);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 36) {
            Button b = (Button) findViewById(R.id.btn36);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 40) {
            Button b = (Button) findViewById(R.id.btn40);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 41) {
            Button b = (Button) findViewById(R.id.btn41);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 42) {
            Button b = (Button) findViewById(R.id.btn42);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 43) {
            Button b = (Button) findViewById(R.id.btn43);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 44) {
            Button b = (Button) findViewById(R.id.btn44);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 45) {
            Button b = (Button) findViewById(R.id.btn45);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 46) {
            Button b = (Button) findViewById(R.id.btn46);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 50) {
            Button b = (Button) findViewById(R.id.btn50);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 51) {
            Button b = (Button) findViewById(R.id.btn51);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 52) {
            Button b = (Button) findViewById(R.id.btn52);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 53) {
            Button b = (Button) findViewById(R.id.btn53);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 54) {
            Button b = (Button) findViewById(R.id.btn54);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 55) {
            Button b = (Button) findViewById(R.id.btn55);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 56) {
            Button b = (Button) findViewById(R.id.btn56);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 60) {
            Button b = (Button) findViewById(R.id.btn60);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 61) {
            Button b = (Button) findViewById(R.id.btn61);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 62) {
            Button b = (Button) findViewById(R.id.btn62);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 63) {
            Button b = (Button) findViewById(R.id.btn63);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 64) {
            Button b = (Button) findViewById(R.id.btn64);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 65) {
            Button b = (Button) findViewById(R.id.btn65);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        } else if (id == 66) {
            Button b = (Button) findViewById(R.id.btn66);
            b.setBackgroundColor(Color.parseColor("#7FFF00"));
        }

    }

    //dis able کردن دکمه های اصلی
    public void disableButtons() {
        Button b0 = findViewById(R.id.button0);
        b0.setEnabled(false);
        Button b1 = findViewById(R.id.button1);
        b1.setEnabled(false);
        Button b2 = findViewById(R.id.button2);
        b2.setEnabled(false);
        Button b3 = findViewById(R.id.button3);
        b3.setEnabled(false);
        Button b4 = findViewById(R.id.button4);
        b4.setEnabled(false);
        Button b5 = findViewById(R.id.button5);
        b5.setEnabled(false);
        Button b6 = findViewById(R.id.button6);
        b6.setEnabled(false);
    }


    public void someOneWin(int player) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Do you want to play new game");
        if (player==colorPLayerOne){
            alert.setMessage("player one Win!!");
        }else {
            alert.setMessage("player tow Win!!");
        }

        alert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                //Your action here
            }
        });

        alert.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                });

        alert.show();

    }


}
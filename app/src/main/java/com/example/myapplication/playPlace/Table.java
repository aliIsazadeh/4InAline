package com.example.myapplication.playPlace;

public class Table {

    public int  [][] table = new int[7][7];

    public void setIn(int i , int j , int object){
        table[i][j]=object;
    }

    public int getCurrentInt(int i , int j){
        return table[i][j];
    }

    public boolean isEmp( int i , int j){
        boolean flag = false;
        if (table[i][j]==0){
            flag=true;
        }
        return flag;

    }
}

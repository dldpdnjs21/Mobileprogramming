package com.example.teamproject4;

import android.content.Context;

import androidx.appcompat.widget.AppCompatButton;

public class DButton extends AppCompatButton {
    int x, y;
    boolean dalgona;

    public DButton(Context context, int x, int y, boolean a) { //생성자
        super(context);
        this.x = x;
        this.y = y;
        this.dalgona = a;

        if(dalgona){
            setBackground(getResources().getDrawable(R.drawable.linexml));
        }else{
            setBackground(getResources().getDrawable(R.drawable.dalgonaxml));
        }
         //버튼배경이미지
    }


}
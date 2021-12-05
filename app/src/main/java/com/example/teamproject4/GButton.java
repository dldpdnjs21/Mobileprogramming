package com.example.teamproject4;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;

public class GButton extends AppCompatButton {
    int x, y;
    boolean tempered;

    public GButton(Context context, int x, int y,boolean a) { //생성자
        super(context);
        this.x = x;
        this.y = y;
        this.tempered=a;
        setBackground(getResources().getDrawable(R.drawable.glassxml));
    }
    public boolean GClick() {
        if(!isClickable()){
            return false;
        } // 이미 한번 클릭됐으면 블락 못열음
        setClickable(false);  //한번 열면 클릭 못하게



        return true;
    }
}
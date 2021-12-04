package com.example.teamproject4;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;

public class GButton extends AppCompatButton {
    int x, y;

    public GButton(Context context, int x, int y) { //생성자
        super(context);
        this.x = x;
        this.y = y;
        setBackground(getResources().getDrawable(R.drawable.glassxml));
    }
    /*public boolean GClick() {

    }*/
}
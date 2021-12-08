package com.example.teamproject4;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;

public class GButton extends AppCompatButton {
    int x, y;
    boolean tempered;
    static public int pass=0; //통과했는지 카운트해주는 변수

    public GButton(Context context, int x, int y,boolean a) { //생성자
        super(context);
        this.x = x;
        this.y = y;
        this.tempered=a;
        setBackground(getResources().getDrawable(R.drawable.glassxml));
        /*if(tempered){
            setBackground(getResources().getDrawable(R.drawable.dalgonaxml));
        }else {
            setBackground(getResources().getDrawable(R.drawable.glassxml));
        }*/
    }
    public boolean GClick() {
        if(play2Activity.end){
            for(int i=0;i<10;i++)
                for(int j=0;j<10;j++)
                    play2Activity.buttons[i][j].setClickable(false); // 모든 버튼 클릭 비활성화
            return true; //게임 실패
        }
        if(tempered==false){
            setBackground(getResources().getDrawable(R.drawable.glass2xml));
            for(int i=0;i<5;i++)
                for(int j=0;j<2;j++)
                    play2Activity.buttons[i][j].setClickable(false); // 모든 버튼 클릭 비활성화
            play2Activity.end=true;
        }else{
            setBackground(getResources().getDrawable(R.drawable.linexml));
            pass++;
            if(pass==1){
                play2Activity.buttons[4][0].setClickable(false);
                play2Activity.buttons[4][1].setClickable(false);
                play2Activity.buttons[3][0].setClickable(true);
                play2Activity.buttons[3][1].setClickable(true);
            }
            if(pass==2){
                play2Activity.buttons[3][0].setClickable(false);
                play2Activity.buttons[3][1].setClickable(false);
                play2Activity.buttons[2][0].setClickable(true);
                play2Activity.buttons[2][1].setClickable(true);
            }
            if(pass==3){
                play2Activity.buttons[2][0].setClickable(false);
                play2Activity.buttons[2][1].setClickable(false);
                play2Activity.buttons[1][0].setClickable(true);
                play2Activity.buttons[1][1].setClickable(true);
            }
            if(pass==4){
                play2Activity.buttons[1][0].setClickable(false);
                play2Activity.buttons[1][1].setClickable(false);
                play2Activity.buttons[0][0].setClickable(true);
                play2Activity.buttons[0][1].setClickable(true);
            }
            if(pass==5){
                play2Activity.buttons[0][0].setClickable(false);
                play2Activity.buttons[0][1].setClickable(false);
            }
        }
        if(!isClickable()){
            return false;
        }
        setClickable(false);
        return true;
    }
}
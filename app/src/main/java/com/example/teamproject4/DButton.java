package com.example.teamproject4;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;

public class DButton extends AppCompatButton {
    int x, y;
    boolean dalgona;
    static public int lines=16;

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

    public boolean DClick() {
        if(play1Activity.end){
            for(int i=0;i<9;i++)
                for(int j=0;j<9;j++)
                    play1Activity.buttons[i][j].setClickable(false); // 모든 버튼 클릭 비활성화

            return true; //게임 실패
        }
        if(dalgona==false){ //다른 버튼 눌렀을때
            for(int i=0;i<9;i++)
                for(int j=0;j<9;j++)
                    play1Activity.buttons[i][j].setClickable(false); // 모든 버튼 클릭 비활성화
            play1Activity.end=true;
            return true; //게임 실패
        }else{ //성공
            setBackground(getResources().getDrawable(R.drawable.dalgonaxml));
            lines--;
            if(lines==0){
                for(int i=0;i<9;i++)
                    for(int j=0;j<9;j++)
                        play1Activity.buttons[i][j].setClickable(false);
            }

        }

        if(!isClickable()){
            return false;
        } // 이미 한번 클릭됐으면 블락 못열음
        setClickable(false);  //한번 열면 클릭 못하게



        return true;
    }




}
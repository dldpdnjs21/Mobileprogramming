package com.example.teamproject4;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class play2Activity extends AppCompatActivity {
    static GButton[][] buttons = new GButton[5][2];
    TextView textView;
    int count=0;
    private int mnMilliSecond=1000;
    private int value=30;
    public static boolean end=false;
    CountDownTimer c = new CountDownTimer(30*1000,1000){
        @Override
        public void onTick(long millisUntilFinished){
            value--;
            textView.setText(value+"초");
            if(end)
                textView.setText("게임 종료");
            if(GButton.pass==5)
                textView.setText("게임 성공");
        }
        @Override
        public void onFinish(){
            if(GButton.pass==5){
                textView.setText("게임 성공");
            }else{
                textView.setText("게임 종료");
                end=true;
            }
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.glass_game);
        textView=findViewById(R.id.timer2);
        c.start();
        end=false;
        Button b = (Button) findViewById(R.id.button);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), game2Activity.class);
                startActivity(intent);
                end=false;
                c.cancel();
            }
        });

        int i=0,j=0;
        Boolean bb[][] = new Boolean[5][2];
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 2; j++) {
                bb[i][j] = false;
            }
        }
        Random r = new Random();
        for(i=0;i<5;i++){
            int a = r.nextInt(2);
            bb[i][a] = true; // 유리강화 랜덤 배치
        }
        TableLayout table;
        table = (TableLayout) findViewById(R.id.tableLayout2);
        for (i = 0; i < 5; i++) {
            TableRow tableRow = new TableRow(this);
            table.addView(tableRow);
            for (j = 0; j < 2; j++) {
                count++;
                buttons[i][j] = new GButton(this, i, j,bb[i][j]);
                TableRow.LayoutParams layoutParams =
                        new TableRow.LayoutParams(
                                TableRow.LayoutParams.WRAP_CONTENT,
                                TableRow.LayoutParams.WRAP_CONTENT,
                                1.0f);
                buttons[i][j].setLayoutParams(layoutParams);
                tableRow.addView(buttons[i][j]);
            }
        }
        for(i=0;i<5;i++){ //버튼클릭
            for(j=0;j<2;j++){
                for(int x=0;x<4;x++){
                    for(int y=0;y<2;y++){
                        buttons[x][y].setClickable(false);
                    }}
                buttons[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ((GButton) view).GClick();
                    }
                });
            }
        }
    }
}
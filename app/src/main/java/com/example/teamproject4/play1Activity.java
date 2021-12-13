package com.example.teamproject4;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;


public class play1Activity extends AppCompatActivity {
    public static boolean end=false;
    TextView textView;
    private int mnMilliSecond=1000;
    private int value=30;
    static public int lines;
    static DButton[][] buttons = new DButton[11][11];
  CountDownTimer c = new CountDownTimer(30*1000,1000){
        @Override
        public void onTick(long millisUntilFinished){
            value--;
            textView.setText(value+"초");
            if(end)
                textView.setText("게임 종료");
            if(lines==0)
                textView.setText("게임 성공");
        }
        @Override
        public void onFinish(){
            if(lines==0)
                textView.setText("게임 성공");
            else{
                textView.setText("게임 종료");
                end=true;
            }
        }
    };
    @Override
    protected void onCreate(@Nullable Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.dalgona_game);
        end=false;
        c.start();

        textView=findViewById(R.id.timer);
        Intent intent = getIntent();

        Button b = (Button) findViewById(R.id.backbtn);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), game1Activity.class);
                startActivity(intent);
                end=false;
                c.cancel();
            }
        });
        TableLayout table;
        table = (TableLayout) findViewById(R.id.tableLayout);
        // BlockButton[][] buttons = new BlockButton[9][9];
        int i=0, j=0;
        Boolean bb[][] = new Boolean[11][11];//달고나 선 지정: true일때 선 부분임
        for (i = 0; i < 11; i++) {
            for (j = 0; j < 11; j++) {
                bb[i][j] = false;
            }
        }
        int r=intent.getIntExtra("number",-1);
        if(r==1){ //오징어
            lines=30;
            bb[1][5] =true; bb[2][4] =true; bb[2][6] =true; bb[3][3] =true;
            bb[3][7] =true; bb[4][2] =true;
            bb[4][3] =true; bb[4][4] =true; bb[4][6] =true; bb[4][7] =true;
            bb[4][8] =true; bb[5][3] =true; bb[5][7] =true; bb[6][2] =true;
            bb[6][8] =true; bb[7][1] =true; bb[7][2] =true; bb[7][3] =true;
            bb[7][4] =true; bb[7][5] =true; bb[7][6] =true; bb[7][7] =true;
            bb[7][8] =true; bb[7][9] =true; bb[8][3] =true; bb[8][5] =true;
            bb[8][7] =true; bb[9][3] =true; bb[9][5] =true; bb[9][7] =true;
        }
        if(r==2){
            lines=24;
            bb[1][2] =true; bb[1][3] =true; bb[1][7] =true; bb[1][8] =true;
            bb[2][1] =true; bb[2][4] =true; bb[2][6] =true; bb[2][9] =true;
            bb[3][0] =true; bb[3][5] =true; bb[3][10] =true;
            bb[4][0] =true; bb[4][10] =true;
            bb[5][0] =true; bb[5][10] =true;
            bb[6][1] =true; bb[6][9] =true; bb[7][2] =true; bb[7][8] =true;
            bb[8][3] =true; bb[8][7] =true; bb[9][4] =true; bb[9][6] =true;
            bb[10][5] =true;
        }
        if(r==3){ //네모
            lines=24;
            for(i=2;i<9;i++) {
                bb[i][2] = true;
                bb[i][8]=true;
            }
            for(i=2;i<9;i++){
                bb[2][i]=true;
                bb[8][i]=true;
            }
        }

        for(i=0;i<11;i++){
            TableRow tableRow = new TableRow(this);
            table.addView(tableRow);
            for(j=0;j<11;j++){
                buttons[i][j] = new DButton(this, i, j, bb[i][j]);
                TableRow.LayoutParams layoutParams =
                        new TableRow.LayoutParams(
                                TableRow.LayoutParams.WRAP_CONTENT,
                                TableRow.LayoutParams.WRAP_CONTENT,
                                1.0f);
                buttons[i][j].setLayoutParams(layoutParams);
                tableRow.addView(buttons[i][j]);

                buttons[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ((DButton)view).DClick();
                    }
                });
            }
        }
    }
}



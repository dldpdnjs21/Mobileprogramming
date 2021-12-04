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
    static DButton[][] buttons = new DButton[9][9];
    @Override
    protected void onCreate(@Nullable Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.dalgona_game);

        textView = findViewById(R.id.timer);
        new CountDownTimer(30 * 1000, 1000) { //타이머
            @Override
            public void onTick(long millisUntilFinished) {
                value--;
                textView.setText(value + "초");
                if (end)
                    textView.setText("게임 종료");
                if (DButton.lines == 0)
                    textView.setText("게임 성공");
            }
            @Override
            public void onFinish() {
                if (DButton.lines == 0)
                    textView.setText("게임 성공");
                else {
                    textView.setText("게임 종료");
                    end = true;
                }
            }
        }.start();

        TableLayout table;
        table = (TableLayout) findViewById(R.id.tableLayout);
        // BlockButton[][] buttons = new BlockButton[9][9];
        int i = 0, j = 0;
        Boolean bb[][] = new Boolean[9][9];
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                bb[i][j] = false;
            }
        }
        //달고나 선 지정: true일때 선 부분임 (일단 네모모양으로 함)
        for (i = 2; i < 7; i++) {
            bb[i][2] = true;
            bb[i][6] = true;
        }
        for (i = 2; i < 7; i++) {
            bb[2][i] = true;
            bb[6][i] = true;
        }
        for (i = 0; i < 9; i++) {
            TableRow tableRow = new TableRow(this);
            table.addView(tableRow);
            for (j = 0; j < 9; j++) {
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
                        ((DButton) view).DClick();
                    }
                });
            }
        }
    }
}



package com.example.teamproject4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class play1Activity extends AppCompatActivity {

    static DButton[][] buttons = new DButton[9][9];

    @Override
    protected void onCreate(@Nullable Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.dalgona_game);

        TableLayout table;
        table = (TableLayout) findViewById(R.id.tableLayout);
        // BlockButton[][] buttons = new BlockButton[9][9];
        int i=0, j=0;
        Boolean bb[][] = new Boolean[9][9];
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                bb[i][j] = false;
            }
        }
        //달고나 선 지정: true일때 선 부분임 (일단 네모모양으로 함)
        for(i=2;i<7;i++) {
            bb[i][6] = true;
            bb[i][6]=true;
        }
        for(i=2;i<7;i++){
            bb[2][i]=true;
            bb[6][i]=true;
        }

        for(i=0;i<9;i++){
            TableRow tableRow = new TableRow(this);
            table.addView(tableRow);
            for(j=0;j<9;j++){
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

                       /* if (t.isChecked()) {
                            ((BlockButton) view).toggleFlag();
                            TextView textView = (TextView) findViewById(R.id.textView);
                            textView.setText("Mines:" + String.valueOf(BlockButton.flags));
                        } else {
                            ((BlockButton) view).breakBlock();

                        }*/
                    }
                });
            }
        }

    }
}



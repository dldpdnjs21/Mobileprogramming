package com.example.teamproject4;

import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class play2Activity extends AppCompatActivity {
    static GButton[][] buttons = new GButton[5][2];
    TextView textView;
    int count=0;
    @Override
    protected void onCreate(@Nullable Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.glass_game);
        textView=findViewById(R.id.textView3);
        int i=0,j=0;
        Boolean bb[][] = new Boolean[9][9];
        for (i = 0; i < 9; i++) {
            for (j = 0; j < 9; j++) {
                bb[i][j] = false;
            }
        }
        bb[0][1]=true;
        bb[1][0]=true;
        bb[2][1]=true;
        bb[3][1]=true;
        bb[4][0]=true;
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

                buttons[0][0].setClickable(false);
                if(count==2)
                    buttons[0][1].setClickable(false);
                if(count==3)
                    buttons[1][0].setClickable(false);
                if(count==4)
                    buttons[1][1].setClickable(false);
                if(count==5)
                    buttons[2][0].setClickable(false);
                if(count==6)
                    buttons[2][1].setClickable(false);
                if(count==7)
                    buttons[3][0].setClickable(false);
                if(count==8)
                    buttons[3][1].setClickable(false);


                buttons[i][j].setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        ((GButton) view).GClick();
                        textView.setText(String.valueOf(GButton.pass));
                    }
                });
            }
        }
    }
}
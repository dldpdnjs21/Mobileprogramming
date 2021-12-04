package com.example.teamproject4;

import android.os.Bundle;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class play2Activity extends AppCompatActivity {
    static GButton[][] buttons = new GButton[7][2];

    @Override
    protected void onCreate(@Nullable Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.glass_game);

        int i=0,j=0;
        TableLayout table;
        table = (TableLayout) findViewById(R.id.tableLayout2);
        for (i = 0; i < 7; i++) {
            TableRow tableRow = new TableRow(this);
            table.addView(tableRow);
            for (j = 0; j < 2; j++) {
                buttons[i][j] = new GButton(this, i, j);
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

                    }
                });
            }
        }
    }
}

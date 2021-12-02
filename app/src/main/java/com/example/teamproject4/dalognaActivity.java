package com.example.teamproject4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class dalognaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.dalgona_main);
    }


    public void onClick(View view) {

        switch (view.getId()){
            case R.id.button1:
                setContentView(R.layout.activity_main);
                break;

            case R.id.button2:
                break;
        }
    }
}

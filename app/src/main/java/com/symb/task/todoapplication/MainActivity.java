package com.symb.task.todoapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
private static int SplashTime = 3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intentButtonUi = new Intent(MainActivity.this,ButtonUi.class);
                startActivity(intentButtonUi);
                finish();
            }
        },SplashTime);

    }
}

package com.example.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

public class Splassh extends AppCompatActivity {
    private static int SPLASH_TIME_OUT=1000;
    private ProgressBar mProgress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splassh);
        mProgress=(ProgressBar)findViewById(R.id.progressbar);

        new Thread(new Runnable() {
            @Override
            public void run() {
                doWork();
                startApp();
                finish();
            }
        }).start();
    }

    private void doWork(){
        for (int progress=0; progress<100; progress+=10){
            try {
                Thread.sleep(100);
                mProgress.setProgress(progress);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    private void startApp(){
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        finish();
    }
}
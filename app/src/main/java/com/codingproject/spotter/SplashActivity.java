package com.codingproject.spotter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getSupportActionBar().hide();

        Thread background = new Thread() {
            public void run() {
                try {
                    // sleep
                    sleep(3000);
                    // start login screen
                    Intent i=new Intent(getBaseContext(), MainActivity.class);
                    startActivity(i);
                    finish();
                } catch (Exception e) {
                    Log.i("SplashActivity.java", "Error: Splash screen not working correctly.");
                }
            }
        };

        // start thread
        background.start();

    }
}
package com.example.one;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash); // Connects Java to XML

        // Handler delays the execution of code inside run() by 3000ms (3 seconds)
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {
                // Intent is used to navigate from SplashActivity to LoginActivity
                Intent intent = new Intent(SplashScreen1.this, LoginScreen2.class);
                startActivity(intent);

                // finish() destroys SplashActivity so the user cannot go back to it by pressing Back
                finish();
            }
        }, 3000);
    }
}
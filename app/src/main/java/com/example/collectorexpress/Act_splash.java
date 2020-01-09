package com.example.collectorexpress;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;

import com.example.collectorexpress.Activities.Act_login;

public class Act_splash extends AppCompatActivity {

    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        changeStatusBarColor("#171E26");
        setContentView(R.layout.activity_splash);
    }

    @Override
    protected void onStart() {
        super.onStart();
        startTimer();
    }

    private void startTimer() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(Act_splash.this, Act_login.class);
                startActivity(intent);
//
//                if (sessionParam.login.equals("yes")){
//
////                    if (isMyServiceRunning(SinchServicetest.class) == false) {
////                        Intent intent1 = new Intent(Act_splash.this, SinchServicetest.class);
////                        intent1.putExtra("USER_ID",sessionParam.userId);
////                        startService(intent1);
////
////
////                    }
//
////                    startService(new Intent(Act_splash.this, SinchService.class));
//
//                    if ((getSinchServiceInterface() != null || !getSinchServiceInterface().isStarted())) {
//                        getSinchServiceInterface().startClient(sessionParam.userId);
//                    }
//
//
//                    Intent intent = new Intent(Act_splash.this, Act_home.class);
//                    startActivity(intent);
//                }else {
//                    Intent intent = new Intent(Act_splash.this, Act_Login.class);
//                    startActivity(intent);
//                }


            }

        }, SPLASH_TIME_OUT);

    }
    private void changeStatusBarColor(String color){
        if (Build.VERSION.SDK_INT >= 21) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.parseColor(color));
        }
    }




}

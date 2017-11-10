package com.example.shurik.pdd;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by shurik on 10.11.2017.
 */

public class SplashActivity extends AppCompatActivity{

    Activity activity;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        activity    = this;

        Thread logoThread   = new Thread(){

            public void run(){

                try {

                    int logotime    = 2000;

                    while (logotime > 0){

                        sleep(200);
                        logotime-=200;
                    }
                   // startActivity(new Intent(activity, MainActivity.class));
                    startActivity(new Intent(activity, LoginActivity.class));

                } catch (InterruptedException interrEx){

                    interrEx.printStackTrace();

                }finally {
                    finish();
                }

            }

        };

        logoThread.start();

    }
}

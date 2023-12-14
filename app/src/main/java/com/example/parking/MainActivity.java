package com.example.parking;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        runSplashScreen();
    }
    public void runSplashScreen(){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    FragmentTransaction splashScreenFragment = getSupportFragmentManager().beginTransaction();

                    splashScreenFragment.replace(R.id.fragment_main, new SplashScreenFragment());
                    splashScreenFragment.commit();
                    Thread.sleep(5000);
                    FragmentTransaction onBoardingFragment1 = getSupportFragmentManager().beginTransaction();

                    onBoardingFragment1.replace(R.id.fragment_main, new onBoardingFragment1());
                    onBoardingFragment1.commit();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        thread.start();
    }
}
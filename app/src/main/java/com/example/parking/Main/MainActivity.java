package com.example.parking.Main;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.parking.AlertHandling.AlertHandling;
import com.example.parking.R;
import com.example.parking.onBoarding.onBoardingFragment1;
import com.example.parking.onBoarding.onBoardingFragment2;
import com.example.parking.onBoarding.onBoardingFragment3;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity{
    private BottomNavigationView BottomNavigation;
    private Fragment onBoarding1,onBoarding2;
    static int flag = 0;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.BottomNavigation = findViewById(R.id.bottomNavigationMain);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.fragment_main,new onBoardingFragment1());
        fragmentTransaction.commit();
        bottomNavigation();
        Log.e(TAG, "MainActivity: " + getBaseContext().toString());


        onBoarding1 = new onBoardingFragment1();
        onBoarding2 = new onBoardingFragment2();
    }
    public void bottomNavigation(){
        TextView SkipButton,NextButton;
        View ellipse_15,ellipse_20,ellipse_10;
        flag = 0;
        BottomNavigationView bottomNavigationView;
        SkipButton = findViewById(R.id.SkipButton);
        NextButton = findViewById(R.id.NextButton);
        ellipse_15 = findViewById(R.id.ellipse_15);
        ellipse_20 = findViewById(R.id.ellipse_20);
        ellipse_10 = findViewById(R.id.ellipse_10);
        bottomNavigationView = findViewById(R.id.bottomNavigationMain);

        ellipse_15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ellipse_15.setBackground(getDrawable(R.drawable.border1));
                ellipse_20.setBackground(getDrawable(R.drawable.border));
                ellipse_10.setBackground(getDrawable(R.drawable.border));
                flag = 0;
                NextButton.setVisibility(View.VISIBLE);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.fragment_main,new onBoardingFragment1());
                fragmentTransaction.commit();
            }
        });
        ellipse_20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ellipse_15.setBackground(getDrawable(R.drawable.border));
                ellipse_20.setBackground(getDrawable(R.drawable.border1));
                ellipse_10.setBackground(getDrawable(R.drawable.border));
                flag = 0;
                NextButton.setVisibility(View.VISIBLE);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.fragment_main,new onBoardingFragment2());
                fragmentTransaction.commit();
            }
        });
        ellipse_10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ellipse_15.setBackground(getDrawable(R.drawable.border));
                ellipse_20.setBackground(getDrawable(R.drawable.border));
                ellipse_10.setBackground(getDrawable(R.drawable.border1));
                flag = 0;
                NextButton.setVisibility(View.GONE);
                bottomNavigationView.setVisibility(View.GONE);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.fragment_main,new onBoardingFragment3());
                fragmentTransaction.commit();

            }
        });
        SkipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ellipse_15.setBackground(getDrawable(R.drawable.border));
                ellipse_20.setBackground(getDrawable(R.drawable.border));
                ellipse_10.setBackground(getDrawable(R.drawable.border1));
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.fragment_main,new onBoardingFragment3());
                fragmentTransaction.commit();
                bottomNavigationView.setVisibility(View.GONE);
                NextButton.setVisibility(View.GONE);

            }
        });
        NextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(flag == 1)
                {
                    ellipse_15.setBackground(getDrawable(R.drawable.border));
                    ellipse_20.setBackground(getDrawable(R.drawable.border));
                    ellipse_10.setBackground(getDrawable(R.drawable.border1));
                    flag = 2;
                    bottomNavigationView.setVisibility(View.GONE);
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.fragment_main,new onBoardingFragment3());
                    fragmentTransaction.commit();
                }
                else if(flag == 0){
                    ellipse_15.setBackground(getDrawable(R.drawable.border));
                    ellipse_20.setBackground(getDrawable(R.drawable.border1));
                    ellipse_10.setBackground(getDrawable(R.drawable.border));
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction().replace(R.id.fragment_main, new onBoardingFragment2());
                    flag = 1;
                    NextButton.setVisibility(View.VISIBLE);
                    fragmentTransaction.commit();
                }
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (true) {
            AlertHandling alertHandling = new AlertHandling(MainActivity.this);
            alertHandling.exitWindowAlert();
        } else {
            super.onBackPressed();
        }
    }
}
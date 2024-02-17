package com.example.parking.AuthenticationModule;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.parking.AlertHandling.AlertHandling;
import com.example.parking.R;

public class LoginActivity extends AppCompatActivity {
    protected SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        FragmentTransaction loginFragment = getSupportFragmentManager().beginTransaction()
                .replace(R.id.loginFragment, new LoginFragment());
        loginFragment.commit();


        Log.e(TAG, "LoginActivity: " + getBaseContext().toString());


    }

    @Override
    public void onBackPressed() {
        if (true) {
            AlertHandling alertHandling = new AlertHandling(LoginActivity.this);
            alertHandling.exitWindowAlert();
        } else {
            super.onBackPressed();
        }

    }
}

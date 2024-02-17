package com.example.parking.AlertHandling;

import static androidx.core.content.ContextCompat.startActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.widget.Toast;

import com.example.parking.R;

public class AlertHandling {
    static int chance = 3;
    public Context context;

    public AlertHandling(Context context) {
        this.context = context;
    }

    public void loginSuccessful() {
        new AlertDialog.Builder(this.context)
                .setIcon(R.drawable.logo1)
                .setTitle("Login Successfully")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "Lets Drive With Me..", Toast.LENGTH_LONG);
                    }
                })
                .show();
    }

    public void loginChanceRemaining() {

        new AlertDialog.Builder(this.context)
                .setIcon(R.drawable.logo1)
                .setTitle("Chance Remaining : " + chance)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "Lets Park here", Toast.LENGTH_LONG);
                    }
                })
                .show();
        chance -= 1;
        if (chance == 0) {
            chance = 3;
            //check after 24 hours...
        }
    }

    public void checkUserNameAndPasswordAlertHandling() {
        new AlertDialog.Builder(this.context)
                .setIcon(R.drawable.logo1)
                .setTitle("PHONE NUMBER OR PASSWORD IS NOT CORRECT")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "Lets Drive With Me..", Toast.LENGTH_LONG);
                    }
                })
                .show();
    }

    public void accountCreatedSuccessfullyAlertHandling() {
        new AlertDialog.Builder(this.context)
                .setIcon(R.drawable.logo1)
                .setTitle("Account Created Successfully.")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "Lets Drive With Me..", Toast.LENGTH_LONG);
                    }
                })
                .show();
    }

    public void createAccountFragment2AlertHandling() {
        new AlertDialog.Builder(this.context)
                .setIcon(R.drawable.logo1)
                .setTitle("New Password and Confirm Password is not Same")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "Lets Drive With Me..", Toast.LENGTH_LONG);
                    }
                })
                .show();
    }

    public void createAccountFragmentAlertHandling() {
        new AlertDialog.Builder(this.context)
                .setIcon(R.drawable.logo1)
                .setTitle("All Data Must Filled")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "Lets Drive With Me..", Toast.LENGTH_LONG);
                    }
                })
                .show();
    }

    public void exitWindowAlert() {
        new AlertDialog.Builder(this.context)
                .setIcon(R.drawable.logo1)
                .setTitle("Do you want to exit app !")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent a = new Intent(Intent.ACTION_MAIN);
                        a.addCategory(Intent.CATEGORY_HOME);
                        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                        startActivity(context, a, null);

                    }
                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "Lets Drive with Me", Toast.LENGTH_SHORT).show();
                    }
                }).show();
    }
}

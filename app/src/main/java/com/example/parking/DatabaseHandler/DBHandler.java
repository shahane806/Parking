package com.example.parking.DatabaseHandler;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DBHandler extends SQLiteOpenHelper {
    private static final String DB_NAME = "PARKING_DATABASE";
    private static final int DB_VERSION = 1;
    private static final String TABLE_ACCOUNTS = "ACCOUNTS";
    private static final String TABLE_FORGETPASSWORD = "FORGET_PASSWORD";
    private static final String TABLE_LOGINUSER = "LOGIN_USER";

    private static final String ID_COL = "id", NAME_COL = "name", PHONE_COL = "phone", ADDRESS_COL = "address", PAN_COL
            = "pan", AADHAAR_COL = "aadhaar", NEW_PASSWORD_COL = "new_password", CONFIRM_PASSWORD_COL = "confirm_password", VEHICLE_MODEL_COL = "vehicle_model", VEHICLE_NUMBER_COL = "vehicle_number", OLD_PASSWORD = "old_password",
            LOGGED_IN = "logged_in", LOGGED_IN_TIME = "logged_in_time", LOGGED_OUT_TIME = "logged_out_time";

    public DBHandler(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Database Path : C:\Users\acer\AppData\Local\Google\AndroidStudio2023.1\device-explorer\Medium Phone API 30\_\data\data\com.example.parking
        try {
            db = this.getWritableDatabase();
            accountsTableCreation(db);

        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public void accountsTableCreation(SQLiteDatabase db) {

        String accountsTableQuery = "CREATE TABLE IF NOT EXISTS " + TABLE_ACCOUNTS + " (" + ID_COL + " INTEGER PRIMARY KEY," + NAME_COL + " TEXT," + PHONE_COL + " TEXT," + ADDRESS_COL + " TEXT," + PAN_COL + " TEXT," +
                AADHAAR_COL + " TEXT," + NEW_PASSWORD_COL + " TEXT," + CONFIRM_PASSWORD_COL + " TEXT,"
                + VEHICLE_MODEL_COL + " TEXT," + VEHICLE_NUMBER_COL + " TEXT)";

        try {
            db.execSQL(accountsTableQuery);
        } catch (Exception e) {
            Log.e(TAG, "TABLE ACCOUNTS IS ALREADY CREATED");
        }

    }

    public void forgetPasswordTableCreation(SQLiteDatabase db) {
        String forgetPasswordTableQuery = "CREATE TABLE IF NOT EXISTS " + TABLE_FORGETPASSWORD + " (" + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT," + NEW_PASSWORD_COL + " TEXT," + CONFIRM_PASSWORD_COL + " TEXT," + OLD_PASSWORD + " TEXT)";
        db.execSQL(forgetPasswordTableQuery);
        db.close();
    }

    public void loginUserTableCreation(SQLiteDatabase db) {
        String loginUserTableQuery = "CREATE TABLE IF NOT EXISTS " + TABLE_LOGINUSER + " (" + ID_COL + "INTEGER PRIMARY KEY AUTOINCREMENT," + LOGGED_IN + " BOOLEAN," + LOGGED_IN_TIME + " DATE," + LOGGED_OUT_TIME + " DATE)";
        db.execSQL(loginUserTableQuery);
        db.close();
    }

    public void insertIntoAccountTable(
            String NAME_COL,
            String PHONE_COL,
            String ADDRESS_COL,
            String PAN_COL,
            String AADHAAR_COL,
            String NEW_PASSWORD_COL,
            String CONFIRM_PASSWORD_COL,
            String VEHICLE_MODEL_COL,
            String VEHICLE_NUMBER_COL
    ) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", NAME_COL);
        contentValues.put("phone", PHONE_COL);
        contentValues.put("address", ADDRESS_COL);
        contentValues.put("pan", PAN_COL);
        contentValues.put("aadhaar", AADHAAR_COL);
        contentValues.put("new_password", NEW_PASSWORD_COL);
        contentValues.put("confirm_password", CONFIRM_PASSWORD_COL);
        contentValues.put("vehicle_model", VEHICLE_MODEL_COL);
        contentValues.put("vehicle_number", VEHICLE_NUMBER_COL);
//        Log.e(TAG, "Name : " + contentValues.get("name"));
//        Log.e(TAG, "Aadhaar : " + contentValues.get("aadhaar"));
        long f = db.insert(TABLE_ACCOUNTS, null, contentValues);
        if (f != 0) {

//            Log.e(TAG, "Value Inserted : " + f);
        }
        db.close();
    }

    public void updateAccountTable() {


    }

    public void deleteAllRowsFromAccountTable() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS 'ACCOUNTS'");
        onCreate(db);
        db.close();
    }

    public void deleteFromAccountTable(SQLiteDatabase db, int ID) {
        db = getWritableDatabase();
        db.execSQL("DELETE FROM " + TABLE_ACCOUNTS + " WHERE id ='" + ID + "'");
        db.close();
    }

    public boolean checkUserNameAndPassword(String UserName, String Password, int ID) {
        SQLiteDatabase db = this.getReadableDatabase();
        StringBuffer buffer = new StringBuffer();
        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_ACCOUNTS + " WHERE " + ID_COL + " = '" + ID + "'", null);
        if (c != null) {
            while (c.moveToNext()) {
                buffer.append(c.getString(2) + "&" + c.getString(7));
                String chk = buffer.toString();
                String[] s = chk.split("&");
                String dbUserName = s[0];
                String dbPassword = s[1];
//                Log.e(TAG,UserName+Password+dbUserName+dbPassword);
                if (UserName.equals(dbUserName)) {
                    return Password.equals(dbPassword);
                } else {
                    return false;
                }

            }
        } else {
            return false;
        }
        db.close();
        return false;
    }

    public void readAccountTable(SQLiteDatabase db) {
        db = this.getReadableDatabase();

        Cursor c = db.rawQuery("SELECT * FROM " + TABLE_ACCOUNTS, null);
        if (c != null) {
            while (c.moveToNext()) {
                Log.e(TAG, "DATA : " + c.getString(0) + c.getString(1) + c.getString(2) + c.getString(3) + c.getString(4) + c.getString(5) +
                        c.getString(6) + c.getString(7) + c.getString(8) + c.getString(9));
            }
        }
        db.close();
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS 'ACCOUNTS'");
        onCreate(db);
    }

}

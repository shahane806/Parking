package com.example.parking.AuthenticationModule;


import android.content.Context;

import com.example.parking.AlertHandling.AlertHandling;
import com.example.parking.DatabaseHandler.DBHandler;

class CreateNewAccount {
    public static String name, address, phoneNumber, pan, aadhaar, new_password, confirm_password, vehicle_model, vehicle_number;
    public AlertHandling alertHandling;

    public CreateNewAccount() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        CreateNewAccount.name = name;
    }

    public String getAadhaar() {
        return aadhaar;
    }

    public void setAadhaar(String aadhaar) {
        CreateNewAccount.aadhaar = aadhaar;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        CreateNewAccount.address = address;
    }

    public String getConfirm_password() {
        return confirm_password;
    }

    public void setConfirm_password(String confirm_password) {
        CreateNewAccount.confirm_password = confirm_password;
    }

    public String getNew_password() {
        return new_password;
    }

    public void setNew_password(String new_password) {
        CreateNewAccount.new_password = new_password;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        CreateNewAccount.pan = pan;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        CreateNewAccount.phoneNumber = phoneNumber;
    }

    public String getVehicle_model() {
        return vehicle_model;
    }

    public void setVehicle_model(String vehicle_model) {
        CreateNewAccount.vehicle_model = vehicle_model;
    }

    public String getVehicle_number() {
        return vehicle_number;
    }

    public void setVehicle_number(String vehicle_number) {
        CreateNewAccount.vehicle_number = vehicle_number;
    }

    public boolean checkUserNameAndPassword(Context context, String phoneNumber, String password) {
        alertHandling = new AlertHandling(context);
        DBHandler dbHandler = new DBHandler(context);
        boolean flag = dbHandler.checkUserNameAndPassword(phoneNumber, password, 1);
        return flag;
    }

}

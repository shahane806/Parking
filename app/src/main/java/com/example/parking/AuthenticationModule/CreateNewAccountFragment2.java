package com.example.parking.AuthenticationModule;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.parking.AlertHandling.AlertHandling;
import com.example.parking.DatabaseHandler.DBHandler;
import com.example.parking.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateNewAccountFragment2#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateNewAccountFragment2 extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CreateNewAccountFragment2() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreateNewAccountFragment2.
     */
    // TODO: Rename and change types and number of parameters
    public static CreateNewAccountFragment2 newInstance(String param1, String param2) {
        CreateNewAccountFragment2 fragment = new CreateNewAccountFragment2();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    RelativeLayout submitInformation;

    public SQLiteDatabase db;
    public EditText aadhaarEditText, new_password_edit_text, confirm_password_edit_text, vehicle_model_edit_text, vehicle_number_edit_text;
    public String aadhaar, new_password, confirm_password, vehicle_model, vehicle_number;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_create_new_account2, container, false);
        submitInformation = v.findViewById(R.id.SubmitButton);
        aadhaarEditText = v.findViewById(R.id.aadhaar);
        new_password_edit_text = v.findViewById(R.id.createAccountTwoNewPassword);
        confirm_password_edit_text = v.findViewById(R.id.createAccountTwoConfirmPassword);
        vehicle_model_edit_text = v.findViewById(R.id.vehicleModel);
        vehicle_number_edit_text = v.findViewById(R.id.vehicleNumber);

        AlertHandling alertHandling = new AlertHandling(getContext());


        submitInformation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aadhaar = new_password = confirm_password = vehicle_model = vehicle_number = "";
                aadhaar = aadhaarEditText.getText().toString();
                new_password = new_password_edit_text.getText().toString();
                confirm_password = confirm_password_edit_text.getText().toString();
                vehicle_model = vehicle_model_edit_text.getText().toString();
                vehicle_number = vehicle_number_edit_text.getText().toString();


                if (aadhaar.equals("") || new_password.equals("") || confirm_password.equals("") || vehicle_model.equals("") || vehicle_number.equals("")) {


                    alertHandling.createAccountFragmentAlertHandling();
                } else {
                    CreateNewAccount c = new CreateNewAccount();
                    c.setAadhaar(aadhaar);
                    c.setNew_password(new_password);
                    c.setConfirm_password(confirm_password);
                    c.setVehicle_model(vehicle_model);
                    c.setVehicle_number(vehicle_number);
                    DBHandler dbHandler = new DBHandler(getActivity().getApplicationContext());
                    if (new_password.equals(confirm_password)) {
                        try {
                            dbHandler.onCreate(db);
                            dbHandler.insertIntoAccountTable(c.getName(), c.getPhoneNumber(), c.getAddress(), c.getPan(), c.getAadhaar(),
                                    c.getNew_password(), c.getConfirm_password(), c.getVehicle_model(), c.getVehicle_number());

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        alertHandling.accountCreatedSuccessfullyAlertHandling();
                        FragmentTransaction transactionToLoginFragment = getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.loginFragment, new LoginFragment());
                        transactionToLoginFragment.commit();
                    } else {
                        alertHandling.createAccountFragment2AlertHandling();
                    }

                }


            }
        });
        return v;
    }
}
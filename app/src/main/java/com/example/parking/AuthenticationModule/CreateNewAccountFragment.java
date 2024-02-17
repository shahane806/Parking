package com.example.parking.AuthenticationModule;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.parking.AlertHandling.AlertHandling;
import com.example.parking.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CreateNewAccountFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class CreateNewAccountFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CreateNewAccountFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CreateNewAccountFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CreateNewAccountFragment newInstance(String param1, String param2) {
        CreateNewAccountFragment fragment = new CreateNewAccountFragment();
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

    RelativeLayout createAccountFragmentNextButton;
    EditText nameEditText, phoneNumberEditText, addressEditText, panEditText;
    String name, phoneNumber, address, pan;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_create_new_account, container, false);
        createAccountFragmentNextButton = v.findViewById(R.id.CreateAccountNextButton);
        nameEditText = v.findViewById(R.id.name);
        phoneNumberEditText = v.findViewById(R.id.phoneNumber);
        addressEditText = v.findViewById(R.id.address);
        panEditText = v.findViewById(R.id.PAN);


        createAccountFragmentNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = phoneNumber = address = pan = "";

                name = nameEditText.getText().toString();
                phoneNumber = phoneNumberEditText.getText().toString();
                address = addressEditText.getText().toString();
                pan = panEditText.getText().toString();

                if (name.equals("") || phoneNumber.equals("") || address.equals("") || pan.equals("")) {


                    AlertHandling alertHandling = new AlertHandling(getContext());
                    alertHandling.createAccountFragmentAlertHandling();
                } else {
                    CreateNewAccount c = new CreateNewAccount();
                    c.setName(name);
                    c.setPhoneNumber(phoneNumber);
                    c.setAddress(address);
                    c.setPan(pan);
                    FragmentTransaction createAccountTwo = getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.loginFragment, new CreateNewAccountFragment2());
                    createAccountTwo.commit();
                }

            }
        });
        return v;
    }
}
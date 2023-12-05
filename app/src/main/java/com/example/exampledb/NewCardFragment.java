package com.example.exampledb;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


public class NewCardFragment extends Fragment {



    private String deviceNumber;
    private String deviceStatus;
    private String status;
    private String type;
    private String address;
    private String verificationDate;
    private String verificationExpirationDate;
    private String stamp;
    private String lastReadings;

    EditText TV_deviceNumber;
    EditText TV_deviceStatus;
    EditText TV_type;
    EditText TV_address;
    EditText TV_verificationDate;
    EditText TV_verificationExpirationDate;
    EditText TV_stamp;
    EditText TV_lastReadings;

    public NewCardFragment() {
        // Required empty public constructor
    }



    public static NewCardFragment newInstance(String deviceNumber, String deviceStatus, String type, String address,
                                              String verificationDate, String verificationExpirationDate, String stamp, String lastReadings) {
        NewCardFragment fragment = new NewCardFragment();
        Bundle args = new Bundle();
        args.putString("deviceNumber", deviceNumber);
        args.putString("deviceStatus", deviceStatus);
        args.putString("type", type);
        args.putString("address", address);
        args.putString("verificationDate", verificationDate);
        args.putString("verificationExpirationDate", verificationExpirationDate);
        args.putString("stamp", stamp);
        args.putString("lastReadings", lastReadings);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            deviceNumber = getArguments().getString("deviceNumber");
            deviceStatus = getArguments().getString("deviceStatus");
            type = getArguments().getString("type");
            address = getArguments().getString("address");
            verificationDate = getArguments().getString("verificationDate");
            verificationExpirationDate = getArguments().getString("verificationExpirationDate");
            stamp = getArguments().getString("stamp");
            lastReadings = getArguments().getString("lastReadings");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_new_card, container, false);
        TV_deviceNumber = fragmentView.findViewById(R.id.TV_deviceNumber);
        TV_deviceNumber.setText(deviceNumber);
        TV_deviceStatus = fragmentView.findViewById(R.id.TV_deviceStatus);
        TV_deviceStatus.setText(deviceStatus);
        TV_type = fragmentView.findViewById(R.id.TV_type);
        TV_type.setText(type);
        TV_address = fragmentView.findViewById(R.id.TV_address);
        TV_address.setText(address);
        TV_verificationDate = fragmentView.findViewById(R.id.TV_verificationDate);
        TV_verificationDate.setText(verificationDate);
        TV_verificationExpirationDate = fragmentView.findViewById(R.id.TV_verificationExpirationDate);
        TV_verificationExpirationDate.setText(verificationExpirationDate);
        TV_stamp = fragmentView.findViewById(R.id.TV_stamp);
        TV_stamp.setText(stamp);
        TV_lastReadings = fragmentView.findViewById(R.id.TV_lastReadings);
        TV_lastReadings.setText(lastReadings);
        return fragmentView;
    }
}
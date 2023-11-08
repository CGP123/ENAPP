package com.example.exampledb;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class NewCardFragment extends Fragment {



    private String deviceNumber;
    private String nameOfOwner;
    private String status;
    private String stamp;

    TextView TV_deviceNumber;
    TextView TV_nameOfOwner;
    TextView TV_status;
    TextView TV_stamp;
    public NewCardFragment() {
        // Required empty public constructor
    }



    public static NewCardFragment newInstance(String deviceNumber, String nameOfOwner,
                                              String status, String stamp) {
        NewCardFragment fragment = new NewCardFragment();
        Bundle args = new Bundle();
        args.putString("deviceNumber", deviceNumber);
        args.putString("nameOfOwner", nameOfOwner);
        args.putString("status", status);
        args.putString("stamp", stamp);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            deviceNumber = getArguments().getString("deviceNumber");
            nameOfOwner = getArguments().getString("nameOfOwner");
            status = getArguments().getString("status");
            stamp = getArguments().getString("stamp");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_new_card, container, false);
        TV_deviceNumber = fragmentView.findViewById(R.id.TV_deviceNumber);
        TV_deviceNumber.setText(deviceNumber);
        TV_nameOfOwner = fragmentView.findViewById(R.id.TV_nameOfOwner);
        TV_nameOfOwner.setText(nameOfOwner);
        TV_status = fragmentView.findViewById(R.id.TV_status);
        TV_status.setText(status);
        TV_stamp = fragmentView.findViewById(R.id.TV_stamp);
        TV_stamp.setText(stamp);
        return fragmentView;
    }
}
package com.example.exampledb;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import com.example.exampledb.dataBase.DBManager;
import com.example.exampledb.dataBase.MeteringDeviceTableManager;


public class MainScreenFragment extends Fragment {


    DBManager dbManager;
    MeteringDeviceTableManager meteringDeviceTableManager;
    EditText ED_searchField;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_main_screen, container, false);
        dbManager = new DBManager(getContext());
        dbManager.openDB();
        meteringDeviceTableManager = new MeteringDeviceTableManager(getContext());
        ED_searchField = fragmentView.findViewById(R.id.ED_searchField);
        ED_searchField.setOnEditorActionListener((textView, i, keyEvent) -> {
            if (i == EditorInfo.IME_ACTION_SEARCH) {
                MeteringDevice device = meteringDeviceTableManager.getMeteringDeviceByNumber(ED_searchField.getText().toString());
                if (device != null){
                    ((MainActivity) getActivity()).showDeviceCard(NewCardFragment.newInstance(device.getDeviceNumber(),
                            device.getNameOfOwner(), device.getStatus(), device.getStamp()));
                }

            }
            return false;
        });
        return fragmentView;
    }
}
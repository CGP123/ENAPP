package com.example.exampledb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.exampledb.dataBase.DBManager;
import com.example.exampledb.dataBase.MeteringDeviceTableManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageButton IB_fragmentSwitch;
    private MainScreenFragment mainScreenFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IB_fragmentSwitch = findViewById(R.id.IB_fragmentSwitch);

        IB_fragmentSwitch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setMainScreenFragment(mainScreenFragment);
            }
        });
    }

    public void showDeviceCard(NewCardFragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.fragmentContainerView, fragment).commit();
    }

    private void setMainScreenFragment(MainScreenFragment fragment) {
        MainScreenFragment mainScreenFragment = new MainScreenFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.fragmentContainerView, mainScreenFragment).commit();
    }
}
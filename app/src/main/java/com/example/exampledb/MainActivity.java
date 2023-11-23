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
    private MeteringDeviceTableManager meteringDeviceTableManager;
    private DBManager dbManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbManager = new DBManager(this);
        meteringDeviceTableManager = new MeteringDeviceTableManager(this);

        IB_fragmentSwitch = findViewById(R.id.IB_fragmentSwitch);

        dbManager.openDB();
        List<MeteringDevice> list = new ArrayList<>();
        MeteringDevice meteringDevice1 = new MeteringDevice("АКУД15794235","Иванов И. И.","Опломбирован","21.11.2023");
        MeteringDevice meteringDevice2 = new MeteringDevice("ИСИБ74521398","Дмитриев В.П","Опломбирован","17.03.2004");
        MeteringDevice meteringDevice3 = new MeteringDevice("АСУБ45127894","Пупкин В. И.","Не опломбирован","14.08.2011");

        list.add(meteringDevice1);
        list.add(meteringDevice2);
        list.add(meteringDevice3);

        //meteringDeviceTableManager.addNewMeteringDevice(list);
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
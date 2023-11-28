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
        MeteringDevice meteringDevice1 = new MeteringDevice("549630481","Статус: активен","Тип прибора: счётчик ГВС","Адрес: Красногвардейская ул., 20 корпус 1, 37 кв","Дата поверки: 12.12.2022","Дата окончания поверки: 12.12.2023","Пломбы: присутствуют","Последние показания: 56 м3");
        MeteringDevice meteringDevice2 = new MeteringDevice("783245481","Статус: неактивен","Тип прибора: ЭЭ","Адрес: Ямская ул., 28, 45 кв","Дата поверки: 31.04.2022","Дата окончания поверки: 31.04.2023","Пломбы: присутствуют","Последние показания: 88 квт*ч");
        MeteringDevice meteringDevice3 = new MeteringDevice("965201481","Статус: активен","Тип прибора: ХВС","Адрес: ул. Красных Мадьяр, 68","Дата поверки: 05.05.2022","Дата окончания поверки: 05.12.2023","Пломбы: отсутствуют","Последние показания: 73 м3");

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
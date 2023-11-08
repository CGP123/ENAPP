package com.example.exampledb.dataBase;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import com.example.exampledb.MeteringDevice;

import java.util.List;

public class MeteringDeviceTableManager extends DBManager{
    public MeteringDeviceTableManager(Context context) {
        super(context);
    }

    public void addNewMeteringDevice(List<MeteringDevice> meteringDevices){
        String sql = "INSERT INTO " + MeteringDevicesTableSchema.TABLE_NAME + " VALUES(?,?,?,?);";
        SQLiteStatement statement = db.compileStatement(sql);
        db.beginTransaction();
        Log.d("MyLog", "начало записи данных");
        try {
            for (MeteringDevice device : meteringDevices) {
                statement.bindString(1, device.getDeviceNumber());
                statement.bindString(2, device.getNameOfOwner());
                statement.bindString(3, device.getStatus());
                statement.bindString(4, device.getStamp());
                statement.execute();
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
        Log.d("MyLog", "данные записаны");
    }
    @SuppressLint("Range")
    public MeteringDevice getMeteringDeviceByNumber(String deviceNumber){
        Cursor cursor = db.rawQuery("SELECT  * FROM " + MeteringDevicesTableSchema.TABLE_NAME +
                " WHERE " + MeteringDevicesTableSchema.DEVICE_NUMBER + "=?", new String[]{deviceNumber});
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
             String nameOfOwner = cursor.getString(cursor.getColumnIndex(MeteringDevicesTableSchema.NAME_OF_OWNER));
             String status = cursor.getString(cursor.getColumnIndex(MeteringDevicesTableSchema.STATUS));
             String stamp = cursor.getString(cursor.getColumnIndex(MeteringDevicesTableSchema.STAMP));
            return new MeteringDevice(deviceNumber, nameOfOwner, status, stamp);
        }
        else return null;
    }
}

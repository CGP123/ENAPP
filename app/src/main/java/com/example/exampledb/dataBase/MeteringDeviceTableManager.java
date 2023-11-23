package com.example.exampledb.dataBase;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

import com.example.exampledb.MeteringDevice;

import java.util.List;

public class MeteringDeviceTableManager extends DBManager {
    public MeteringDeviceTableManager(Context context) {
        super(context);
    }

    public void addNewMeteringDevice(List<MeteringDevice> meteringDevices) {
        String sql = "INSERT INTO " + MeteringDevicesTableSchema.TABLE_NAME + " VALUES(?,?,?,?,?,?,?,?);";
        SQLiteStatement statement = db.compileStatement(sql);
        db.beginTransaction();
        Log.d("MyLog", "начало записи данных");
        try {
            for (MeteringDevice device : meteringDevices) {
                statement.bindString(1, device.getDeviceNumber());
                statement.bindString(2, device.getStatus());
                statement.bindString(3, device.getType());
                statement.bindString(4, device.getAddress());
                statement.bindString(5, device.getVerificationDate());
                statement.bindString(6, device.getVerificationExpirationDate());
                statement.bindString(7, device.getStamp());
                statement.bindString(8, device.getLastReadings());
                statement.execute();
            }
            db.setTransactionSuccessful();
        } finally {
            db.endTransaction();
        }
        Log.d("MyLog", "данные записаны");
    }

    @SuppressLint("Range")
    public MeteringDevice getMeteringDeviceByNumber(String deviceNumber) {
        Cursor cursor = db.rawQuery("SELECT  * FROM " + MeteringDevicesTableSchema.TABLE_NAME +
                " WHERE " + MeteringDevicesTableSchema.DEVICE_NUMBER + "=?", new String[]{deviceNumber});
        if (cursor.moveToFirst()) {
            cursor.moveToFirst();
            String status = cursor.getString(cursor.getColumnIndex(MeteringDevicesTableSchema.STATUS));
            String type = cursor.getString(cursor.getColumnIndex(MeteringDevicesTableSchema.TYPE));
            String address = cursor.getString(cursor.getColumnIndex(MeteringDevicesTableSchema.ADDRESS));
            String verificationDate = cursor.getString(cursor.getColumnIndex(MeteringDevicesTableSchema.VERIFICATION_DATE));
            String verificationExpirationDate = cursor.getString(cursor.getColumnIndex(MeteringDevicesTableSchema.VERIFICATION_EXPIRATION_DATE));
            String stamp = cursor.getString(cursor.getColumnIndex(MeteringDevicesTableSchema.STAMP));
            String lastReadings = cursor.getString(cursor.getColumnIndex(MeteringDevicesTableSchema.LAST_READINGS));
            return new MeteringDevice(deviceNumber, status, type, address, verificationDate,
                    verificationExpirationDate, stamp, lastReadings);
        }
        else return null;
    }
}

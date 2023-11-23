package com.example.exampledb.dataBase;

public class MeteringDevicesTableSchema {
    public static final String TABLE_NAME = "metering_devices";
    public static final String STATUS = "status";
    public static final String TYPE = "type";
    public static final String DEVICE_NUMBER = "device_number";
    public static final String ADDRESS = "address";
    public static final String VERIFICATION_DATE = "verification_date";
    public static final String VERIFICATION_EXPIRATION_DATE = "verification_expiration_date";
    public static final String STAMP ="stamp";
    public static final String LAST_READINGS = "last_readings";

    public static final String TABLE_SCHEMA = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME + " (" + DEVICE_NUMBER + "  PRIMARY KEY," + STATUS + " TEXT," +
            TYPE + " TEXT," + ADDRESS +  " TEXT," + VERIFICATION_DATE +  " TEXT," +
            VERIFICATION_EXPIRATION_DATE +  " TEXT," + STAMP +  " TEXT," +  LAST_READINGS + " TEXT)";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
}

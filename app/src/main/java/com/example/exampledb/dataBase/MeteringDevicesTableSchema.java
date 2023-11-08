package com.example.exampledb.dataBase;

public class MeteringDevicesTableSchema {
    public static final String TABLE_NAME = "metering_devices";
    public static final String DEVICE_NUMBER = "device_number";
    public static final String NAME_OF_OWNER = "name_of_owner";
    public static final String STATUS = "status";
    public static final String STAMP ="stamp";

    public static final String TABLE_SCHEMA = "CREATE TABLE IF NOT EXISTS " +
            TABLE_NAME + " (" + DEVICE_NUMBER + "  PRIMARY KEY," +
            NAME_OF_OWNER + " TEXT," + STATUS + " TEXT," + STAMP + " TEXT)";
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
}

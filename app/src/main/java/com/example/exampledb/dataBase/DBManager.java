package com.example.exampledb.dataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ProgressBar;

public class DBManager {
    private static DBHelper dbHelper;
    protected static SQLiteDatabase db;
    protected Context context;

    public DBManager(Context context) {
        dbHelper = new DBHelper(context);
        this.context = context;
    }

    public void openDB() {
        db = dbHelper.getWritableDatabase();
    }

    public void closeDB() {
        dbHelper.close();
    }

    public void deleteTable(String tableName){
        db.delete(tableName, null, null);
    }
}

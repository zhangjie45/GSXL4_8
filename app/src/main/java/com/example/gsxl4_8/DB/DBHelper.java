package com.example.gsxl4_8.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by 11094 on 2017/4/8.
 */

public class DBHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "traffic.db";
    public  static final String TABLE_ROADENVI = "roadenvi";

    public DBHelper(Context context) {
        super(context, DB_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String table_trafficlight =
                "create table if not exists"
                        + TABLE_ROADENVI +
                        " (_id integer primary key autoincrement,time varchar(20),pm varchar(20),co2 varchar(20),light varchar(20),humidity varchar(20),temperature varchar(20))";
        db.execSQL(table_trafficlight);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table is exists " + TABLE_ROADENVI);
        onCreate(db);


    }
}

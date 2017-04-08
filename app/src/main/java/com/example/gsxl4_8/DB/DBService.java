package com.example.gsxl4_8.DB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.gsxl4_8.Model.RoadEnvi;

import java.util.ArrayList;

/**
 * Created by 11094 on 2017/4/8.
 */

public class DBService {
    private DBHelper dbHelper;

    public DBService(Context context) {
        super();
        this.dbHelper = new DBHelper(context);
    }

    public long insterRoadEnvis(RoadEnvi roadEnvi) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("time", roadEnvi.getTime());
        cv.put("pm", roadEnvi.getPm());
        cv.put("co2", roadEnvi.getCo2());
        cv.put("light", roadEnvi.getLight());
        cv.put("humidity", roadEnvi.getHumidity());
        cv.put("temperature", roadEnvi.getTememperature());
        long res = db.insert(DBHelper.TABLE_ROADENVI, null, cv);
        return res;
    }

    public ArrayList<RoadEnvi> findAllRoadEnvis() {
        ArrayList<RoadEnvi> roadEnvi = new ArrayList<RoadEnvi>();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query(DBHelper.TABLE_ROADENVI, null, null, null, null, null, null);
        RoadEnvi road = null;
        while (cursor.moveToNext()) {
            road = new RoadEnvi();
            road.setId(cursor.getInt(cursor.getColumnIndex("_id")));
            road.setCo2(cursor.getString(cursor.getColumnIndex("co2")));
            road.setHumidity(cursor.getString(cursor.getColumnIndex("humidity")));
            road.setPm(cursor.getString(cursor.getColumnIndex("pm")));
            road.setLight(cursor.getString(cursor.getColumnIndex("light")));
            road.setTime(cursor.getString(cursor.getColumnIndex("time")));
            road.setTememperature(cursor.getString(cursor.getColumnIndex("tememperature")));
            roadEnvi.add(road);
        }
        return roadEnvi;
    }

    public ArrayList<RoadEnvi> findAllRoadEnvisByTime(String asc) {
        ArrayList<RoadEnvi> roadEnvi = new ArrayList<RoadEnvi>();
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Cursor cursor = db.query(DBHelper.TABLE_ROADENVI, null, null, null, null, null, "time" + asc);
        RoadEnvi road = null;
        while (cursor.moveToNext()) {
            road = new RoadEnvi();
            road.setId(cursor.getInt(cursor.getColumnIndex("_id")));
            road.setCo2(cursor.getString(cursor.getColumnIndex("co2")));
            road.setHumidity(cursor.getString(cursor.getColumnIndex("humidity")));
            road.setPm(cursor.getString(cursor.getColumnIndex("pm")));
            road.setLight(cursor.getString(cursor.getColumnIndex("light")));
            road.setTime(cursor.getString(cursor.getColumnIndex("time")));
            road.setTememperature(cursor.getString(cursor.getColumnIndex("tememperature")));
            roadEnvi.add(road);
        }
        return roadEnvi;
    }


}

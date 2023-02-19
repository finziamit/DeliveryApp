package com.example.finalproject;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.Date;

public class MyDatabaseHelper extends SQLiteOpenHelper {
    private Context context;
    private static final String DATABASE_NAME = "Orders.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "my_orders";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_PRODUCT = "product";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_ORIGIN = "origin";
    private static final String COLUMN_DESTINATION = "destination";
    private static final String COLUMN_SEND = "send";
    private static final String COLUMN_ARRIVAL = "arrival";
    private static final String COLUMN_RECIVED = "recived";
    private static final String COLUMN_STATUS = "status";

    public MyDatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query =
                "CREATE TABLE " + TABLE_NAME +
                        " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        COLUMN_PRODUCT + " TEXT, " +
                        COLUMN_DATE + " DATE, " +
                        COLUMN_ORIGIN + " TEXT, " +
                        COLUMN_DESTINATION + " TEXT, " +
                        COLUMN_SEND + " DATE, " +
                        COLUMN_ARRIVAL + " DATE, " +
                        COLUMN_RECIVED + " DATE, " +
                        COLUMN_STATUS + " TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    void addOrder(String product, String order_date,
                  String origin_country, String destination_country){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_PRODUCT, product);
        cv.put(COLUMN_DATE, order_date);
        cv.put(COLUMN_ORIGIN, origin_country);
        cv.put(COLUMN_DESTINATION, destination_country);
        cv.put(COLUMN_SEND, order_date);
        cv.put(COLUMN_ARRIVAL, order_date);
        cv.put(COLUMN_RECIVED, order_date);
        cv.put(COLUMN_STATUS, "open");

        long result = db.insert(TABLE_NAME, null, cv);
        if (result == -1){
            Toast.makeText(context, "Order Adding Failed", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Added Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    Cursor readAllData(){
        String query = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;
        if(db != null){
            cursor = db.rawQuery(query, null);
        }
        return cursor;
    }

    void editData(String row_id, String product, String order_date,
                  String origin_country, String destination_country){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_PRODUCT, product);
        cv.put(COLUMN_DATE, order_date);
        cv.put(COLUMN_ORIGIN, origin_country);
        cv.put(COLUMN_DESTINATION, destination_country);
        cv.put(COLUMN_SEND, order_date);
        cv.put(COLUMN_ARRIVAL, order_date);
        cv.put(COLUMN_RECIVED, order_date);

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Order Edit Failed", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Order Edited Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    void deleteOneRow(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.delete(TABLE_NAME, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Order Deletion Failed", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Order Deleted Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    void closeOrder(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_STATUS, "close");

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Order Failed to Close", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Order Closed Successfully", Toast.LENGTH_SHORT).show();
        }
    }

    void openOrder(String row_id){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_STATUS, "open");

        long result = db.update(TABLE_NAME, cv, "_id=?", new String[]{row_id});
        if(result == -1){
            Toast.makeText(context, "Order Failed to Open", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(context, "Order Opened Successfully", Toast.LENGTH_SHORT).show();
        }
    }

}

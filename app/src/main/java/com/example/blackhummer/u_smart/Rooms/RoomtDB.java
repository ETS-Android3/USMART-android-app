package com.example.blackhummer.u_smart.Rooms;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

import com.example.blackhummer.u_smart.Rooms.RoomObject;


public class RoomtDB extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;
    // Database Name
    private static final String DATABASE_NAME = "room_db";
    public RoomtDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    // Creating Tables Method
    @Override
    public void onCreate(SQLiteDatabase db) {
        // create products table
        db.execSQL(RoomObject.CREATE_TABLE);
    }
    // Upgrading database method
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + RoomObject.TABLE_NAME);
        // Create tables again
        onCreate(db);
    }
    public long insertProduct(RoomObject product) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put(RoomObject.COLUMN_NAME, product.getName());
        // insert row
        long id = db.insert(RoomObject.TABLE_NAME, null, values);
        // close db connection
        db.close();
        // return newly inserted row id
        return id;
    }
    public RoomObject getProduct(long id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(RoomObject.TABLE_NAME,
                new String[]{RoomObject.COLUMN_ID, RoomObject.COLUMN_NAME},
                RoomObject.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        // prepare product object
        RoomObject product = new RoomObject(
                cursor.getInt(cursor.getColumnIndex(RoomObject.COLUMN_ID)),
                cursor.getString(cursor.getColumnIndex(RoomObject.COLUMN_NAME)));
        // close the db connection
        cursor.close();
        return product;
    }




    public List<RoomObject> getAllProducts() {
        List<RoomObject> products = new ArrayList<>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + RoomObject.TABLE_NAME + " ORDER BY " +
                RoomObject.COLUMN_ID + " DESC";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                RoomObject product = new RoomObject();
                product.setId(cursor.getInt(cursor.getColumnIndex(RoomObject.COLUMN_ID)));
                product.setName(cursor.getString(cursor.getColumnIndex(RoomObject.COLUMN_NAME)));

                products.add(product);
            } while (cursor.moveToNext());
        }
        // close db connection
        db.close();
        // return products list
        return products;
    }




    public int getProductsCount() {
        String countQuery = "SELECT  * FROM " + RoomObject.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);
        int count = cursor.getCount();
        cursor.close();
        // return count
        return count;
    }




    public int updateProduct(RoomObject product) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(RoomObject.COLUMN_NAME, product.getName());
        // updating row
        return db.update(RoomObject.TABLE_NAME, values, RoomObject.COLUMN_ID + " = ?",
                new String[]{String.valueOf(product.getId())});
    }



    public void deleteProduct(RoomObject product) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(RoomObject.TABLE_NAME, RoomObject.COLUMN_ID + " = ?",
                new String[]{String.valueOf(product.getId())});
        db.close();
    }
}
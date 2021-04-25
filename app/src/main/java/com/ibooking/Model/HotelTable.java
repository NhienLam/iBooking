package com.ibooking.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class HotelTable extends  SQLiteOpenHelper{
    public static final String HOTEL_TABLE = "HOTEL_TABLE";
    public static final String COLUMN_HOTEL_ID = "HOTEL_ID";
    public static final String COLUMN_ADDRESS = "ADDRESS";
    public static final String COLUMN_ZIP = "ZIP";
    public static final String COLUMN_RATING = "RATING";


    public HotelTable( Context context) {
        super(context, "hotel.db",null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + HOTEL_TABLE + " ("
                +COLUMN_HOTEL_ID + "INT PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_ADDRESS + " TEXT, "
                + COLUMN_ZIP + " INT, "
                + COLUMN_RATING + " DOUBLE)";

        db.execSQL(createTableStatement);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ HOTEL_TABLE);
        onCreate(db);

    }

    public boolean insertHotel(HotelModel hotelModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ADDRESS, hotelModel.getAddress());
        cv.put(COLUMN_ZIP, hotelModel.getZip());
        cv.put(COLUMN_RATING, hotelModel.getRating());


        long insert = db.insert(HOTEL_TABLE, null, cv);
        if(insert == -1) {
            return false;
        }
        else {
            return true;
        }
    }


    public boolean deleteHotel(HotelModel hotelModel){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + HOTEL_TABLE + " WHERE " + COLUMN_HOTEL_ID + " = " + hotelModel.getHotelID();

        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst())
        {
            return true;
        }
        else
        {
            return false;
        }

    }
    public ArrayList<HotelModel> getAllHotel(){
    ArrayList<HotelModel> hotelList = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + HOTEL_TABLE, null);
        //do something here
        return hotelList;
    }

    public ArrayList<HotelModel> getHotelByZip(int zip){
        ArrayList<HotelModel> hotelList = new ArrayList<>();
        // do something here
        return hotelList;
    }

    public void updateZip(HotelModel hotel){
        //do something here
    }
}

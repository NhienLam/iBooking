package com.example.ibooking.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

/**
 * Database helper of HotelModel
 * Handles all the operations related to Hotel database
 */
public class HotelTable extends  SQLiteOpenHelper{
    public static final String HOTEL_TABLE = "HOTEL_TABLE";
    public static final String COLUMN_HOTEL_ID = "HOTEL_ID";
    public static final String COLUMN_ADDRESS = "ADDRESS";
    public static final String COLUMN_CITY = "CITY";
    public static final String COLUMN_RATING = "RATING";

    /**
     * Constructs a Hotel database helper
     * @param context use for locating paths to the database
     */
    public HotelTable( Context context) {
        super(context, "hotel.db",null , 1);
    }

    /**
     * Called the first time a database is accessed
     * Creates a new Hotel Table
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE IF NOT EXISTS " + HOTEL_TABLE + " ("
                + COLUMN_HOTEL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_ADDRESS + " TEXT, "
                + COLUMN_CITY + " INT, "
                + COLUMN_RATING + " DOUBLE)";

        db.execSQL(createTableStatement);
    }
    /**
     * Called if the database version number changes
     * Prevents previous users apps from breaking when change database design
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ HOTEL_TABLE);
        onCreate(db);

    }

    /**
     * Insert new hotel to hotel table
     * @param hotelModel the hotel to add
     * @return true if successfully inserted to database, false otherwise
     */

    public boolean insertHotel(HotelModel hotelModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ADDRESS, hotelModel.getAddress());
        cv.put(COLUMN_CITY, hotelModel.getCity());
        cv.put(COLUMN_RATING, hotelModel.getRating());


        long insert = db.insert(HOTEL_TABLE, null, cv);
        if(insert == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * Delete a hotel from hotel table
     * @param hotelModel the hotel to delete
     * @return true if successfully inserted to database, false otherwise
     */

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

    /**
     * Searches and gets a hotel with the target address in the table
     * @param address target address
     * @return a hotel with the target address
     */
    public HotelModel getHotelByAddress(String address){

        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM " + HOTEL_TABLE + " WHERE " + COLUMN_ADDRESS + "='" + address + "'";

        Cursor cursor = db.rawQuery(query, null);
        HotelModel aHotel;
        if(cursor.moveToNext()){
            int hotelid = cursor.getInt(0);
            String hAddress = cursor.getString(1);
            String city = cursor.getString(2);
            Double rating = cursor.getDouble(3);
            aHotel = new HotelModel(hotelid, hAddress, city, rating);
        }
        else
        {
            aHotel = new HotelModel(-1, "error", "error", -1);
        }

        return aHotel;
    }

//    public ArrayList<HotelModel> getAllHotel(){
//        ArrayList<HotelModel> hotelList = new ArrayList<>();
//
//        SQLiteDatabase db = this.getReadableDatabase();
//        Cursor cursor = db.rawQuery("SELECT * FROM " + HOTEL_TABLE, null);
//        //do something here
//        return hotelList;
//    }

//    public ArrayList<HotelModel> getHotelByCity(int city){
//        ArrayList<HotelModel> hotelList = new ArrayList<>();
//        // do something here
//        return hotelList;
//    }

}

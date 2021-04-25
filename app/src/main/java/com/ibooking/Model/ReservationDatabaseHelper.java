package com.ibooking.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.RequiresApi;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static java.time.LocalDate.*;

public class ReservationDatabaseHelper extends SQLiteOpenHelper {

    public static final String RESERVATION_TABLE = "RESERVATION_TABLE";
    private static final String COLUMN_HOTEL_ADDRESS = "COLUMN_HOTEL_ADDRESS";
    public static final String COLUMN_ID = "COLUMN_ID";
    private static final String COLUMN_CHECKIN_DATE = "COLUMN_CHECKIN_DATE";
    private static final String COLUMN_CHECKOUT_DATE = "COLUMN_CHECKOUT_DATE";

    public ReservationDatabaseHelper(Context context) {
        super(context, "Reservation.db", null, 1);
    }

    /**
     * Called if the database version number changes
     * Prevents previous users apps from breaking when change database design
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + RESERVATION_TABLE + " (" + COLUMN_ID + " INTERGER PRIMARY KEY AUTOINCREMENT, " + COLUMN_HOTEL_ADDRESS
                + " TEXT, " + COLUMN_CHECKIN_DATE + " TEXT, " + COLUMN_CHECKOUT_DATE + " TEXT)";

        db.execSQL(createTableStatement);
    }

    //this is called if the version changed
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    /**
     * Inserts new reservation to table database
     * @param reservationModel the resevation to add
     * @return true if successfully inserted to database, false otherwise
     */
    @RequiresApi(api = Build.VERSION_CODES.O)
    public boolean insertReservation(ReservationModel reservationModel){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_HOTEL_ADDRESS, reservationModel.getHotelAddress());
        String date1 = reservationModel.getcheckInDate().toString();
        cv.put(COLUMN_CHECKIN_DATE, date1);
        String date2 = reservationModel.getcheckOutDate().toString();
        cv.put(COLUMN_CHECKOUT_DATE, date2);

        long insert = db.insert(RESERVATION_TABLE, null, cv);
        if (insert == -1)
            return false;
        else
            return true;
    }

    /**
     * Search for a reservationModel in the database
     * If found, delete it
     * @param reservationModel reservationModel to delete
     * @return true if successfully delete reservarionModel, false otherwise
     */
    public boolean deleteReservation(ReservationModel reservationModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + RESERVATION_TABLE + " WHERE " + COLUMN_ID + " = " + reservationModel.getId();

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

    @RequiresApi(api = Build.VERSION_CODES.O)
    public List<ReservationModel> getAllReservation()
    {
        List<ReservationModel> returnList = new ArrayList<>();

        String queryString = "SELECT * FROM " + RESERVATION_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst())
        {
            do {
                int id = cursor.getInt(0);
                String HotelAddress = cursor.getString(1);
                String checkin = cursor.getString(2);
                LocalDate checkinDate = parse(checkin);
                String checkout = cursor.getString(3);
                LocalDate checkoutDate = parse(checkout);

                ReservationModel newReservation = new ReservationModel(id, HotelAddress, checkinDate, checkoutDate );
                returnList.add(newReservation);

            } while(cursor.moveToNext());
        }
        else
        {

        }
        cursor.close();
        db.close();
        return returnList;
    }
}

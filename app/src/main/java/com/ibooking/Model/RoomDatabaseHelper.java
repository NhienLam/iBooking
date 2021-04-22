package com.ibooking.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RoomDatabaseHelper extends SQLiteOpenHelper
{
    public static final String ROOM_TABLE = "ROOM_TABLE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_ROOM_TYPE = "ROOM_TYPE";
    public static final String COLUMN_ROOM_NUMBER = "ROOM_NUMBER";
    public static final String COLUMN_ROOM_CAPACITY = "ROOM_CAPACITY";
    public static final String COLUMN_ROOM_PRICE = "ROOM_PRICE";
    public static final String COLUMN_AVAILABLE_ROOM = "AVAILABLE_ROOM";
    //-ROOM_TABLE [id, RoomType, RoomNumber, Capacity, Price, boolean isAvailable]

    /**
     * Constructs a RoomDatabaseHelper
     * @param context use for locating paths to the database
     */
    public RoomDatabaseHelper(Context context)
    {
        super(context, room.db, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String createTableStatement = "CREATE TABLE " + ROOM_TABLE + " ("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_ROOM_TYPE + " TEXT, " + COLUMN_ROOM_NUMBER + " INT, "
                + COLUMN_ROOM_CAPACITY + " INT, " + COLUMN_ROOM_PRICE + " DOUBLE, "
                + COLUMN_AVAILABLE_ROOM + " BOOL)";

        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addRoom(RoomModel roomModel)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ROOM_TYPE, roomModel.getRoomType());
        cv.put(COLUMN_ROOM_NUMBER, roomModel.getRoomNumber());
        cv.put(COLUMN_ROOM_CAPACITY, roomModel.getCapacity());
        cv.put(COLUMN_ROOM_PRICE, roomModel.getPrice());
        cv.put(COLUMN_AVAILABLE_ROOM, roomModel.isAvailable());

        long insert = db.insert(ROOM_TABLE, null, cv);
        if(insert == -1)
        {
            return false;
        }
        else
        {
            return true;
        }

    }
}

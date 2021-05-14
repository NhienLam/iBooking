package com.example.ibooking.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;

import java.util.ArrayList;
import java.util.List;

/**
 * Database helper of RoomInterface
 * Handles all the operations related to Room database
 */
public class RoomDatabaseHelper extends SQLiteOpenHelper
{
    public static final String ROOM_TABLE = "ROOM_TABLE";
    public static final String COLUMN_ROOM_ID = "ROOM_ID";
    public static final String COLUMN_HOTEL_ID = "HOTEL_ID";
    public static final String COLUMN_ROOM_TYPE = "ROOM_TYPE";
    public static final String COLUMN_ROOM_CAPACITY = "ROOM_CAPACITY";
    public static final String COLUMN_ROOM_PRICE = "ROOM_PRICE";
    public static final String COLUMN_AVAILABLE_ROOM = "AVAILABLE_ROOM";

    /**
     * Constructs a RoomDatabaseHelper
     * @param context use for locating paths to the database
     */
    public RoomDatabaseHelper(Context context)
    {
        super(context, "room.db", null, 1);
    }

    /**
     * Called the first time a database is accessed
     * Creates a new database
     */
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String createTableStatement = "CREATE TABLE " + ROOM_TABLE + " ("
                + COLUMN_ROOM_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_HOTEL_ID + " INT, "
                + COLUMN_ROOM_TYPE + " TEXT, "
                + COLUMN_ROOM_CAPACITY + " INT, "
                + COLUMN_ROOM_PRICE + " DOUBLE, "
                + COLUMN_AVAILABLE_ROOM + " BOOL)";

        db.execSQL(createTableStatement);
    }


    /**
     * Called if the database version number changes
     * Prevents previous users apps from breaking when change database design
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+ ROOM_TABLE);
        onCreate(db);
    }

    /**
     * Inserts new room to table database
     * @param roomModel the room to add
     * @return true if successfully inserted to database, false otherwise
     */
    public boolean insertRoom(RoomInterface roomModel)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_HOTEL_ID, roomModel.getHotelId());
        cv.put(COLUMN_ROOM_TYPE, roomModel.getRoomType());
        cv.put(COLUMN_ROOM_CAPACITY, roomModel.getCapacity());
        cv.put(COLUMN_ROOM_PRICE, roomModel.getPrice());
        cv.put(COLUMN_AVAILABLE_ROOM, roomModel.isAvailable());

        long insert = db.insert(ROOM_TABLE, null, cv);
        if(insert == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * Search for a roomModel in the database
     * If found, delete it
     * @param roomModel roomModel to delete
     * @return true if successfully delete roomModel, false otherwise
     */
    public boolean deleteRoom(RoomInterface roomModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + ROOM_TABLE + " WHERE " + COLUMN_ROOM_ID + " = " + roomModel.getRoomId();

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
     * Gets all rooms in the database
     * @return all rooms in the database
     */
    public List<RoomInterface> getAllRooms()
    {
        List<RoomInterface> returnList = new ArrayList<>();

        // get data from database
        String queryString = "SELECT * FROM " + ROOM_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString, null);

        if(cursor.moveToFirst())
        {
            // loop through cursor and create new RoomModel objects
            // put them into the returnList
            do {
                int roomID = cursor.getInt(0);
                int hotelID = cursor.getInt(1);
                String roomType = cursor.getString(2);
                int roomCapacity = cursor.getInt(3);
                double roomPrice = cursor.getDouble(4);
                boolean roomIsAvailable = cursor.getInt(5) == 1 ? true:false;

                RoomModel newRoom = new RoomModel(roomID, hotelID, roomType, roomCapacity, roomPrice, roomIsAvailable);
                returnList.add(newRoom);

            } while(cursor.moveToNext());
        }
        else
        {
            // Failure: do NOT add anything to the list
        }

        // close cursor and db when done
        cursor.close();
        db.close();
        return returnList;
    }

    /**
     * Gets all the rooms of a specific hotel
     * aka gets all the rooms that have the same hotel id as the target hotelId
     * @param hotelId a hotel id of the target hotel
     * @return all the rooms of a target hotel
     */
    public List<RoomInterface> getAllRoomsByHotel(int hotelId)
    {
        List<RoomInterface> returnList = new ArrayList<>();
        // get data from database
        // String queryString = "SELECT * FROM " + ROOM_TABLE + " WHERE " + COLUMN_HOTEL_ID + " = " + hotelId;

        SQLiteDatabase db = this.getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect = {COLUMN_ROOM_ID, COLUMN_HOTEL_ID, COLUMN_ROOM_TYPE, COLUMN_ROOM_CAPACITY, COLUMN_ROOM_PRICE, COLUMN_AVAILABLE_ROOM};

        qb.setTables(ROOM_TABLE);

        Cursor cursor = qb.query(db, sqlSelect, COLUMN_HOTEL_ID + " = ?", new String[] {String.valueOf(hotelId)},null,null,null);

        if(cursor.moveToFirst())
        {
            // loop through cursor and create new RoomModel objects
            // put them into the returnList
            do {
                int roomID = cursor.getInt(0);
                int hotelID = cursor.getInt(1);
                String roomType = cursor.getString(2);
                int roomCapacity = cursor.getInt(3);
                double roomPrice = cursor.getDouble(4);
                boolean roomIsAvailable = cursor.getInt(5) == 1 ? true:false;

                // put room to the returnList
                RoomModel newRoom = new RoomModel(roomID, hotelID, roomType, roomCapacity, roomPrice, roomIsAvailable);
                returnList.add(newRoom);

            } while(cursor.moveToNext());
        }
        else
        {
            // Failure: do NOT add anything to the list
        }

        // close cursor and db when done
        cursor.close();
        db.close();
        return returnList;
    }

    /**
     * Gets a room that has target  hotel id, room type, availability
     * @param hotelid hotel id
     * @param type room type
     * @param available availability
     * @return a room that has target  hotelid, room type, availability
     */
    public RoomInterface getRoomByHotelId_Type_IsAvailable(int hotelid, String type, boolean available){

        SQLiteDatabase db = this.getWritableDatabase();

        String query = "SELECT * FROM " + ROOM_TABLE + " WHERE " + COLUMN_HOTEL_ID + "='" + hotelid + "' AND "
                + COLUMN_ROOM_TYPE + "='" + type + "'";


        Cursor cursor = db.rawQuery(query, null);

        RoomInterface aRoom;
        if(cursor.moveToNext()){
            int roomID = cursor.getInt(0);
            int hotelID = cursor.getInt(1);
            String roomtype =  cursor.getString(2);
            int capacity = cursor.getInt(3);
            double price = cursor.getDouble(4);
            boolean isAvailable = cursor.getInt(5) == 1 ? true:false;

            aRoom = new RoomModel(roomID, hotelID, roomtype, capacity, price, isAvailable);
        }
        else
        {
            aRoom = new RoomModel(-1, -1, "error", -1, -1, false);
        }
        return aRoom;
    }

    /**
     * Update roomModel isAvailable
     * @param roomModel roomModel to update
     * @param newIsAvailable new availability status
     * @return true if successfully update, false otherwise
     */
    public boolean updateIsAvailable(RoomInterface roomModel, boolean newIsAvailable)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ROOM_TYPE, roomModel.getRoomType());
        cv.put(COLUMN_ROOM_CAPACITY, roomModel.getCapacity());
        cv.put(COLUMN_ROOM_PRICE, roomModel.getPrice());
        cv.put(COLUMN_AVAILABLE_ROOM, newIsAvailable);

        long result = db.update(ROOM_TABLE, cv, COLUMN_ROOM_ID + " = ?", new String[] {String.valueOf(roomModel.getRoomId())} );
        if(result == -1) {
            return false;
        }
        else {
            return true;
        }
    }

    /**
     * Update roomModel's room type
     * @param roomModel to update
     * @param newType new room type
     * @return true if successfully update, false otherwise
     */
    public boolean updateRoomType(RoomInterface roomModel, String newType)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_ROOM_TYPE, newType);
        cv.put(COLUMN_ROOM_CAPACITY, roomModel.getCapacity());
        cv.put(COLUMN_ROOM_PRICE, roomModel.getPrice());
        cv.put(COLUMN_AVAILABLE_ROOM, roomModel.isAvailable());

        long result = db.update(ROOM_TABLE, cv, COLUMN_ROOM_ID + " = ?", new String[] {String.valueOf(roomModel.getRoomId())} );
        if(result == -1) {
            return false;
        }
        else {
            return true;
        }
    }
}

package com.example.ibooking;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.ibooking.Common.Common;
import com.example.ibooking.Model.RoomModel;
import com.example.ibooking.Model.UserModel;

/**
 * Create a user data base
 * Storing user id, name , email , password
 * Handling user's transaction regarding of users.
 */
public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "USER_RECORD.db";
    private static final String TABLE_NAME = "USER_DATA";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "USERNAME";
    private static final String COL_3 = "EMAIL";
    private static final String COL_4 = "PASSWORD";
    /**
     * Constructs a DatabaseHelper for users
     * @param context use for locating paths to the database
     */
    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME , null, 1);
    }
    /**
     * Create a user database that store name, email , and password.
     * Assign user's id in increment order.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT , USERNAME TEXT , EMAIL TEXT , PASSWORD TEXT )");

    }
    /**
     * Check if the database already existed.
     * Prevent users from creating a duplicate.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
    /**
     * Create a method to collect user inputs for username,email, password.
     * Assigning these variable into user's database.
     * @return true or false base on whether user's input is store successfully in the database.
     */
    public boolean registerUser(String username , String email , String password){

        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COL_2 , username);
        values.put(COL_3 , email);
        values.put(COL_4 , password);

        long result = db.insert(TABLE_NAME , null , values);
        if(result == -1)
            return false;
        else
            return true;
    }
    /**
     * Compare user's input for  username and password to the database.
     *@return true or false based on user's input
     */
    public boolean checkUser(String username , String password){

        SQLiteDatabase db = this.getWritableDatabase();
        String [] col = { COL_1 };
        String sel = COL_2 + "=?" + " and " + COL_4 + "=?";
        String [] nargs = { username , password};
        Cursor cursor = db.query(TABLE_NAME , col , sel ,nargs , null , null , null);
        int count = cursor.getCount();
        db.close();
        cursor.close();
        if (count > 0)
            return true;
        else
            return false;

    }

    /**
     * Searches and gets a user with the target username in the table
     * @param username target username
     * @return a user with the target username
     */
    public UserModel getUserByUsername(String username){

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "SELECT * FROM " + TABLE_NAME + " WHERE USERNAME='" + username + "'";
        Cursor cursor = db.rawQuery(query, null);
        UserModel aUser;
        if(cursor.moveToNext()){
            int id = cursor.getInt(0);
            String uname = cursor.getString(1);
            String email = cursor.getString(2);
            String password = cursor.getString(3);
            aUser = new UserModel(id, uname, email, password, "15416431354");
        }
        else
        {
            aUser = new UserModel(-1, "error", "error", "error", "error");
        }

        return aUser;
    }
}

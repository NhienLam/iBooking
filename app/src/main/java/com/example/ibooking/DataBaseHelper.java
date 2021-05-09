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

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "USER_RECORD.db";
    private static final String TABLE_NAME = "USER_DATA";
    private static final String COL_1 = "ID";
    private static final String COL_2 = "USERNAME";
    private static final String COL_3 = "EMAIL";
    private static final String COL_4 = "PASSWORD";

    public DataBaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME , null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS "+TABLE_NAME + "(ID INTEGER PRIMARY KEY AUTOINCREMENT , USERNAME TEXT , EMAIL TEXT , PASSWORD TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

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
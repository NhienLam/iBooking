package main.java.com.ibooking.Model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.time.LocalDate;
import java.util.ArrayList;

import static java.time.LocalDate.parse;

package com.ibooking.Model;

public class UserDatabaseHelper extends SQLiteOpenHelper  {


    private static final String USER_TABLE ="USER_TABLE" ;
    private static final String COLUMN_ID = "ID";
    private static final String COLUMN_USER_EMAIL = "USER_EMAIL";
    private static final String COLUMN_USER_PHONE = "USER_PHONE";
    private static final String COLUMN_USER_NAME = "USER_NAME";
    private static final String COLUMN_USER_PASSWORD = "USER_PASSWORD";

    public UserDatabaseHelper(Context context) {
        super(context, "user.db",null , 1);
    }
    public void onCreate(SQLiteDatabase db)
    {
        String createTableStatement = "CREATE TABLE " + USER_TABLE + " ("
                +COLUMN_ID + "INT PRIMARY KEY AUTOINCREMENT, "
                + COLUMN_USER_NAME + " TEXT, "
                + COLUMN_USER_EMAIL + " TEXT, "
                + COLUMN_USER_PHONE + " TEXT, "
                + COLUMN_USER_PASSWORD + " TEXT)";

        db.execSQL(createTableStatement);

    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean createAccount(UserModel userModel){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_USER_NAME, userModel.getUserName());
        cv.put(COLUMN_USER_EMAIL, userModel.getUserEmail());
        cv.put(COLUMN_USER_PHONE, userModel.getUserPhone());
        cv.put(COLUMN_USER_PASSWORD, userModel.getUserPassword());
        long insert = db.insert(USER_TABLE, null, cv);
        if(insert == -1) {
            return false;
        }
        else {
            return true;
        }
    }
    public boolean deleteHotel(UserModel userModel){
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + USER_TABLE + " WHERE " + COLUMN_ID + " = " + userModel.getId();

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
    public boolean deleteUser(UserModel userModel) {
        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + USER_TABLE + " WHERE " + COLUMN_ID + " = " + userModel.getId();

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
public ArrayList<UserModel> getUsers()
{
    ArrayList<UserModel> list = new ArrayList<>();
    String queryString = "SELECT * FROM " + USER_TABLE;
    SQLiteDatabase db = this.getReadableDatabase();
    Cursor cursor = db.rawQuery(queryString, null);
    if(cursor.moveToFirst())
    {
        do {
            int id = cursor.getInt(0);
            String userName = cursor.getString(1);
            String userEmail = cursor.getString(2);
            String userPhone = cursor.getString(3);
            String userPassword = cursor.getString(4);
            UserModel user = new UserModel(id, userName, userEmail, userPhone, userPassword);
        list.add(user);

        } while(cursor.moveToNext());
    }
    else
    {

    }
    cursor.close();
    db.close();
    return list;
}

}



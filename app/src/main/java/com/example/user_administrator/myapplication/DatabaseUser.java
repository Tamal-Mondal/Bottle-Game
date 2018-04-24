package com.example.user_administrator.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by User-Administrator on 3/27/2018.
 */

public class DatabaseUser extends SQLiteOpenHelper{

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "UserDB";
    public static final String TABLE_NAME = "User";
    public static final String COLUMN_1 = "Name";
    public static final String COLUMN_2 = "Email";
    public static final String COLUMN_3 = "Phone";
    public static final String COLUMN_4 = "Pass";

    public DatabaseUser(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE "+TABLE_NAME+" ( "+COLUMN_1+" TEXT,"+COLUMN_2+" TEXT PRIMARY KEY,"+COLUMN_3+" TEXT,"+COLUMN_4+" TEXT)";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        String sql = "DROP TABLE IF EXISTS "+TABLE_NAME;
        db.execSQL(sql);
        onCreate(db);
    }

    public boolean checkLogin(String user,String pass) {
        SQLiteDatabase db = this.getReadableDatabase();
        String sql = "SELECT * from " + TABLE_NAME + " where " + COLUMN_2 + "='" + user + "' and " + COLUMN_4 + "='" + pass + "'";
        //select * from UserDB where Email='abc' and Password='123'
        Cursor cur = db.rawQuery(sql, null);
        if (cur.moveToFirst()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean register(String name,String user,String phone,String pass){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_1,name);
        values.put(COLUMN_2,user);
        values.put(COLUMN_3,phone);
        values.put(COLUMN_4,pass);
        if(db.insert(TABLE_NAME,null,values)>0){
            return true;
        }
        else{
            return false;
        }
    }
}

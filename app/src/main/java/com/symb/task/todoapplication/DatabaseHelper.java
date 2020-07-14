package com.symb.task.todoapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "database.word";
    private static final String TABLE_NAME = "table_word";

    public DatabaseHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table table_word " +
                "(ID INTEGER PRIMARY KEY AUTOINCREMENT,WORD TEXT,datetime default current_timestamp)  ");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS table_word");
        onCreate(sqLiteDatabase);
    }

    public boolean insertData(String word){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("WORD" ,word );
        long result = sqLiteDatabase.insert(TABLE_NAME,null,contentValues);
        if (result == -1)
        {return false;}
        else {
            return true;
        }
    }

    public Cursor getAllData(){
        SQLiteDatabase sqLiteDatabase =this.getWritableDatabase();
        Cursor res = sqLiteDatabase.rawQuery("select * from table_word",null);
        return res;
    }

}

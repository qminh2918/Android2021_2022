package com.example.examplesqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    private  static  final  String DB_NAME ="J2021";
    private  static  final  int DB_VERSION=1;
    private  static DBHelper instance= null;

    public DBHelper( Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public synchronized static  DBHelper getInstance(Context context) {
        if(instance == null)
            instance = new DBHelper(context);
        return  instance;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        //goi 1 lan duy nhat 1 lan khi cai dat app
    db.execSQL(NewsModify.SQL_CREATE_TABLE); //Tao CSDL

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    //moi lan nang cap CSDL thi se goi vao day

    }
}

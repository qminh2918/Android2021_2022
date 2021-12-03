package com.example.examplesqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class NewsModify {
    public  static final  String SQL_CREATE_TABLE ="create table news (\n"+
        "id interger primary key autoincrement, \n" +
            "title varchar(200), \n" +
            "thumbnail varchar(200), \n" +
            "description text \n" + ")";

    public  static  void  insert(News news) {
        SQLiteDatabase sqLiteDatabase = DBHelper.getInstance(null).getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", news.getTitle());
        contentValues.put("description", news.getDescription());
        sqLiteDatabase.insert("news",null,contentValues);
    }

    public static List<News> getNewsList() {
        List<News> newsList = new ArrayList<>();
        SQLiteDatabase sqLiteDatabase = DBHelper.getInstance(null).getWritableDatabase();
        String sql = "select * from news";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        while(cursor.moveToNext()) {
            News news = new News(cursor.getInt(cursor.getColumnIndex("id")) ,
                    cursor.getString(cursor.getColumnIndex("thumbnail")),
                    cursor.getString(cursor.getColumnIndex("title")),
                    cursor.getString(cursor.getColumnIndex("description")));
            newsList.add(news);
        }
        return  newsList;
    }
    public static  void  delete(int id) {
        SQLiteDatabase sqLiteDatabase = DBHelper.getInstance(null).getWritableDatabase();
        sqLiteDatabase.delete("news", "id =" +id, null);

    }
}

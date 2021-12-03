package com.example.damquangminh_dhmt12a1hn;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import org.json.JSONException;

import java.sql.SQLException;
import java.util.ArrayList;

public class HanghoaAdapter {
    static ArrayList<HanghoaModel> users=new ArrayList<>();
    static final String DATABASE_NAME = "qlhh.db";
    static final String TABLE_NAME = "hanghoa";
    static final int DATABASE_VERSION = 1;
    // SQL Statement to create a new database.
    static final String DATABASE_CREATE = "create table "+TABLE_NAME+"( ID integer primary key autoincrement,name  text,quantity  text); ";
    private static final String TAG = "HanghoaAdapter";

    // Variable to hold the database instance
    public static SQLiteDatabase db;
    // Context of the application using the database.
    private final Context context;
    // Database open/upgrade helper
    private static DataBaseHelper dbHelper;
    public  HanghoaAdapter(Context _context)
    {
        context = _context;
        dbHelper = new DataBaseHelper(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Method to open the Database
    public  HanghoaAdapter open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }

    // Method to close the Database
    public void close()
    {
        db.close();
    }

    // method returns an Instance of the Database
    public  SQLiteDatabase getDatabaseInstance()
    {
        return db;
    }

    // method to insert a record in Table
    public String insertEntry(String name, String quantity)
    {

        try {


            ContentValues newValues = new ContentValues();
            // Assign values for each column.
            newValues.put("name", name);
            newValues.put("quantity", quantity);

            // Insert the row into your table
            db = dbHelper.getWritableDatabase();
            long result=db.insert(TABLE_NAME, null, newValues);
            Log.i("Row Insert Result ", String.valueOf(result));
            Utils.showToast(this.context.getApplicationContext(), "User Info Saved! Total Row Count is "+getRowCount());
            db.close();

        }catch(Exception ex) {
        }
        return "ok";
    }

    // method to get all Rows Saved in Table
    public static ArrayList<HanghoaModel> getRows() throws JSONException {

        users.clear();
        HanghoaModel hh;
        db=dbHelper.getReadableDatabase();
        Cursor projCursor = db.query(TABLE_NAME, null, null,null, null, null, null,null);
        while (projCursor.moveToNext()) {

            hh=new HanghoaModel();
            hh.setID(projCursor.getString(projCursor.getColumnIndexOrThrow("ID")));
            hh.setName(projCursor.getString(projCursor.getColumnIndexOrThrow("name")));
            hh.setQuantity(projCursor.getString(projCursor.getColumnIndexOrThrow("quantity")));
            users.add(hh);
        }
        projCursor.close();
        return users;
    }

    // method to delete a Record in Tbale using Primary Key Here it is ID
    public int deleteEntry(String ID)
    {
        String where="ID=?";
        int numberOFEntriesDeleted= db.delete(TABLE_NAME, where, new String[]{ID}) ;
        Toast.makeText(this.context.getApplicationContext(),"Number fo Entry Deleted Successfully : "+numberOFEntriesDeleted, Toast.LENGTH_SHORT).show();
        return numberOFEntriesDeleted;
    }

    // method to get Count of Toatal Rows in Table
    public int getRowCount()
    {
        db=dbHelper.getReadableDatabase();
        Cursor cursor=db.query(TABLE_NAME, null, null, null, null, null, null);
        Toast.makeText(this.context.getApplicationContext(),"Row Count is "+cursor.getCount(),Toast.LENGTH_LONG).show();
        db.close();
        return cursor.getCount();
    }

    // method to Truncate/ Remove All Rows in Table
    public void truncateTable()
    {
        db=dbHelper.getReadableDatabase();
        db.delete(TABLE_NAME, "1", null);
        db.close();
        Toast.makeText(context.getApplicationContext(),"Table Data Truncated!",Toast.LENGTH_LONG).show();
    }

    // method to Update an Existing Row in Table
    public void  updateEntry(String ID,String name, String quantity)
    {
        ContentValues updatedValues = new ContentValues();
        updatedValues.put("name", name);
        updatedValues.put("quantity", quantity);
        String where="ID = ?";
        db=dbHelper.getReadableDatabase();
        db.update(TABLE_NAME,updatedValues, where, new String[]{ID});
        db.close();
        Toast.makeText(context.getApplicationContext(),"Row Updated!",Toast.LENGTH_LONG).show();
    }
}

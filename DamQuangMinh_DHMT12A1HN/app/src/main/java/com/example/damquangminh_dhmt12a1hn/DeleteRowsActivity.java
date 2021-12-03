package com.example.damquangminh_dhmt12a1hn;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import org.json.JSONException;

import java.util.ArrayList;

public class DeleteRowsActivity extends AppCompatActivity {
    ListView listView ;
    ArrayList<HanghoaModel> hanghoa=new ArrayList<>();
    static CustomListAdapterDeleteRows deleteAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_rows);
        try {
            HanghoaAdapter hanghoaDB = new HanghoaAdapter(getApplicationContext());
            hanghoa = hanghoaDB.getRows();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        deleteAdapter = new CustomListAdapterDeleteRows(this, hanghoa);
        listView = (ListView) findViewById(R.id.listviewdeleteID);
        listView.setAdapter(deleteAdapter);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Delete Hàng hóa from SQLite");
        }
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }
}
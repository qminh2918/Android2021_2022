package com.example.damquangminh_dhmt12a1hn;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import org.json.JSONException;

import java.util.ArrayList;

public class UpdateRowsActivity extends AppCompatActivity {
    static ListView listView ;
    ArrayList<HanghoaModel> hanghoa=new ArrayList<>();
    static CustomListAdapterUpdateRows updateAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_rows);

        try {
            HanghoaAdapter hanghoaDB = new HanghoaAdapter(getApplicationContext());
            hanghoa = hanghoaDB.getRows();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        updateAdapter = new CustomListAdapterUpdateRows(this, hanghoa);
        listView = (ListView) findViewById(R.id.listupdateviewID);
        listView.setAdapter(updateAdapter);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Update Hàng hóa");
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
package com.example.damquangminh_dhmt12a1hn;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class InsertRowActivity extends AppCompatActivity {
    private TextView name;
    private TextView quantity;
    private Button insertRowFrom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_row);

        insertRowFrom = (Button) findViewById(R.id.insertRowFrom);
        name = (TextView) findViewById(R.id.nameTxt);
        quantity = (TextView) findViewById(R.id.quantityTxt);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setTitle("Insert Hàng hóa");
        }
    }
    public void insertRow(View view) {

        TextView nameTxtView = findViewById(R.id.nameTxt);
        TextView quantityTxtView = findViewById(R.id.quantityTxt);

        if(nameTxtView.getText().toString().trim().equals("")
                || nameTxtView.getText().toString().trim().equals("")){
            Utils.showToast(InsertRowActivity.this, "Please Fill All Fields ");
        }else{
            HanghoaAdapter hanghoaDB = new HanghoaAdapter(getApplicationContext());
            hanghoaDB.insertEntry(nameTxtView.getText().toString().trim(),quantityTxtView.getText().toString());
            Intent myIntent = new Intent(InsertRowActivity.this, MainActivity.class);
            InsertRowActivity.this.startActivity(myIntent);
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
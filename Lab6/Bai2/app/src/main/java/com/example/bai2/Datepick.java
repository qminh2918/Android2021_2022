package com.example.bai2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class Datepick extends AppCompatActivity {

    Button  btnCancel, btnOk;
    DatePicker dp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.date_pick_layout);

        btnCancel = (Button) findViewById(R.id.dp_cancel);
        btnOk = (Button) findViewById(R.id.dp_ok);

        dp = (DatePicker) findViewById(R.id.dp_date);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentDate = new Intent(Datepick.this, MainActivity.class);
                startActivity(intentDate);
            }
        });


        final String ngay;

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    int year = dp.getYear();
                    int month = dp.getMonth() + 1; // 0 - 11
                    int day = dp.getDayOfMonth();

                Calendar calendar = Calendar.getInstance();
                calendar.set(year, month, day);

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String dateString = sdf.format(calendar);
                Toast.makeText(Datepick.this, "date: " + dateString,Toast.LENGTH_LONG).show();
            }
        });
    }
}

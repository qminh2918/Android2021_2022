package com.example.bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    List<NhanVien> listNhanvien = new ArrayList<NhanVien>();
    ListView mList;
    Button btnAdd, btnDate;
    EditText edtName, edtBirthday, edtEmail;
    DatePickerDialog picker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtName = (EditText) findViewById(R.id.edt_name);
        edtBirthday = (EditText) findViewById(R.id.edt_birthday);
        edtEmail = (EditText) findViewById(R.id.edt_email);

        btnAdd = (Button) findViewById(R.id.btn_add);

        btnDate = (Button) findViewById(R.id.btn_date);
        mList = (ListView) findViewById(R.id.list);



        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                edtBirthday.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NhanVien nv = new NhanVien();
                nv.setName(edtName.getText());
                nv.setNgaysinh(edtBirthday.getText());
                nv.setEmail(edtEmail.getText());
                listNhanvien.add(nv);
                edtName.setText("");
                edtBirthday.setText("");
                edtEmail.setText("");

            }
        });
        AdapterNV adapter = new AdapterNV(MainActivity.this, R.layout.item_nhanvien_layout,
                listNhanvien);
        mList.setAdapter(adapter);

        //6. xử lý sự kiện Long click
        mList.setOnItemLongClickListener(new AdapterView
                .OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
                                           int arg2, long arg3) {
                listNhanvien.remove(arg2);//xóa phần tử thứ arg2
                adapter.notifyDataSetChanged();
                return false;
            }
        });


    }
}
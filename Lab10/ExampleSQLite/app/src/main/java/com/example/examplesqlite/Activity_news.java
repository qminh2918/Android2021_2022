package com.example.examplesqlite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Activity_news extends AppCompatActivity {
ListView listView;
List<News> datalist = new ArrayList<>();
NewsAdapter newsAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        DBHelper.getInstance(this);
        listView = findViewById(R.id.an_listview);
        //tao du lieu
        datalist = NewsModify.getNewsList();
        newsAdapter = new NewsAdapter(this,datalist);
        listView.setAdapter(newsAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_news_app, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public  boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch (item.getItemId()) {
            case R.id.mna_add_news:
                showNewsDialog();
                break;
            case R.id.mna_exit:
                finish();
                break;
        }
        return  super.onOptionsItemSelected(item);
    }
    public  void  showNewsDialog() {
        View v = LayoutInflater.from(this).inflate(R.layout.dialog_news, null);
        EditText tieude = v.findViewById(R.id.dn_title);
        EditText mota = findViewById(R.id.dn_description);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(v);
        builder.setPositiveButton("SAVE NEWS", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Activity_news.this, "cancel", Toast.LENGTH_SHORT).show();
                String title = tieude.getText().toString();
                String des = mota.getText().toString();
                News news = new News(title, des);
                datalist.add(news);
                newsAdapter.notifyDataSetChanged();
                NewsModify.insert(news);
            }
        }).setNegativeButton("Dismiss", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(Activity_news.this, "Exit", Toast.LENGTH_SHORT).show();
            }
        }).show();
    }
}
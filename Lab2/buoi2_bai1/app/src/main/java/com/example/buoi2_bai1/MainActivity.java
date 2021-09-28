package com.example.buoi2_bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    List<SV> datalist = new ArrayList<>();
    SVAdapter svAdapter;
    int currentIndex =-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sv);
        listView = findViewById(R.id.list_view);
        datalist.add(new SV(R.drawable.uk,"John","09876542"));
        datalist.add(new SV(R.drawable.swizerland,"Lewaski","012345678"));
        svAdapter = new SVAdapter(this, datalist);
        listView.setAdapter(svAdapter);
        registerForContextMenu(listView);
    }
}
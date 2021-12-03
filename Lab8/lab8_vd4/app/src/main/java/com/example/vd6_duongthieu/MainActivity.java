package com.example.vd6_duongthieu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button play, stop;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initControl();
        initEvent();
    }
    private void initEvent() {
        Intent playMusic = new Intent(MainActivity.this, MusicService.class);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playMusic = new Intent(MainActivity.this, MusicService.class);
                startService(playMusic);// Gọi hàm bắt đầu service
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playMusic = new Intent(MainActivity.this, MusicService.class);
                stopService(playMusic);
            }
        });
    }
    private void initControl() {
        play = (Button) findViewById(R.id.play);
        stop = (Button) findViewById(R.id.stop);
    }

}
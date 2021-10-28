package com.example.lab72;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Environment;
import android.view.View;
import android.widget.SeekBar;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {


    private VideoView videoView;
    private SeekBar seekBar;
    private String MEDIA_PATH = Environment.getExternalStorageDirectory().getPath() + "/Download/Sample_Videos2.mp4";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, PackageManager.PERMISSION_GRANTED);

        videoView = findViewById(R.id.videoView);
        seekBar = findViewById(R.id.seekBar2);

        videoView.setVideoPath(MEDIA_PATH);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                seekBar.setMax(videoView.getDuration());
            }
        });

    }

    public void PlayButton(View view){

        if(videoView.isPlaying())
        {
            videoView.resume();
        }
        else{
            videoView.start();
        }

        new CountDownTimer(videoView.getDuration(),1){

            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onTick(long l) {
                seekBar.setProgress(videoView.getCurrentPosition(),true);
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }

    public void PauseButton(View view){
        videoView.pause();

    }
    public void RestartButton(View view){
        videoView.stopPlayback();
        videoView.setVideoPath(MEDIA_PATH);
        videoView.start();;


    }
    public void StopButton(View view){
        videoView.stopPlayback();
        videoView.setVideoPath(MEDIA_PATH);
    }

}
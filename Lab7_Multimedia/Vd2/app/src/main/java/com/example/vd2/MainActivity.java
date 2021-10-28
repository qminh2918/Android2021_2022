package com.example.vd2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;
    private int position = 0;
    private MediaController mediaController;
    private Button buttonRaw;
    private Button buttonLocal;
    private Button buttonURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.videoView = (VideoView) findViewById(R.id.videoView);
        this.buttonRaw = (Button) findViewById(R.id.button_raw);
        this.buttonLocal = (Button) findViewById(R.id.button_local);
        this.buttonURL = (Button) findViewById(R.id.button_url);
        if (this.mediaController == null) {
            this.mediaController = new MediaController(MainActivity.this);
            this.mediaController.setAnchorView(videoView);
            this.videoView.setMediaController(mediaController);
        }
        this.videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            public void onPrepared(MediaPlayer mediaPlayer) {
                videoView.seekTo(position);
                if (position == 0) {
                    videoView.start();
                }
                mediaPlayer.setOnVideoSizeChangedListener(new MediaPlayer.OnVideoSizeChangedListener() {
                    @Override
                    public void onVideoSizeChanged(MediaPlayer mp, int width, int height) {
                        mediaController.setAnchorView(videoView);
                    }
                });
            }
        });
        this.buttonRaw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String resName = VideoViewUtils.RAW_VIDEO_SAMPLE;
                VideoViewUtils.playRawVideo(MainActivity.this, videoView, resName);
            }
        });
        this.buttonLocal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String localPath = VideoViewUtils.LOCAL_VIDEO_SAMPLE;
                VideoViewUtils.playLocalVideo(MainActivity.this, videoView, localPath);
            }
        });
        this.buttonURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String videoURL = VideoViewUtils.URL_VIDEO_SAMPLE;
                VideoViewUtils.playURLVideo(MainActivity.this, videoView, videoURL);
            }
        });
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("CurrentPosition", videoView.getCurrentPosition());
        videoView.pause();
    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        position = savedInstanceState.getInt("CurrentPosition");
        videoView.seekTo(position);
    }
}

package com.example.vd6_duongthieu;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MusicService extends Service { // Kế thừa lớp Service và implement những phương thức cần có của lớp
    String tag = "MusicService";
    MediaPlayer mp;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    // Override phương thức onCreate
    @Override
    public void onCreate() {
        super.onCreate();
        mp = MediaPlayer.create(getApplicationContext(), R.raw.song);// Khởi tạo trình chơi nhạc mặc định của Android với hai đối số là Context và id của bài hát được đặt trong thư mục raw
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //Override lai phuowng thuc onStartCommand  tại đây bạn sẽ viết các sử lý cho tác vị của mình.
        mp.start();// Bắt đầu chơi nhạc
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        // Override onDestroy tại đây bạn sẽ viết xử lý khi tiến trình bị hủy
        super.onDestroy();
        mp.release();// Dừng chơi nhạc
    }
}


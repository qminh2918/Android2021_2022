package com.example.vd5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button Xem;
    private TextView Thoitiet;
    private EditText Diadiem;
    private boolean binded = false;
    private WeatherService weatherService;
    ServiceConnection weatherServiceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            WeatherService.LocalWeatherBinder binder = (WeatherService.LocalWeatherBinder) service;// Binding Service
            weatherService = binder.getService();// Lấy dịch vụ
            binded = true;
        }
        @Override
        public void onServiceDisconnected(ComponentName componentName) {
// Ham này được chạy khi ngắt kết nối đên Service
            binded = false;
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Xem = (Button) findViewById(R.id.btn_xem);
        Thoitiet = (TextView) findViewById(R.id.lbl_thoitiet);
        Diadiem = (EditText) findViewById(R.id.txt_diadiem);
        Xem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location = Diadiem.getText().toString();
                String weather= weatherService.getWeatherToday(location);
                // Lấy thông tin thời tiết
                Thoitiet.setText(weather);
            }
        });
    }
    // Khi Activity start.
    @Override
    protected void onStart() {
        super.onStart();
        // Tạo đối tượng Intent cho WeatherService.
        Intent intent = new Intent(this, WeatherService.class);
        // Gọi method bindService(..) để ràng buộc dịch vụ với giao diện.
        this.bindService(intent, weatherServiceConnection, Context.BIND_AUTO_CREATE);
    }
    // Khi Activity ngừng hoạt động.
    @Override
    protected void onStop() {
        super.onStop();
        if (binded) {
            // Hủy giàng buộc kết nối với dịch vụ.
            this.unbindService(weatherServiceConnection);
            binded = false;
        }
    }
}

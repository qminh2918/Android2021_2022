package com.example.vd5;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class WeatherService extends Service {
    private static String LOG_TAG = "WeatherService";
    // Tạo một mảng kiểu Map để lưu trữ dữ liệu thời tiết.
    private static final Map<String, String> weatherData = new HashMap<String,String>();
    private final IBinder binder = new LocalWeatherBinder();
    // Tạo một biến kiểu IBinder
    public class LocalWeatherBinder extends Binder {
        // Tạo một lớp kế thừa lớp Binder
        public WeatherService getService()  {
            // Đây là hàm gọi service nso sẽ trả về WeatherService
            return WeatherService.this;
        }
    }
    public WeatherService() {
    }
    @Override
    public IBinder onBind(Intent intent) {
        Log.i(LOG_TAG,"onBind");
        return this.binder;
    }
    @Override
    public void onRebind(Intent intent) {
        Log.i(LOG_TAG, "onRebind");
        super.onRebind(intent);
    }
    @Override
    public boolean onUnbind(Intent intent) {
        Log.i(LOG_TAG, "onUnbind");
        return true;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(LOG_TAG, "onDestroy");
    }
    // Trả về thông tin thời tiết ứng với địa điểm của ngày hiện tại.
    public String getWeatherToday(String location) {
        Date now= new Date();
        DateFormat df= new SimpleDateFormat("dd-MM-yyyy");
        String dayString = df.format(now);//Lấy ngày hôm nay
        String keyLocAndDay = location + "$"+ dayString;
        String weather=  weatherData.get(keyLocAndDay);// lấy gia trj thởi tiết
//Kiểm tra xem weather có null hay không nếu không null trả vẻ weather.
        if(weather != null)  {
            return weather;
        }
//Tạo một mảng các giá trị về trạng thái thời tiết như nóng, lạnh.....
        String[] weathers = new String[]{"Rainy", "Hot", "Cool", "Warm" ,"Snowy"};
        // Giá trị ngẫu nhiên từ 0 tới 4
        int i= new Random().nextInt(5);
        weather =weathers[i];
        weatherData.put(keyLocAndDay, weather);
        return weather;
    }
}

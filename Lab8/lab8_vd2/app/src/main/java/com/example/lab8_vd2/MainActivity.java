package com.example.lab8_vd2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void checkBatteryState(View sender) {
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        Intent batteryStatus = registerReceiver(null, filter);
        int chargeState = batteryStatus.getIntExtra( BatteryManager.EXTRA_STATUS, -1);
        String strState;
        switch (chargeState) {
            case BatteryManager.BATTERY_STATUS_CHARGING:
            case BatteryManager.BATTERY_STATUS_FULL:
                strState = "charging";
                break;
            default:
                strState = "not charging";
        }
        TextView tv = (TextView) findViewById(R.id.textView); tv.setText(strState);
    }

}
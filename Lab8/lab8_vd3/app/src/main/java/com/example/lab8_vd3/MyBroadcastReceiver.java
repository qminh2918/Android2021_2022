package com.example.lab8_vd3;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent){
        String mess = intent.getExtras().getString("bm");
        Toast.makeText(context,mess,Toast.LENGTH_LONG).show();
    }

}

package com.example.lab53;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button buttonOpenURL;
    private Button buttonOpenDial;
    private Button buttonSendSms;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.buttonOpenURL = (Button) this.findViewById(R.id.bws);
        this.buttonOpenDial = (Button) this.findViewById(R.id.call);
        this.buttonSendSms = (Button) this.findViewById(R.id.sms);
        this.buttonOpenURL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openURL();
            }
        });
        this.buttonSendSms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendsms();
            }
        });
        this.buttonOpenDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                opendial();
            }
        });
    }
    public void sendsms( )  {
        Uri uri = Uri.parse("smsto:+84123456789");
        Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
        intent.putExtra("sms_body", "The SMS text");
        startActivity(intent);
    }
    public void openURL( )  {
        String url="https://google.com";
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        this.startActivity(intent);
    }
    public void opendial( )  {
        String phone = "+84123456789";
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
        startActivity(intent);
    }
}
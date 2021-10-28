package com.example.lab34;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    RadioButton ra,rb,rc,rd;
    Button test;
    TextView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ra = findViewById(R.id.btn1);
        rb = findViewById(R.id.btn2);
        rc = findViewById(R.id.btn3);
        rd = findViewById(R.id.btn4);
        test = findViewById(R.id.textButton);
        message = findViewById(R.id.textMessage);
        ra.setOnCheckedChangeListener(listener);
        rb.setOnCheckedChangeListener(listener);
        rc.setOnCheckedChangeListener(listener);
        rd.setOnCheckedChangeListener(listener);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(rd.isChecked()){
                    message.setText("Bạn đã làm đúng  ");
                }else{
                    message.setText("Bạn đã làm sai  ");
                }
            }
        });

    }
    CompoundButton.OnCheckedChangeListener listener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
            test.setEnabled(true);
            if(b){
                String s = compoundButton.getText().toString();
                message.setText("Bạn chọn phương án nào là "+s);
            }
        }
    };
}
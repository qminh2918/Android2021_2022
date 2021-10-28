package com.example.numbersquaremin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn;
    EditText so1,so2;
    TextView ketqua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = (Button) findViewById(R.id.btn);
        so1 = (EditText) findViewById(R.id.sothunhat);
        so2 = (EditText) findViewById(R.id.sothuhai);
        ketqua = (TextView) findViewById(R.id.kq);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sothunhat = Integer.parseInt(so1.getText().toString());
                int sothuhai = Integer.parseInt(so2.getText().toString());
                int sonhonhat;
                if(sothunhat>sothuhai){
                    sonhonhat = sothuhai;
                }else{
                    sonhonhat = sothunhat;
                }
                ketqua.setText("So nho nhat là :"+ sonhonhat);

            }
        });
    }
}
package com.example.resultoptions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class songuyento extends AppCompatActivity {
    Button a;
    EditText b;
    TextView c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_songuyento);
        a = findViewById(R.id.btn);
        b = findViewById(R.id.editText);
        c = findViewById(R.id.ketqua);
        int dem = 0;
        int sokt = Integer.parseInt(b.getText().toString());
        if(sokt < 2){
            c.setText(sokt+"KHông phải số nguyên tố ");
        }
        for (int i = 2; i<= Math.sqrt(sokt) ; i++){
            if(sokt %i == 0){
                dem ++;
            }
        }
        if(dem == 0){
            c.setText(sokt+"Là số nguyên tố ");
        }else{
            c.setText(sokt+"KHông phải số nguyên tố ");
        }
    }
}
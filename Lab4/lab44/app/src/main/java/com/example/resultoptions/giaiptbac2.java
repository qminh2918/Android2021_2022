package com.example.resultoptions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class giaiptbac2 extends AppCompatActivity {
    Button gui;
    EditText a,b,c;
    TextView kq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giaiptbac2);
        gui = findViewById(R.id.btn);
        a = findViewById(R.id.editText);
        b = findViewById(R.id.editText1);
        c = findViewById(R.id.editText2);
        kq = findViewById(R.id.ketqua);
        gui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                float so1 =Float.parseFloat(a.getText().toString());
                float so2 =Float.parseFloat(b.getText().toString());
                float so3 =Float.parseFloat(c.getText().toString());
                float delta = (so2*so2)-(4*so1*so3);
                if(so1 == 0){
                    if(so2 == 0 ){
                        kq.setText("Phương trình vô nghiệm ");
                    }else{
                        kq.setText("Phương trình có nghiệm là "+-so3/so2);
                    }
                }else{
                    if(delta > 0){
                        kq.setText("Phương trình có 2 nghiệm phân biệt x1,x2 "
                                +(-(so2)+Math.sqrt(delta))/(2*so1)+(-(so2)-Math.sqrt(delta))/(2*so1));
                    }else if(delta == 0){
                        kq.setText("Phương trình có nghiệm kép "+(-(so2)/(2*so1)));
                    }else{
                        kq.setText("Phương trình vô nghiệm ");
                    }
                }

            }
        });


    }
}
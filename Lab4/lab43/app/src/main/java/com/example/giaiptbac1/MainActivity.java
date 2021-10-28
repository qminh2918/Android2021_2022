package com.example.giaiptbac1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnS;
    EditText edit,edit1;
    TextView kq;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnS = (Button) findViewById(R.id.btn);
        edit = (EditText) findViewById(R.id.editText);
        edit1 = (EditText) findViewById(R.id.editText1);
        kq = (TextView) findViewById(R.id.ketqua);
        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int so1 = Integer.parseInt(edit.getText().toString());
                int so2 = Integer.parseInt(edit1.getText().toString());
                if(so1 == 0){
                    if(so2 ==0){
                        kq.setText("Phương trình vố số nghiệm");
                    }else{
                        kq.setText("Phương trình vô nghiệm với nghiệm phức so1+so2i và so1- so2i ");
                    }
                }else{
                    kq.setText("Phương trình có nghiệm là "+-so2/so1);
                }
            }
        });
    }
}
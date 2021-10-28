package com.example.resultoptions;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class sohoanhao extends AppCompatActivity {
    Button a;
    EditText edit;
    TextView kqua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sohoanhao);
        a = findViewById(R.id.btn);
        edit = findViewById(R.id.editText);
        kqua = findViewById(R.id.kq);
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int sum = 0;
                int so = Integer.parseInt(edit.getText().toString());
                for (int i =1;i<so;i++){
                    if(so % i ==0){
                        sum += i;
                    }
                }
                if(sum == so){
                    kqua.setText(so+"Là số hoàn hảo vì tổng cac ước bằng chính nó  ");
                }else{
                    kqua.setText(so+"Không phải số hoàn hảo ");
                }
            }
        });
    }
}
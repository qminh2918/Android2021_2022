package com.example.sum2numb;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReceiveActivity extends AppCompatActivity {
    TextView txtkq;
    Button btnback;

    @Override
    protected void onCreate(Bundle SaveInstanceState) {
        super.onCreate(SaveInstanceState);
        setContentView(R.layout.receive);
        Bundle re = getIntent().getExtras();
        if (re == null) {
            return;
        }
        int re1 = re.getInt("so1");
        int re2 = re.getInt("so2");
        int re3 = re.getInt("so3");
        int sum = re1+1 + re2 + re3;
        double so1= re1+1;
        double so2= re2;
        double so3= re3;
        double doi=so1+so2+so3;
        double x1,x2,del;
        txtkq = (TextView) findViewById(R.id.txtketqua);
        btnback = findViewById(R.id.btback);
        //txtkq.setText(String.valueOf(doi));
/*        btntong.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                txtkq.setText(String.valueOf(sum));
            }
        });*/
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {finish();  }
        });
        float delta = (float) ((so2*so2)-(4*so1*so3));
        if(so1 == 0){
            if(so2 == 0 ){
                txtkq.setText("Phương trình vô nghiệm ");
            }else{
                txtkq.setText("Phương trình có nghiệm là "+-so3/so2);
            }
        }else{
            if(delta > 0){
                txtkq.setText("Phương trình có 2 nghiệm phân biệt x1,x2 "
                        +(-(so2)+Math.sqrt(delta))/(2*so1)+(-(so2)-Math.sqrt(delta))/(2*so1));
            }else if(delta == 0){
                txtkq.setText("Phương trình có nghiệm kép "+(-(so2)/(2*so1)));
            }else{
                txtkq.setText("Phương trình vô nghiệm ");
            }
        }
        /*txtkq.setText(String.valueOf(sum));

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {finish();  }
        });
    }*/
}
}
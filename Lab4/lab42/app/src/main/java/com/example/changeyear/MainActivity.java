package com.example.changeyear;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnS;
    EditText edit;
    TextView kq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnS = (Button) findViewById(R.id.btn);
        edit = (EditText) findViewById(R.id.editText);
        kq = (TextView) findViewById(R.id.ketqua);
        btnS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // lấy thông tin nhập
                int thongtinnhap = Integer.parseInt(edit.getText().toString());
                int can = thongtinnhap % 10;
                int chi = thongtinnhap % 12;
                if(can == 0){
                    if(chi == 0){
                        kq.setText(thongtinnhap+"Là năm canh thân ");
                    }else if(chi == 1){
                        kq.setText(thongtinnhap+"Là năm canh dậu");
                    }else if(chi == 2){
                        kq.setText(thongtinnhap+"Là năm canh tuất");
                    }else if(chi == 3){
                        kq.setText(thongtinnhap+"Là năm canh hợi");
                    }else if(chi == 4){
                        kq.setText(thongtinnhap+"Là năm canh tý");
                    }else if(chi == 5){
                        kq.setText(thongtinnhap+"Là năm canh sửu");
                    }else if(chi == 6){
                        kq.setText(thongtinnhap+"Là năm canh dần");
                    }else if(chi == 7){
                        kq.setText(thongtinnhap+"Là năm canh mão");
                    }else if(chi == 8){
                        kq.setText(thongtinnhap+"Là năm canh thìn");
                    }else if(chi == 9){
                        kq.setText(thongtinnhap+"Là năm canh tỵ");
                    }else if(chi == 10){
                        kq.setText(thongtinnhap+"Là năm canh ngọ");
                    }else if(chi == 11){
                        kq.setText(thongtinnhap+"Là năm canh mùi");
                    }
                }
                if(can == 1){
                    if(chi == 0){
                        kq.setText(thongtinnhap+"Là năm tân thân ");
                    }else if(chi == 1){
                        kq.setText(thongtinnhap+"Là năm tân dậu");
                    }else if(chi == 2){
                        kq.setText(thongtinnhap+"Là năm tân tuất");
                    }else if(chi == 3){
                        kq.setText(thongtinnhap+"Là năm tân  hợi");
                    }else if(chi == 4){
                        kq.setText(thongtinnhap+"Là năm tân tý");
                    }else if(chi == 5){
                        kq.setText(thongtinnhap+"Là năm tân sửu");
                    }else if(chi == 6){
                        kq.setText(thongtinnhap+"Là năm tân  dần");
                    }else if(chi == 7){
                        kq.setText(thongtinnhap+"Là năm tân mão");
                    }else if(chi == 8){
                        kq.setText(thongtinnhap+"Là năm tân thìn");
                    }else if(chi == 9){
                        kq.setText(thongtinnhap+"Là năm tân tỵ");
                    }else if(chi == 10){
                        kq.setText(thongtinnhap+"Là năm tân ngọ");
                    }else if(chi == 11){
                        kq.setText(thongtinnhap+"Là năm tân mùi");
                    }
                }
                if(can == 2){
                    if(chi == 0){
                        kq.setText(thongtinnhap+"Là năm nhâm thân ");
                    }else if(chi == 1){
                        kq.setText(thongtinnhap+"Là năm nhâm dậu");
                    }else if(chi == 2){
                        kq.setText(thongtinnhap+"Là năm nhâm tuất");
                    }else if(chi == 3){
                        kq.setText(thongtinnhap+"Là năm nhâm hợi");
                    }else if(chi == 4){
                        kq.setText(thongtinnhap+"Là năm nhâm tý");
                    }else if(chi == 5){
                        kq.setText(thongtinnhap+"Là năm nhâm sửu");
                    }else if(chi == 6){
                        kq.setText(thongtinnhap+"Là năm nhâm dần");
                    }else if(chi == 7){
                        kq.setText(thongtinnhap+"Là năm nhâm mão");
                    }else if(chi == 8){
                        kq.setText(thongtinnhap+"Là năm nhâm thìn");
                    }else if(chi == 9){
                        kq.setText(thongtinnhap+"Là năm nhâm tỵ");
                    }else if(chi == 10){
                        kq.setText(thongtinnhap+"Là năm nhâm ngọ");
                    }else if(chi == 11){
                        kq.setText(thongtinnhap+"Là năm nhâm mùi");
                    }
                }
                if(can == 3){
                    if(chi == 0){
                        kq.setText(thongtinnhap+"Là năm quý thân ");
                    }else if(chi == 1){
                        kq.setText(thongtinnhap+"Là năm quý dậu");
                    }else if(chi == 2){
                        kq.setText(thongtinnhap+"Là năm quý tuất");
                    }else if(chi == 3){
                        kq.setText(thongtinnhap+"Là năm quý hợi");
                    }else if(chi == 4){
                        kq.setText(thongtinnhap+"Là năm quý tý");
                    }else if(chi == 5){
                        kq.setText(thongtinnhap+"Là năm quý sửu");
                    }else if(chi == 6){
                        kq.setText(thongtinnhap+"Là năm quý dần");
                    }else if(chi == 7){
                        kq.setText(thongtinnhap+"Là năm quý mão");
                    }else if(chi == 8){
                        kq.setText(thongtinnhap+"Là năm quý thìn");
                    }else if(chi == 9){
                        kq.setText(thongtinnhap+"Là năm quý tỵ");
                    }else if(chi == 10){
                        kq.setText(thongtinnhap+"Là năm quý ngọ");
                    }else if(chi == 11){
                        kq.setText(thongtinnhap+"Là năm quý mùi");
                    }
                }
                if(can == 4){
                    if(chi == 0){
                        kq.setText(thongtinnhap+"Là năm giáp thân ");
                    }else if(chi == 1){
                        kq.setText(thongtinnhap+"Là năm giáp dậu");
                    }else if(chi == 2){
                        kq.setText(thongtinnhap+"Là năm giáp tuất");
                    }else if(chi == 3){
                        kq.setText(thongtinnhap+"Là năm giáp hợi");
                    }else if(chi == 4){
                        kq.setText(thongtinnhap+"Là năm giáp  tý");
                    }else if(chi == 5){
                        kq.setText(thongtinnhap+"Là năm giáp sửu");
                    }else if(chi == 6){
                        kq.setText(thongtinnhap+"Là năm giáp dần");
                    }else if(chi == 7){
                        kq.setText(thongtinnhap+"Là năm giáp mão");
                    }else if(chi == 8){
                        kq.setText(thongtinnhap+"Là năm giáp thìn");
                    }else if(chi == 9){
                        kq.setText(thongtinnhap+"Là năm giáp  tỵ");
                    }else if(chi == 10){
                        kq.setText(thongtinnhap+"Là năm giáp ngọ");
                    }else if(chi == 11){
                        kq.setText(thongtinnhap+"Là năm giáp  mùi");
                    }
                }
                if(can == 5){
                    if(chi == 0){
                        kq.setText(thongtinnhap+"Là năm ất thân ");
                    }else if(chi == 1){
                        kq.setText(thongtinnhap+"Là năm ất dậu");
                    }else if(chi == 2){
                        kq.setText(thongtinnhap+"Là năm ất tuất");
                    }else if(chi == 3){
                        kq.setText(thongtinnhap+"Là năm ất hợi");
                    }else if(chi == 4){
                        kq.setText(thongtinnhap+"Là năm ất tý");
                    }else if(chi == 5){
                        kq.setText(thongtinnhap+"Là năm ất sửu");
                    }else if(chi == 6){
                        kq.setText(thongtinnhap+"Là năm ất dần");
                    }else if(chi == 7){
                        kq.setText(thongtinnhap+"Là năm ất mão");
                    }else if(chi == 8){
                        kq.setText(thongtinnhap+"Là năm ất thìn");
                    }else if(chi == 9){
                        kq.setText(thongtinnhap+"Là năm ất tỵ");
                    }else if(chi == 10){
                        kq.setText(thongtinnhap+"Là năm ẤT ngọ");
                    }else if(chi == 11){
                        kq.setText(thongtinnhap+"Là năm Ất mùi");
                    }
                }
                if(can == 6){
                    if(chi == 0){
                        kq.setText(thongtinnhap+"Là năm Bính thân ");
                    }else if(chi == 1){
                        kq.setText(thongtinnhap+"Là năm Bính  dậu");
                    }else if(chi == 2){
                        kq.setText(thongtinnhap+"Là năm Bính tuất");
                    }else if(chi == 3){
                        kq.setText(thongtinnhap+"Là năm Bính hợi");
                    }else if(chi == 4){
                        kq.setText(thongtinnhap+"Là năm Bính tý");
                    }else if(chi == 5){
                        kq.setText(thongtinnhap+"Là năm Bính sửu");
                    }else if(chi == 6){
                        kq.setText(thongtinnhap+"Là năm Bính dần");
                    }else if(chi == 7){
                        kq.setText(thongtinnhap+"Là năm Bính mão");
                    }else if(chi == 8){
                        kq.setText(thongtinnhap+"Là năm Bính thìn");
                    }else if(chi == 9){
                        kq.setText(thongtinnhap+"Là năm Bính  tỵ");
                    }else if(chi == 10){
                        kq.setText(thongtinnhap+"Là năm Bính ngọ");
                    }else if(chi == 11){
                        kq.setText(thongtinnhap+"Là năm Bính mùi");
                    }
                }
                if(can == 7){
                    if(chi == 0){
                        kq.setText(thongtinnhap+"Là năm Đinh thân ");
                    }else if(chi == 1){
                        kq.setText(thongtinnhap+"Là năm Đinh dậu");
                    }else if(chi == 2){
                        kq.setText(thongtinnhap+"Là năm Đinh tuất");
                    }else if(chi == 3){
                        kq.setText(thongtinnhap+"Là năm Đinh hợi");
                    }else if(chi == 4){
                        kq.setText(thongtinnhap+"Là năm Đinh tý");
                    }else if(chi == 5){
                        kq.setText(thongtinnhap+"Là năm Đinh sửu");
                    }else if(chi == 6){
                        kq.setText(thongtinnhap+"Là năm Đinh dần");
                    }else if(chi == 7){
                        kq.setText(thongtinnhap+"Là năm Đinh mão");
                    }else if(chi == 8){
                        kq.setText(thongtinnhap+"Là năm Đinh thìn");
                    }else if(chi == 9){
                        kq.setText(thongtinnhap+"Là năm Đinh tỵ");
                    }else if(chi == 10){
                        kq.setText(thongtinnhap+"Là năm Đinh ngọ");
                    }else if(chi == 11){
                        kq.setText(thongtinnhap+"Là năm Đinh mùi");
                    }
                }
                if(can == 8){
                    if(chi == 0){
                        kq.setText(thongtinnhap+"Là năm mậu thân ");
                    }else if(chi == 1){
                        kq.setText(thongtinnhap+"Là năm mậu dậu");
                    }else if(chi == 2){
                        kq.setText(thongtinnhap+"Là năm mậu tuất");
                    }else if(chi == 3){
                        kq.setText(thongtinnhap+"Là năm mậu hợi");
                    }else if(chi == 4){
                        kq.setText(thongtinnhap+"Là năm mậu tý");
                    }else if(chi == 5){
                        kq.setText(thongtinnhap+"Là năm mậu sửu");
                    }else if(chi == 6){
                        kq.setText(thongtinnhap+"Là năm mậu dần");
                    }else if(chi == 7){
                        kq.setText(thongtinnhap+"Là năm mậu mão");
                    }else if(chi == 8){
                        kq.setText(thongtinnhap+"Là năm mậu thìn");
                    }else if(chi == 9){
                        kq.setText(thongtinnhap+"Là năm mậu  tỵ");
                    }else if(chi == 10){
                        kq.setText(thongtinnhap+"Là năm mậu ngọ");
                    }else if(chi == 11){
                        kq.setText(thongtinnhap+"Là năm mậu mùi");
                    }
                }
                if(can == 9){
                    if(chi == 0){
                        kq.setText(thongtinnhap+"Là năm Kỷ thân ");
                    }else if(chi == 1){
                        kq.setText(thongtinnhap+"Là năm kỷ dậu");
                    }else if(chi == 2){
                        kq.setText(thongtinnhap+"Là năm kỷ tuất");
                    }else if(chi == 3){
                        kq.setText(thongtinnhap+"Là năm kỷ hợi");
                    }else if(chi == 4){
                        kq.setText(thongtinnhap+"Là năm kỷ tý");
                    }else if(chi == 5){
                        kq.setText(thongtinnhap+"Là năm kỷ sửu");
                    }else if(chi == 6){
                        kq.setText(thongtinnhap+"Là năm kỷ dần");
                    }else if(chi == 7){
                        kq.setText(thongtinnhap+"Là năm kỷ mão");
                    }else if(chi == 8){
                        kq.setText(thongtinnhap+"Là năm kỷ thìn");
                    }else if(chi == 9){
                        kq.setText(thongtinnhap+"Là năm kỷ tỵ");
                    }else if(chi == 10){
                        kq.setText(thongtinnhap+"Là năm kỷ ngọ");
                    }else if(chi == 11){
                        kq.setText(thongtinnhap+"Là năm kỷ mùi");
                    }
                }

            }
        });
    }
}
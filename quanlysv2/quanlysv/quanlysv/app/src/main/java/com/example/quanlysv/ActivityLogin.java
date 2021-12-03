package com.example.quanlysv;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityLogin extends AppCompatActivity {

    EditText edt_login_user, edt_login_pass;
    Button btn_reg, btn_login, btn_exit;
    String ten, mk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);
        AnhXa();
        ControlButton();
    }

    private  void AnhXa() {
        edt_login_user = (EditText)findViewById(R.id.edt_login_user);
        edt_login_pass = (EditText)findViewById(R.id.edt_login_pass);
        btn_login = (Button)findViewById(R.id.btn_login);
        btn_reg = (Button)findViewById(R.id.btn_reg);
        btn_exit = (Button)findViewById(R.id.btn_exit);
    }

    private void ControlButton() {
        btn_exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        btn_reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dialog dialog = new Dialog(ActivityLogin.this);
                dialog.setTitle("Hộp thoại xử lý");
                dialog.setContentView(R.layout.layout_register);
                EditText edt_reg_user = (EditText)dialog.findViewById(R.id.edt_reg_user);
                EditText edt_reg_pass = (EditText)dialog.findViewById(R.id.edt_reg_pass);
                Button btn_huy = (Button)dialog.findViewById(R.id.btn_huy);
                Button btn_dongy = (Button)dialog.findViewById(R.id.btn_dong_y);
                btn_dongy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ten = edt_reg_user.getText().toString().trim();
                        mk = edt_reg_pass.getText().toString().trim();
                        edt_login_user.setText(ten);
                        edt_login_pass.setText(mk);
                        dialog.cancel();
                    }
                });
                btn_huy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.cancel();
                    }
                });
                dialog.show();
            }
        });

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(edt_login_user.getText().length() != 0 && edt_login_pass.getText().length() != 0) {
                    if(edt_login_user.getText().toString().equals(ten) && edt_login_pass.getText().toString().equals(mk)) {
                        Toast.makeText(ActivityLogin.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(ActivityLogin.this,MainActivity.class);
                        startActivity(intent);
                    } else if ((edt_login_user.getText().toString().equals("minh") && edt_login_pass.getText().toString().equals("123"))
                    || edt_login_user.getText().toString().equals("thieu") && edt_login_pass.getText().toString().equals("123")) {
                        Toast.makeText(ActivityLogin.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(ActivityLogin.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(ActivityLogin.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(ActivityLogin.this, "Mời bạn nhập lại thông tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
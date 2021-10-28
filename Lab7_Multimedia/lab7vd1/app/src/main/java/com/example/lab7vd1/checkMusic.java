package com.example.lab7vd1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class checkMusic extends AppCompatActivity {
    EditText a;
    TextView show;
    Button check;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_music);
        a = findViewById(R.id.editMusic);
        show = findViewById(R.id.showResult);
        check = findViewById(R.id.btnCheck);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(checkMusic.this,MainActivity.class);
                String b = a.getText().toString();
                intent.putExtra("Tên bài hát ",b);
                startActivity(intent);
            }
        });
    }
}
package com.example.quanlysv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.quanlysv.R;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class AddActivity extends AppCompatActivity {
    final String DATABASE_NAME="quanly.sqlite";
    final int REQUEST_TAKE_PHOTO=123;
    final int REQUEST_CHOOSE_PHOTO=123;
    String msv=null;

    Button btnChonHinh,btnChupHinh,btnLuu,btnHuy;
    EditText edtMSV,edtTen,edtQue,edtDiem;
    ImageView imgHinhDaiDien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        addControls();
        addEvents();
    }
    private void addControls() {
        btnChonHinh=findViewById(R.id.btnChonHinh);
        btnLuu=findViewById(R.id.btnLuu);
        btnHuy=findViewById(R.id.btnHuy);
        edtMSV=findViewById(R.id.editMSV);
        edtTen=findViewById(R.id.editName);
        edtQue=findViewById(R.id.editQue);
        edtDiem=findViewById(R.id.editDiem);
        imgHinhDaiDien=findViewById(R.id.imgHinhDaiDien);

    }

    private void addEvents(){
        btnChonHinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePhoto();
            }
        });
        btnLuu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insert();
            }
        });
        btnHuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cancel();
            }
        });
    }

    private void choosePhoto(){
        Intent intent=new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,REQUEST_CHOOSE_PHOTO);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CHOOSE_PHOTO) {
                try {
                    Uri imageUri = data.getData();
                    InputStream is = getContentResolver().openInputStream(imageUri);
                    Bitmap bitmap = BitmapFactory.decodeStream(is);
                    imgHinhDaiDien.setImageBitmap(bitmap);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void insert(){
        String msv=edtMSV.getText().toString();
        String ten=edtTen.getText().toString();
        String que=edtQue.getText().toString();
        String diem=edtDiem.getText().toString();
        byte[] anh=getByteArrayFromImageView(imgHinhDaiDien);
        ContentValues contentValues=new ContentValues();
        contentValues.put("MSV",msv);
        contentValues.put("Ten",ten);
        contentValues.put("Que",que);
        contentValues.put("Diem",diem);
        contentValues.put("Anh",anh);
        SQLiteDatabase database=Database.initDatabase(this,DATABASE_NAME);
        database.insert("SinhVien",null,contentValues);
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    private void cancel(){
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
    }
    private byte[] getByteArrayFromImageView(ImageView imgv){

        BitmapDrawable drawable = (BitmapDrawable) imgv.getDrawable();
        Bitmap bmp = drawable.getBitmap();

        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();
        return byteArray;
    }
}
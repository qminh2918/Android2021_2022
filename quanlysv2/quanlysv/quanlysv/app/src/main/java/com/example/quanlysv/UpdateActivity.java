package com.example.quanlysv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
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

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class UpdateActivity extends AppCompatActivity {
    final String DATABASE_NAME="quanly.sqlite";
//    final int REQUEST_TAKE_PHOTO=123;
    final int REQUEST_CHOOSE_PHOTO=123;
    String msv=null;

    Button btnChonHinh,btnLuu,btnHuy;
    EditText edtMSV,edtTen,edtQue,edtDiem;
    ImageView imgHinhDaiDien;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);

        addControls();
        addEvents();
        initUI();

    }

    private void initUI() {
        Intent intent=getIntent();
        msv=intent.getStringExtra("MSV");
        SQLiteDatabase database=Database.initDatabase(this,DATABASE_NAME);
        Cursor c = database.rawQuery("select * from SinhVien where MSV = ? ",new String[]{msv + ""});
        c.moveToFirst();
        String masv=c.getString(0);
        String ten=c.getString(1);
        String que=c.getString(2);
        String diem=c.getString(3);
        byte[] anh=c.getBlob(4);
        Bitmap bitmap= BitmapFactory.decodeByteArray(anh,0,anh.length);
        imgHinhDaiDien.setImageBitmap(bitmap);
        edtMSV.setText(msv);
        edtTen.setText(ten);
        edtQue.setText(que);
        edtDiem.setText(diem);
    }//lay thong tin sinh vien va day len giao dien activity update

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
                update();
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

    private void update(){
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
        database.update("SinhVien",contentValues,"msv=?",new String[]{msv});
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
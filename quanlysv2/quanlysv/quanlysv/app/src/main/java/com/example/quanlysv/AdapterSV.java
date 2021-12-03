package com.example.quanlysv;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.quanlysv.R;

import java.util.ArrayList;

public class AdapterSV extends BaseAdapter {
    Activity context;
    ArrayList<SinhVien> list;

    public AdapterSV(Activity context, ArrayList<SinhVien> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row=inflater.inflate(R.layout.listview_row,null);
        ImageView imgHinhDaiDien=row.findViewById(R.id.imgHinhDaiDien);
        TextView txtMSV=row.findViewById(R.id.txtMSV);
        TextView txtTen=row.findViewById(R.id.txtTen);
        TextView txtQue=row.findViewById(R.id.txtQue);
        TextView txtDiem=row.findViewById(R.id.txtDiem);
        Button btnSua=row.findViewById(R.id.btnSua);
        Button btnXoa=row.findViewById(R.id.btnXoa);

        SinhVien sinhVien=list.get(position);
        txtMSV.setText(sinhVien.msv);
        txtTen.setText(sinhVien.ten);
        txtQue.setText(sinhVien.que);
        txtDiem.setText(sinhVien.diem);
        Bitmap bmHinhDaiDien=BitmapFactory.decodeByteArray(sinhVien.anh,0,sinhVien.anh.length);
        imgHinhDaiDien.setImageBitmap(bmHinhDaiDien);
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context,UpdateActivity.class);
                intent.putExtra("MSV",sinhVien.msv);
                context.startActivity(intent);
            }
        });

        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(context);
                builder.setIcon(android.R.drawable.ic_delete);
                builder.setTitle("Xác nhận xóa");
                builder.setMessage("Bạn chắc chắn muốn xóa sinh viên này?");
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        delete(sinhVien.msv);
                    }
                });
                builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog dialog=builder.create();
                dialog.show();
            }
        });
        return row;
    }

    private void delete(String masv) {
        SQLiteDatabase database=Database.initDatabase(context,"quanly.sqlite");
        database.delete("SinhVien","MSV=?",new String[]{masv});
        list.clear();
        Cursor c=database.rawQuery("select * from SinhVien",null);
        while(c.moveToNext()){
            String msv=c.getString(0);
            String ten=c.getString(1);
            String que=c.getString(2);
            String diem=c.getString(3);
            byte[] anh=c.getBlob(4);
            list.add(new SinhVien(msv,ten,que,diem,anh));
        }
        notifyDataSetChanged();
    }
}

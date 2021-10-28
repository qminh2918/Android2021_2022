package com.example.bai2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterNV extends ArrayAdapter<NhanVien> {
    private Context context; // Nhận truyền vào một activity
    private int resId; // Nhận truyền vào một layout
    private List<NhanVien> listNhanvien; // Nhận truyền vào một
    /* Hàm khởi tạo truyền giá trị cho các biến bên trên */
    public AdapterNV(Context context, int textViewResourceId, List<NhanVien> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.resId = textViewResourceId;
        this.listNhanvien = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) { View
            itemView = convertView;
        ViewHolder viewHolder = new ViewHolder();
        if (itemView == null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); itemView =
                    inflater.inflate(resId, null);
            viewHolder.lbName = (TextView) itemView.findViewById(R.id.tv_name);
            viewHolder.lbNgaysinh = (TextView) itemView.findViewById(R.id.tv_birthday);
            viewHolder.lbEmail = (TextView) itemView.findViewById(R.id.tv_email);
            itemView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) itemView.getTag();
        }
        /*Truyền vào giá trị cho các thành phần giao diện trong item_lab01.xml */
        viewHolder.lbName.setText(listNhanvien.get(position).getName());
        viewHolder.lbNgaysinh.setText(listNhanvien.get(position).getNgaysinh());
        viewHolder.lbEmail.setText("" + listNhanvien.get(position).getEmail());
        return itemView;
    }
    /* Class chứa các thành phần giao diện cần truyền vào giá trị */
    private class ViewHolder {
        TextView lbName;
        TextView lbNgaysinh;
        TextView lbEmail;
    }
}

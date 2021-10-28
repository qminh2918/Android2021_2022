package com.example.vd4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class AdapterTT extends ArrayAdapter<ThoiTiet> {
    private Context context; // Nhận truyền vào một activity
    private int resId; // Nhận truyền vào một layout
    private List<ThoiTiet> listCountry; // Nhận truyền vào một
    /* Hàm khởi tạo truyền giá trị cho các biến bên trên */
    public AdapterTT(Context context, int textViewResourceId, List<ThoiTiet> objects) {
        super(context, textViewResourceId, objects);
        this.context = context;
        this.resId = textViewResourceId;
        this.listCountry = objects;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) { View
            itemView = convertView;
        ViewHolder viewHolder = new ViewHolder();
        if (itemView == null) {
            LayoutInflater inflater = (LayoutInflater)
                    context.getSystemService(Context.LAYOUT_INFLATER_SERVICE); itemView =
                    inflater.inflate(resId, null);
            viewHolder.image = (ImageView) itemView.findViewById(R.id.image);
            viewHolder.lbCountry = (TextView) itemView.findViewById(R.id.country);
            viewHolder.lbDescribe = (TextView) itemView.findViewById(R.id.describe);
            viewHolder.lbCelsius = (TextView) itemView.findViewById(R.id.celsius);
            itemView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) itemView.getTag();
        }
        /*Truyền vào giá trị cho các thành phần giao diện trong item_lab01.xml */
        viewHolder.image.setImageResource(listCountry.get(position).getIntimage());
        viewHolder.lbCountry.setText(listCountry.get(position).getCountry());
        viewHolder.lbDescribe.setText(listCountry.get(position).getDescribe());
        viewHolder.lbCelsius.setText("" + listCountry.get(position).getIntcelsius());
        return itemView;
    }
    /* Class chứa các thành phần giao diện cần truyền vào giá trị */
    private class ViewHolder {
        ImageView image;
        TextView lbCountry;
        TextView lbDescribe;
        TextView lbCelsius;
    }
}

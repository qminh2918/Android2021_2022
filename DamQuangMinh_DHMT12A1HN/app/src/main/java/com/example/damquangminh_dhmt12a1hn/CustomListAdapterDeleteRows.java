package com.example.damquangminh_dhmt12a1hn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomListAdapterDeleteRows extends BaseAdapter {
    Context c;
    ArrayList<HanghoaModel> hanghoa;

    public CustomListAdapterDeleteRows(Context c, ArrayList<HanghoaModel> hh) {
        this.c = c;
        this.hanghoa = hh;
    }

    @Override
    public int getCount() {
        return hanghoa.size();
    }

    @Override
    public Object getItem(int i) {
        return hanghoa.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(final int i, View view, ViewGroup viewGroup) {
        if(view==null)
        {
            view= LayoutInflater.from(c).inflate(R.layout.listviewdelete_row,viewGroup,false);
        }

        TextView mtextView1 = (TextView) view.findViewById(R.id.textView1);
        TextView mtextView2 = (TextView) view.findViewById(R.id.textView2);
        Button deleteBtn = (Button) view.findViewById(R.id.button1);

        final HanghoaModel hh= (HanghoaModel) this.getItem(i);
        mtextView1.setText(hh.getName());
        mtextView2.setText(hh.getQuantity());

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                HanghoaAdapter hanghoaDB = new HanghoaAdapter(c);
                hanghoaDB.deleteEntry(hh.getID());
                hanghoa.remove(i);
                notifyDataSetChanged();
            }
        });

        return view;
    }
}

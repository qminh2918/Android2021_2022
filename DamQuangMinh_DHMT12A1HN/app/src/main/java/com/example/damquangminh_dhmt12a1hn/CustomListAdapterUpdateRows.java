package com.example.damquangminh_dhmt12a1hn;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class CustomListAdapterUpdateRows extends BaseAdapter {
    Context c;
    ArrayList<HanghoaModel> hanghoa;

    public CustomListAdapterUpdateRows(Context c, ArrayList<HanghoaModel> users) {
        this.c = c;
        this.hanghoa = users;
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
            view= LayoutInflater.from(c).inflate(R.layout.listviewupdate_row,viewGroup,false);
        }

        final EditText meditText1 = (EditText) view.findViewById(R.id.editText1);
        final EditText meditText2 = (EditText) view.findViewById(R.id.editText2);
        Button updateBtn = (Button) view.findViewById(R.id.updateBtn);

        final HanghoaModel hh= (HanghoaModel) this.getItem(i);
        meditText1.setText(hh.getName());
        meditText2.setText(hh.getQuantity());

        updateBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String col1value = meditText1.getText().toString();
                String col2value = meditText2.getText().toString();
                HanghoaAdapter hanghoaDB = new HanghoaAdapter(c);
                hanghoaDB.updateEntry(hh.getID(),col1value,col2value);
            }
        });

        return view;
    }
}

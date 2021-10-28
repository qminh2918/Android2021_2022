package com.example.lab61;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText txtso;
    TextView txtchon;
    Button btn;
    ListView lv;
    ArrayList<String> arrList=null;
    ArrayAdapter<String> adapter=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtso=(EditText) findViewById(R.id.txtSo);
        txtchon=(TextView) findViewById(R.id.txtselection);
        lv=(ListView) findViewById(R.id.lvperson);
        //1. Tạo ArrayList object
        arrList=new ArrayList<String>();
        //2. Gán Data Source (ArrayList object) vào ArrayAdapter
        adapter=new ArrayAdapter<String>
                (this,
                        android.R.layout.simple_list_item_1,
                        arrList);
        //3. gán Adapter vào ListView
        lv.setAdapter(adapter);
        btn=(Button) findViewById(R.id.btnNhap);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int so =Integer.parseInt(txtso.getText().toString());
                arrList.add(so+"");
                Toast.makeText( getBaseContext(), "Phần tử " + so*2, Toast.LENGTH_LONG ).show();
                adapter.notifyDataSetChanged();
            }
        });
        //5. Xử lý sự kiện chọn một phần tử trong ListView
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                txtchon.setText("position :"+i+""+arrList.get(i));
                txtchon.setText("position: "+i+arrList.get(i).toString());
            }
        });
        //6. xử lý sự kiện Long click
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int so =Integer.parseInt(txtso.getText().toString());
                arrList.remove(i);//xóa phần tử thứ i trong array
//                txtso.setText("position :"+i+""+so*2);
//                arrList.add(so*so,"");
                Toast.makeText( getBaseContext(), "Phần tử " + so*so, Toast.LENGTH_LONG ).show();
                // update dữ liệu khi nó thay đổi
                adapter.notifyDataSetChanged();
//                return false;
            }
        });
    }
}
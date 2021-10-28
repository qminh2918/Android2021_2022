package com.example.lab6_3;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class StaffActivity extends AppCompatActivity {
    ListView listView;
    List<Staff> dataList=new ArrayList<>();
    StaffAdapter staffAdapter;
    int chon=-1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_staff);
        listView=findViewById(R.id.listview);
        dataList.add(new Staff(R.drawable.staff1,"Nhan vien1","0123456","Nam"));
        dataList.add(new Staff(R.drawable.staff2,"Nhan vien2","0654321","Nữ"));
        dataList.add(new Staff(R.drawable.staff3,"Nhan vien3","0654789","Nam"));
        dataList.add(new Staff(R.drawable.staff4,"Nhan vien4","0987789","Nam"));

        staffAdapter=new StaffAdapter(this,dataList);
        listView.setAdapter(staffAdapter);

        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.longpress, menu);
        super.onCreateContextMenu(menu, v, menuInfo);
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo info=(AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int index=info.position;
        if(item.getItemId()==R.id.long_call){
            Toast.makeText(getApplicationContext(),"calling code",Toast.LENGTH_LONG).show();
            Intent i = new Intent();
            i.setAction(Intent.ACTION_DIAL);
            startActivity(i);
        }
        else if(item.getItemId()==R.id.long_sms){
            Toast.makeText(getApplicationContext(),"sending sms code", Toast.LENGTH_LONG).show();
            //final String sdt = ((TextView) listView.findViewById(R.id.textView)).getText().toString();
            //Toast.makeText(getApplicationContext(),""+sdt,Toast.LENGTH_LONG).show();
            //this.chon=index;
            Intent i = new Intent();
            i.setAction(Intent.ACTION_SENDTO);
            //i.setData(Uri.parse("sms:0123456"));
            startActivity(i);
        }else{
            return false;
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_add:
                addcontent();
                return true;
            case R.id.menu_exit:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    private void addcontent(){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);

        LayoutInflater inflater=getLayoutInflater();
        View view=inflater.inflate(R.layout.addcontent,null);

        EditText edTen=view.findViewById(R.id.add_ten);
        EditText edSdt=view.findViewById(R.id.add_sdt);
        EditText edGtinh=view.findViewById(R.id.add_gtinh);

        builder.setView(view);
        builder.setTitle("Them nhan vien");
        builder.setPositiveButton("Luu Nhan vien", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String ten=edTen.getText().toString();
                String sdt=edSdt.getText().toString();
                String gtinh=edGtinh.getText().toString();
                Staff staff=new Staff(R.drawable.staff1,ten,sdt,gtinh);
                dataList.add(staff);
                staffAdapter.notifyDataSetChanged();
            }
        }).setNegativeButton("Huy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        builder.show();
    }
}
package com.example.examplesqlite;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class NewsAdapter extends BaseAdapter {

    Activity activity;
    List<News> datalist;

    public NewsAdapter(Activity_news activity_news, List<News> datalist) {
    }

    @Override
    public int getCount() {
        return datalist.size();
    }

    @Override
    public Object getItem(int position) {
        return datalist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        //load item in ListView
        convertView = activity.getLayoutInflater().inflate(R.layout.item_news, null);
        News news = datalist.get(position);
        ImageView imageView = convertView.findViewById(R.id.dn_thumbnail);
        TextView title = convertView.findViewById(R.id.dn_title);
        TextView des = convertView.findViewById(R.id.dn_description);
        //tim hieu cach them Picasso, dua vao gradle
        title.setText(news.getTitle());
        des.setText(news.getDescription());
        return convertView;
    }
}

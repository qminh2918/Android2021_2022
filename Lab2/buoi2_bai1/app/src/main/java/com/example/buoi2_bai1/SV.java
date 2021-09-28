package com.example.buoi2_bai1;

public class SV {
    int id;
    String title,content;

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public SV(int id, String title, String context) {
        this.id = id;
        this.title = title;
        this.content = context;
    }
}



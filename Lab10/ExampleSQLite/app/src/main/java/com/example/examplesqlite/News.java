package com.example.examplesqlite;

public class News {
    String thumbnail, title, description;
    int id;

    public News() {
    }

    public News(String thumbnail, String title, String description) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.description = description;
    }

    public News(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public News( int id ,String thumbnail, String title, String description) {
        this.thumbnail = thumbnail;
        this.title = title;
        this.description = description;
        this.id = id;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "News{" +
                "thumbnail='" + thumbnail + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", id=" + id +
                '}';
    }
}


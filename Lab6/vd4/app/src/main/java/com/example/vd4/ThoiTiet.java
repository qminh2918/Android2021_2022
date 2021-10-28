package com.example.vd4;

public class ThoiTiet {
    private int intimage;// chứa ID của ảnh
    private String country;// chứa tên thành phố
    private String describe;// chứa miêu tả thời tiết
    private String intcelsius;// chứa nhiệt độ tính theo độ Celsius
    public ThoiTiet() {
    }
    public ThoiTiet(int intimage, String country, String describe, String intcelsius) {
        this.intimage = intimage;
        this.country = country;
        this.describe = describe;
        this.intcelsius = intcelsius;
    }
    public int getIntimage() {
        return intimage;
    }
    public void setIntimage(int intimage) {
        this.intimage = intimage;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getDescribe() {
        return describe;
    }
    public void setDescribe(String describe) {
        this.describe = describe;
    }
    public String getIntcelsius() {
        return intcelsius;
    }
    public void setIntcelsius(String intcelsius) {
        this.intcelsius = intcelsius;
    }
}


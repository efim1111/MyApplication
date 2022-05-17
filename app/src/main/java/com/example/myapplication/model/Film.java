package com.example.myapplication.model;

public class Film {
    int itemId;
    String img, imgBd, name, text;

    public Film(int itemId, String img) {
        this.itemId = itemId;
        this.img = img;
    }

    public Film(int itemId, String img, String imgBd, String name, String text) {
        this.itemId = itemId;
        this.img = img;
        this.imgBd = imgBd;
        this.name = name;
        this.text = text;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getImgBd() {
        return imgBd;
    }

    public void setImgBd(String imgBd) {
        this.imgBd = imgBd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

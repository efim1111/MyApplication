package com.example.myapplication.model;

public class Afisha {
    int id, category;
    String img, imgBd, name, text;

    public Afisha(int id, String img, String imgBd, String name, String text,  int category) {
        this.id = id;
        this.img = img;
        this.imgBd = imgBd;
        this.name = name;
        this.text = text;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
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

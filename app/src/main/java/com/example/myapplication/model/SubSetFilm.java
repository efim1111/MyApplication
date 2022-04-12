package com.example.myapplication.model;

public class SubSetFilm {
    int itemId;
    String img;

    public SubSetFilm(int itemId, String img) {
        this.itemId = itemId;
        this.img = img;
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
}

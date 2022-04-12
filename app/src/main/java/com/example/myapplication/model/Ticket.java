package com.example.myapplication.model;

public class Ticket {
    int id;
    String date, name, nameKinoteatr, img;

    public Ticket(int id, String date, String name, String nameKinoteatr, String img) {
        this.id = id;
        this.date = date;
        this.name = name;
        this.nameKinoteatr = nameKinoteatr;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getNameKinoteatr() {
        return nameKinoteatr;
    }

    public void setNameKinoteatr(String nameKinoteatr) {
        this.nameKinoteatr = nameKinoteatr;
    }
}

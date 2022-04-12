package com.example.myapplication.model;

import java.util.List;

public class SetFilm {

    int id;
    String title;
    List<SubSetFilm> subSetFilmList;


    public SetFilm(int id, String title, List<SubSetFilm> subSetFilmList) {
        this.id = id;
        this.title = title;
        this.subSetFilmList = subSetFilmList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public List<SubSetFilm> getSubSetFilmList() {
        return subSetFilmList;
    }

    public void setSubSetFilmList(List<SubSetFilm> subSetFilmList) {
        this.subSetFilmList = subSetFilmList;
    }
}

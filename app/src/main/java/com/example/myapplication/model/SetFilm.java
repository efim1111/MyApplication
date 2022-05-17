package com.example.myapplication.model;

import java.util.List;

public class SetFilm {

    int id;
    String title;
    List<Film> filmList;


    public SetFilm(int id, String title, List<Film> filmList) {
        this.id = id;
        this.title = title;
        this.filmList = filmList;
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


    public List<Film> getSubSetFilmList() {
        return filmList;
    }

    public void setSubSetFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }
}

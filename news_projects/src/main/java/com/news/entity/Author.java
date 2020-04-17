package com.news.entity;

public class Author {

    private int id;
    private String nameAuthor;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameAuthor() {
        return nameAuthor;
    }

    public void setNameAuthor(String name) {
        this.nameAuthor = name;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + nameAuthor + '\'' +
                '}';
    }
}
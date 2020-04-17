package com.news.entity;

public class Tag {

    private int id;
    private String nameTag;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameTag() {
        return nameTag;
    }

    public void setNameTag(String name) {
        this.nameTag = name;
    }

    @Override
    public String toString() {
        return "Tag{" +
                ", name='" + nameTag + '\'' +
                '}';
    }
}


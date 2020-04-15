package com.news.entity;

public class News {
    private int id;
    private String title;
    private double rate;
    private boolean visible = true;


    public boolean isVisable() {
        return visible;
    }

    public void setVisable(boolean visable) {
        this.visible = visable;
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

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", rate=" + rate +
                '}';
    }
}

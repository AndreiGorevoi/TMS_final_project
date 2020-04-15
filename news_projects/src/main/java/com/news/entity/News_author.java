package com.news.entity;

public class News_author {

    private int id;
    private int id_news;
    private int id_author;

    public News_author(int id_news, int id_author) {
        this.id_news = id_news;
        this.id_author = id_author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_news() {
        return id_news;
    }

    public void setId_news(int id_news) {
        this.id_news = id_news;
    }

    public int getId_author() {
        return id_author;
    }

    public void setId_author(int id_author) {
        this.id_author = id_author;
    }

    @Override
    public String toString() {
        return "News_author{" +
                "id=" + id +
                ", id_news=" + id_news +
                ", id_author=" + id_author +
                '}';
    }
}

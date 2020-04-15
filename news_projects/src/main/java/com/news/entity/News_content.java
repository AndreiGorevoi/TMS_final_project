package com.news.entity;

public class News_content {

    private int id;
    private int id_news;
    private int id_content;

    public News_content(int id_news, int id_content) {
        this.id_news = id_news;
        this.id_content = id_content;
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

    public int getId_content() {
        return id_content;
    }

    public void setId_content(int id_content) {
        this.id_content = id_content;
    }

    @Override
    public String toString() {
        return "News_content{" +
                "id=" + id +
                ", id_news=" + id_news +
                ", id_content=" + id_content +
                '}';
    }
}

package com.news.entity;

public class News_full {
    private int id;
    private String title;
    private String name_tag;
    private String name_auhtor;
    private double rate;
    private String content;

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

    public String getName_tag() {
        return name_tag;
    }

    public void setName_tag(String name_tag) {
        this.name_tag = name_tag;
    }

    public String getName_auhtor() {
        return name_auhtor;
    }

    public void setName_auhtor(String name_auhtor) {
        this.name_auhtor = name_auhtor;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

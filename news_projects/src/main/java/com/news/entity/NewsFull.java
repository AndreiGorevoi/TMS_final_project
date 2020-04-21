package com.news.entity;

public class NewsFull {
    private int id;
    private String title;
    private String name_tag;
    private String name_author;
    private double rate;
    private String content;
    private boolean visible = true;

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
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

    public String getName_tag() {
        return name_tag;
    }

    public void setName_tag(String name_tag) {
        this.name_tag = name_tag;
    }

    public String getName_author() {
        return name_author;
    }

    public void setName_author(String name_auhtor) {
        this.name_author = name_auhtor;
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

    public boolean equals(NewsFull newNews){
        if(this.title.equalsIgnoreCase(newNews.getTitle())){
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "News_full{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", name_tag='" + name_tag + '\'' +
                ", name_auhtor='" + name_author + '\'' +
                ", rate=" + rate +
                ", content='" + content + '\'' +
                '}';
    }
}

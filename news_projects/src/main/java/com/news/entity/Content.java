package com.news.entity;

public class Content {

    private int id;
    private String body;

    public Content(String body) {
        this.body = body;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Content{" +
                "id=" + id +
                ", body='" + body + '\'' +
                '}';
    }
}

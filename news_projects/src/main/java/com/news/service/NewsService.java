package com.news.service;

import com.news.entity.NewsFull;

import java.util.List;

public interface NewsService {
    List<NewsFull> getNews() throws ClassNotFoundException;
    void addNews(String title, String author, String content, String tag, double rate);
    void deleteNews(NewsFull news);
    void updateNews(NewsFull news, String newTitle, double newRate, String newContent);
}

package com.news.service;

import com.news.entity.NewsFull;

import java.util.List;

public interface NewsService {
    List<String> getNews();
    void addNews(NewsFull news);
    void deleteNews(NewsFull news);
    void updateNews(NewsFull news, String newTitle, double newRate, String newContent);
}

package com.news.repository;

import com.news.entity.NewsFull;

import java.util.List;

public interface NewsRepository {
    List<NewsFull> getNews() throws ClassNotFoundException;
    void addNews(NewsFull news);
    void deleteNews(NewsFull news);
    void updateNews(NewsFull news, String newTitle, double newRate, String newContent);
}

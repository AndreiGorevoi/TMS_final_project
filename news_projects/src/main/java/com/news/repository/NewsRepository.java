package com.news.repository;

import com.news.entity.NewsFull;

import java.util.List;

public interface NewsRepository {
    List<NewsFull> getNews() throws ClassNotFoundException;
    void addNews(NewsFull news) throws ClassNotFoundException;
    void deleteNews(String title);
    void updateNews(String oldTitle, String newTitle, double newRate, String newContent) throws ClassNotFoundException;
}

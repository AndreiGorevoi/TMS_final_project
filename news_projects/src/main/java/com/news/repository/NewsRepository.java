package com.news.repository;

import com.news.entity.News_full;

import java.util.List;

public interface NewsRepository {
    List<News_full> getNews();
    void addNews(News_full news);
    void deleteNews(News_full news);
    void updateNews(News_full news, String newTitle, double newRate, String newContent);
}

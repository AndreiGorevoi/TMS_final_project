package com.news.repository;

import com.news.entity.News;
import com.news.entity.News_full;

import java.util.List;

public interface NewsRepository {
    List<News> getNews();
    void addNews(News_full news);
}

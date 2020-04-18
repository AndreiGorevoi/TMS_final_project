package com.news.service;

import com.news.entity.NewsFull;

import java.util.List;

public interface NewsService {
    List<NewsFull> getNews();
}

package com.news.service;

import com.news.entity.News;
import com.news.repository.NewsRepository;
import com.news.repository.NewsRepositoryImpl;

import java.util.List;

public class NewsServiceImlp implements NewsService {
    private final NewsRepository newsRepository;

    public NewsServiceImlp(NewsRepositoryImpl newsRepository) {
        this.newsRepository=newsRepository;
    }


    @Override
    public List<News> getNews() {
        List<News> newsList = newsRepository.getNews();
        return newsList;
    }
}

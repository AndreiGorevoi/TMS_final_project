package com.news.repository;

import com.news.entity.News;

import java.util.List;

public interface NewsRepository {

    List<News> getNews();
}

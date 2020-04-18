package com.news.repository;

import com.news.entity.NewsFull;

public class Runner {


    public static void main(String[] args) {
        NewsFull news = new NewsFull();
        news.setTitle("Java for everybody");
        news.setRate(10);
        news.setContent("Egor ad Andryha made getNews");
        news.setName_author("Andryha and Egor");
        news.setName_tag("Programming");
        news.setId(9);

        NewsRepository newsRepository = new NewsRepositoryImpl();
        newsRepository.addNews(news);
        newsRepository.addNews(news);

    }
}

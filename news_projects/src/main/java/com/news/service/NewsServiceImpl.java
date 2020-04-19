package com.news.service;

import com.news.entity.NewsFull;
import com.news.repository.NewsRepository;
import com.news.repository.NewsRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class NewsServiceImpl implements NewsService {
    private NewsRepository newsRepository = new NewsRepositoryImpl();
    @Override
    public List<String> getNews() throws ClassNotFoundException {
        List<String> printNews = new ArrayList<>();
        List<NewsFull> newsFulls = newsRepository.getNews();
        for (NewsFull news:newsFulls) {
            printNews.add(news.toString());
        }
        return printNews;
    }

    @Override
    public void addNews(NewsFull news) {
        newsRepository.addNews(news);
    }

    @Override
    public void deleteNews(NewsFull news) {
        newsRepository.deleteNews(news);
    }

    @Override
    public void updateNews(NewsFull news, String newTitle, double newRate, String newContent) {
        newsRepository.updateNews(news, newTitle,newRate,newContent);
    }
}

package com.news.service;

import com.news.entity.NewsFull;
import com.news.repository.NewsRepository;
import com.news.repository.NewsRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    private NewsRepository newsRepository;

    @Override
    public List<NewsFull> getNews() throws ClassNotFoundException {

        return newsRepository.getNews();
    }

    @Override
    public void addNews(String title, String author, String content, String tag, double rate) throws ClassNotFoundException {
        NewsFull news = new NewsFull();
        news.setTitle(title);
        news.setName_author(author);
        news.setContent(content);
        news.setName_tag(tag);
        news.setRate(rate);
        newsRepository.addNews(news);
    }

    @Override
    public void deleteNews(String title) {
        newsRepository.deleteNews(title);
    }

    @Override
    public void updateNews(String oldTitle, String newTitle, double newRate, String newContent) throws ClassNotFoundException {
        newsRepository.updateNews(oldTitle, newTitle,newRate,newContent);
    }
}

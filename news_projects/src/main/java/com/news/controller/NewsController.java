package com.news.controller;
import com.news.entity.NewsFull;
import com.news.repository.NewsRepository;
import com.news.repository.NewsRepositoryImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/getNews")
public class NewsController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        NewsRepository newsRepository = new NewsRepositoryImpl();
        List<NewsFull> news_fullList = newsRepository.getNews();
        news_fullList.forEach(System.out::println);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

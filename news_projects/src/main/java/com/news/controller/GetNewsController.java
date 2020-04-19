package com.news.controller;
import com.news.entity.NewsFull;
import com.news.repository.NewsRepository;
import com.news.repository.NewsRepositoryImpl;
import com.news.service.NewsService;
import com.news.service.NewsServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(urlPatterns = "/getNews")
public class GetNewsController extends HttpServlet {
    final static NewsService newsService = new NewsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<NewsFull> newsList = newsService.getNews();
            req.setAttribute("list", newsList);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("getNews.jsp");
            requestDispatcher.forward(req,resp);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

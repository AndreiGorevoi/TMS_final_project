package com.news.controller;

import com.news.repository.NewsRepository;
import com.news.service.NewsService;
import com.news.service.NewsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/addNews")
public class AddNewsController extends HttpServlet {

    ApplicationContext context = new AnnotationConfigApplicationContext("com");
    NewsService newsService = context.getBean(NewsServiceImpl.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("addNews.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        try {
            newsService.addNews(req.getParameter("title"), req.getParameter("author"), req.getParameter("content"),
                    req.getParameter("tag"), Double.valueOf(req.getParameter("rate")));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        doGet(req,resp);
    }
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

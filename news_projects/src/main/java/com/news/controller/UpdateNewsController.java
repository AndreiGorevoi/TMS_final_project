package com.news.controller;

import com.news.service.NewsService;
import com.news.service.NewsServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/updateNews")
public class UpdateNewsController extends HttpServlet {
    NewsService newsService = new NewsServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("updateNews.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            newsService.updateNews(req.getParameter("titleOld"),req.getParameter("titleNew"),
                    Double.valueOf(req.getParameter("rate")),req.getParameter("content"));
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

package com.news.controller;

import com.news.entity.News_full;
import com.news.repository.NewsRepository;
import com.news.repository.NewsRepositoryImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/getNews")
public class NewsController extends HttpServlet {

    NewsRepository newsRepository = new NewsRepositoryImpl();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.getRequestDispatcher("/index.jsp").forward(req,resp);
        List<News_full> newsFull = newsRepository.getNews();
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        for (News_full nf: newsFull) {
            pw.write(String.valueOf(nf));
            pw.flush();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}

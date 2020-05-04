package com.news.controller;

import com.news.entity.Author;
import com.news.entity.NewsFull;
import com.news.service.AuthorService;
import com.news.service.AuthoreServiceImpl;
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
import java.util.List;
@WebServlet(urlPatterns = "/getAuthors")
public class GetAuthorsController extends HttpServlet {
    ApplicationContext context = new AnnotationConfigApplicationContext("com");
    AuthorService authoreService=context.getBean(AuthoreServiceImpl.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Author> authorList = authoreService.getAuthors();
        req.setAttribute("list", authorList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("getAuthors.jsp");
        requestDispatcher.forward(req,resp);

    }

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


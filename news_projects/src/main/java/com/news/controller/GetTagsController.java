package com.news.controller;

import com.news.entity.Author;
import com.news.entity.Tag;
import com.news.service.AuthorService;
import com.news.service.AuthoreServiceImpl;
import com.news.service.TagService;
import com.news.service.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.jws.WebService;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/getTags")
public class GetTagsController extends HttpServlet {
    ApplicationContext context = new AnnotationConfigApplicationContext("com");
    TagService tagService=context.getBean(TagServiceImpl.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Tag> tagList = tagService.getTag();
        req.setAttribute("list", tagList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("getTags.jsp");
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

package com.news.controller;

import com.news.entity.NewsFull;
import com.news.service.BasketService;
import com.news.service.BasketServiceImpl;
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

@WebServlet(urlPatterns = "/getBasket")
public class GetBasketController extends HttpServlet {
    final static BasketService basketService = new BasketServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<NewsFull> newsList = basketService.getBasket();
        req.setAttribute("list", newsList);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("getBasket.jsp");
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

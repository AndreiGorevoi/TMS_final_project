package com.news.repository;

import com.news.dbUtils.CreateConnection;
import com.news.entity.News;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsRepositoryImpl implements NewsRepository {
    @Override
    public List<News> getNews() {
        String sql = "select * from news";
        List<News> newsList = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(CreateConnection.url,CreateConnection.user,
                CreateConnection.password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                News news = new News();
                news.setId(resultSet.getInt(1));
                news.setTitle(resultSet.getString(2));
                news.setRate(resultSet.getDouble(3));
                newsList.add(news);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return newsList;
    }
}

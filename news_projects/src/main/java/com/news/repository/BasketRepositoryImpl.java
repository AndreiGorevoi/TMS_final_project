package com.news.repository;

import com.news.dbUtils.CreateConnection;
import com.news.entity.NewsFull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BasketRepositoryImpl implements BasketRepository {
    @Override
    public List<NewsFull> getBasket() {
        List<NewsFull> newsFullList = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(CreateConnection.url, CreateConnection.user, CreateConnection.password)) {
            String sql = "Select * from news where visible=0";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                int id_news = 0;
                int id_author = 0;
                int id_tag = 0;

                NewsFull news = new NewsFull();
                news.setId(rs.getInt(1));
                id_news = news.getId();
                news.setTitle(rs.getString(2));
                news.setRate(rs.getDouble(3));
                news.setVisible(rs.getBoolean(4));
                news.setContent(rs.getString(5));

                String sql1 = "Select id_author from news_author where id_news = ?";
                PreparedStatement ps = connection.prepareStatement(sql1);
                ps.setInt(1, id_news);
                ResultSet rs2 = ps.executeQuery();
                rs2.next();
                id_author = rs2.getInt(1);

                String sql2 = "Select id_tag from news_tag where id_news = ?";
                ps = connection.prepareStatement(sql2);
                ps.setInt(1, id_news);
                rs2 = ps.executeQuery();
                rs2.next();
                id_tag = rs2.getInt(1);

                String sql3 = "Select name from author where id = ?";
                ps = connection.prepareStatement(sql3);
                ps.setInt(1, id_author);
                rs2 = ps.executeQuery();
                rs2.next();
                news.setName_author(rs2.getString(1));

                String sql4 = "Select name from tag where id = ?";
                ps = connection.prepareStatement(sql4);
                ps.setInt(1, id_tag);
                rs2 = ps.executeQuery();
                rs2.next();
                news.setName_tag(rs2.getString(1));
                newsFullList.add(news);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return newsFullList;
    }
}

package com.news.repository;

import com.news.dbUtils.CreateConnection;
import com.news.entity.News;
import com.news.entity.News_full;

import java.sql.*;
import java.util.List;

public class NewsRepositoryImpl implements NewsRepository{


    @Override
    public List<News> getNews() {

        return null;
    }
    @Override
    public void addNews(News_full news) {
        try(Connection connection = DriverManager.getConnection(CreateConnection.url,CreateConnection.user,
                CreateConnection.password)) {
            String sql = "Insert into news(title,rate,content) value(?,?,?)";
            int id_news;
            int id_author;
            int id_tag;

            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1,news.getTitle());
            ps.setDouble(2,news.getRate());
            ps.setString(3,news.getContent());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                id_news = rs.getInt(1);
            }

            sql="Insert into author(name) value(?)";
            ps=connection.prepareStatement(sql);
            ps.setString(1,news.getName_auhtor());
            ps.executeUpdate();
            rs=ps.getGeneratedKeys();
            if(rs.next()){
                id_author=rs.getInt(1);
            }

            sql="Insert into tag(name) value(?)";




        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

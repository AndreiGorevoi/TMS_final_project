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
            int id_news = 0;
            int id_author = 0;
            int id_tag = 0;

            PreparedStatement ps = connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,news.getTitle());
            ps.setDouble(2,news.getRate());
            ps.setString(3,news.getContent());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if(rs.next()){
                id_news = rs.getInt(1);
            }


            sql="Insert into author(name) value(?)";
            ps=connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1,news.getName_auhtor());
            ps.executeUpdate();
            rs=ps.getGeneratedKeys();
            if(rs.next()){
                id_author=rs.getInt(1);
            }
            rs.close();

            sql="Insert into tag(name) value(?)";
            ps=connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setString(1, news.getName_tag());
            ps.executeUpdate();
            rs=ps.getGeneratedKeys();
            if (rs.next()) {
                id_tag=rs.getInt(1);
            }
            rs.close();

            sql="Insert into news_author(id_news, id_author) value (?, ?)";
            ps=connection.prepareStatement(sql);
            ps.setInt(1, id_news);
            ps.setInt(2, id_author);
            ps.execute();
            rs.close();

            sql="Insert into news_tag(id_news, id_tag) value (?, ?)";
            ps=connection.prepareStatement(sql);
            ps.setInt(1, id_news);
            ps.setInt(2, id_tag);
            ps.execute();
            rs.close();



        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}

package com.news.repository;

import com.news.dbUtils.CreateConnection;
import com.news.entity.NewsFull;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsRepositoryImpl implements NewsRepository{


    @Override
    public List<NewsFull> getNews() throws ClassNotFoundException {
        List<NewsFull> newsList = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        try(Connection connection = DriverManager.getConnection(CreateConnection.url, CreateConnection.user, CreateConnection.password)) {
            String sql = "Select * from news";
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
                    if (news.isVisible()) {
                        newsList.add(news);
                    }
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return newsList;
    }

    @Override
    public void addNews(NewsFull news) {
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
            ps.setString(1,news.getName_author());
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

    @Override
    public void deleteNews(NewsFull news) {
        try (Connection connection = DriverManager.getConnection(CreateConnection.url, CreateConnection.user, CreateConnection.password)){
            String sql = "Update news set visible = 0 where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, news.getId());
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

    @Override
    public void updateNews(NewsFull news, String newTitle, double newRate, String newContent) {
        try (Connection connection = DriverManager.getConnection(CreateConnection.url, CreateConnection.user, CreateConnection.password)){
            String sql = "Update news set title = ?, rate = ?, content = ? where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, newTitle);
            ps.setDouble(2, newRate);
            ps.setString(3, newContent);
            ps.setInt(4, news.getId());
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }


}

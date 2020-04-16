package com.news.repository;

import com.news.dbUtils.CreateConnection;
import com.news.entity.Author;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorRepositoryImpl_Old implements AuthorRepositoty_Old {

    @Override
    public List<Author> getAuthors() {
        String sql = "select * from author";
        List<Author> authorList = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(CreateConnection.url,CreateConnection.user,
                CreateConnection.password)) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Author author = new Author();
                author.setId(resultSet.getInt(1));
                author.setName(resultSet.getString(2));
                author.setSurname(resultSet.getString(3));
                authorList.add(author);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return authorList;
    }
}


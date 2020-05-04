package com.news.repository;

import com.news.dbUtils.CreateConnection;
import com.news.entity.Author;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class AuthorRepositoryImpl implements AuthorRepository{
    @Override
    public List<Author> getAuthors() {
       List<Author> authorsList = new ArrayList<>();
       try(Connection connection = DriverManager.getConnection(CreateConnection.url, CreateConnection.user, CreateConnection.password)) {
           String sql = "Select * from author";
           Statement statement = connection.createStatement();
           ResultSet rs = statement.executeQuery(sql);
           while (rs.next()) {
               Author author = new Author();
               author.setNameAuthor(rs.getString(2));
               authorsList.add(author);
           }

       } catch (SQLException throwables) {
           throwables.printStackTrace();
       }

        return authorsList;
    }

    @Override
    public void updateAuthor(Author author, String newAuthor) {
        try (Connection connection = DriverManager.getConnection(CreateConnection.url, CreateConnection.user, CreateConnection.password)){
            String sql = "Update author set name = ? where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, newAuthor);
            ps.setInt(2, author.getId());
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}

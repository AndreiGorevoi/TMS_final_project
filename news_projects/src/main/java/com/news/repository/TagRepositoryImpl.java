package com.news.repository;

import com.news.dbUtils.CreateConnection;
import com.news.entity.Author;
import com.news.entity.Tag;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class TagRepositoryImpl implements TagRepository{
    @Override
    public List<Tag> getTag() {
        List<Tag> tagList = new ArrayList<>();
        try(Connection connection = DriverManager.getConnection(CreateConnection.url, CreateConnection.user, CreateConnection.password)) {
            String sql = "Select * from tag";
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            while (rs.next()) {
                Tag tag = new Tag();
                tag.setNameTag(rs.getString(2));
                tagList.add(tag);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return tagList;
    }

    @Override
    public void updateTag(Tag tag, String newTag) {
        try (Connection connection = DriverManager.getConnection(CreateConnection.url, CreateConnection.user, CreateConnection.password)){
            String sql = "Update tag set name = ? where id = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, newTag);
            ps.setInt(2, tag.getId());
            ps.executeUpdate();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }
}

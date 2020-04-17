package com.news.repository;

import com.news.entity.Author;

import java.util.List;

public interface AuthorRepository {

    List<Author> getAuthors();
    void updateAuthor(Author author, String newAuthor);

}

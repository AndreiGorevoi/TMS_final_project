package com.news.service;

import com.news.entity.Author;
import com.news.repository.AuthorRepository;
import com.news.repository.AuthorRepositoryImpl;

import java.util.List;

public class AuthoreServiceImpl implements AuthorService {
    private AuthorRepository authorRepository = new AuthorRepositoryImpl();
    @Override
    public List<Author> getAuthors() {
        return authorRepository.getAuthors();
    }

    @Override
    public void updateAuthor(Author author, String newAuthor) {
        authorRepository.updateAuthor(author, newAuthor);
    }
}

package com.news.service;

import com.news.entity.Author;
import com.news.repository.AuthorRepository;
import com.news.repository.AuthorRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthoreServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public List<Author> getAuthors() {
        return authorRepository.getAuthors();
    }

    @Override
    public void updateAuthor(Author author, String newAuthor) {
        authorRepository.updateAuthor(author, newAuthor);
    }
}

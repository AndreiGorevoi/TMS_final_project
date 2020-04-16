package com.news.service;

import com.news.entity.Author;
import com.news.repository.AuthorRepositoty_Old;

import java.util.List;

public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepositoty_Old authorRepositoty;

    public AuthorServiceImpl(AuthorRepositoty_Old authorRepositoty) {
        this.authorRepositoty=authorRepositoty;
    }


    @Override
    public List<Author> getAuthors() {
        List<Author> authorList = authorRepositoty.getAuthors();
        return authorList;
    }
}


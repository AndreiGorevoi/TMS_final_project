package com.news.service;

import com.news.entity.NewsFull;
import com.news.repository.BasketRepository;
import com.news.repository.BasketRepositoryImpl;

import java.util.List;

public class BasketServiceImpl implements BasketService {
    BasketRepository basketRepository = new BasketRepositoryImpl();
    @Override
    public List<NewsFull> getBasket() {
        return basketRepository.getBasket();
    }
}

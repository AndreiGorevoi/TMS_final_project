package com.news.service;

import com.news.entity.NewsFull;
import com.news.repository.BasketRepository;
import com.news.repository.BasketRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BasketServiceImpl implements BasketService {
    @Autowired
    BasketRepository basketRepository;


    @Override
    public List<NewsFull> getBasket() {
        return basketRepository.getBasket();
    }
}

package com.news.repository;

import com.news.entity.NewsFull;

import java.util.List;

public interface BasketRepository {
    List<NewsFull> getBasket();
}

package com.news.service;

import com.news.entity.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getTag();
    void updateTag(Tag tag, String newTag);
}

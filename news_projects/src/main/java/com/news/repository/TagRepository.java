package com.news.repository;

import com.news.entity.Author;
import com.news.entity.Tag;

import java.util.List;

public interface TagRepository {

    List<Tag> getTag();
    void updateTag(Tag tag, String newTag);

}

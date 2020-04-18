package com.news.service;

import com.news.entity.Tag;
import com.news.repository.TagRepository;
import com.news.repository.TagRepositoryImpl;

import java.util.List;

public class TagServiceImpl implements TagService {
    private TagRepository tagRepository = new TagRepositoryImpl();

    @Override
    public List<Tag> getTag() {
        return tagRepository.getTag();
    }

    @Override
    public void updateTag(Tag tag, String newTag) {
        tagRepository.updateTag(tag,newTag);
    }
}

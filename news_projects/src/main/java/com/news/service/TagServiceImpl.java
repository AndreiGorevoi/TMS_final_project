package com.news.service;

import com.news.entity.Tag;
import com.news.repository.TagRepository;
import com.news.repository.TagRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagRepository tagRepository;


    @Override
    public List<Tag> getTag() {
        return tagRepository.getTag();
    }

    @Override
    public void updateTag(Tag tag, String newTag) {
        tagRepository.updateTag(tag,newTag);
    }
}

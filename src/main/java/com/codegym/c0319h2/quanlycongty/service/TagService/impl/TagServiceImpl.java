package com.codegym.c0319h2.quanlycongty.service.TagService.impl;

import com.codegym.c0319h2.quanlycongty.model.Tag.Tags;
import com.codegym.c0319h2.quanlycongty.repository.Tag.TagRepository;
import com.codegym.c0319h2.quanlycongty.service.TagService.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class TagServiceImpl implements TagService {
    @Autowired
    private TagRepository tagRepository;

    @Override
    public Iterable<Tags> findAll() {
        return tagRepository.findAll();
    }

    @Override
    public Optional<Tags> findById(Long id) {
        return tagRepository.findById(id);
    }

    @Override
    public void save(Tags tags) {
         tagRepository.save(tags);
    }

    @Override
    public void remove(Long id) {
         tagRepository.deleteById(id);
    }
}

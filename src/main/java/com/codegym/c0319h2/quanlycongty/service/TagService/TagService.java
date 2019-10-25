package com.codegym.c0319h2.quanlycongty.service.TagService;

import com.codegym.c0319h2.quanlycongty.model.Tag.Tags;

import java.util.Optional;

public interface TagService {
    Iterable<Tags> findAll();

    Optional<Tags> findById(Long id);

    void save(Tags tags);

    void remove(Long id);
}

package com.codegym.c0319h2.quanlycongty.service.TechnologyService;

import com.codegym.c0319h2.quanlycongty.model.technology.Technology;

import java.util.Optional;

public interface TechnologyService {
    Iterable<Technology> findAll();

    Optional<Technology> findById(Long id);

    void save(Technology technology);

    void remove(Long id);
}

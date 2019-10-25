package com.codegym.c0319h2.quanlycongty.service.TechnologyService.impl;

import com.codegym.c0319h2.quanlycongty.model.technology.Technology;
import com.codegym.c0319h2.quanlycongty.repository.technology.TechnologyRepository;
import com.codegym.c0319h2.quanlycongty.service.TechnologyService.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TechnologyServiceImpl implements TechnologyService {

    @Autowired
    private TechnologyRepository technologyRepository;

    @Override
    public Iterable<Technology> findAll() {
        return technologyRepository.findAll();
    }

    @Override
    public Optional<Technology> findById(Long id) {
        return technologyRepository.findById(id);
    }

    @Override
    public void save(Technology technology) {
        technologyRepository.save(technology);
    }

    @Override
    public void remove(Long id) {
        technologyRepository.deleteById(id);
    }
}

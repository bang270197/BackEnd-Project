package com.codegym.c0319h2.quanlycongty.service.LanguageService.impl;


import com.codegym.c0319h2.quanlycongty.model.Language.Language;
import com.codegym.c0319h2.quanlycongty.repository.Language.LanguageRepository;
import com.codegym.c0319h2.quanlycongty.service.LanguageService.LanguageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LanguageServiceImpl implements LanguageService {
    @Autowired
    private LanguageRepository languageRepository;
    @Override
    public Iterable<Language> findAll() {
        return languageRepository.findAll();
    }

    @Override
    public Optional<Language> findById(Long id) {
        return languageRepository.findById(id);
    }
}

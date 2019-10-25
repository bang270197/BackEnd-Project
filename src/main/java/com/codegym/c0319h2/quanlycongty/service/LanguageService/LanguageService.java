package com.codegym.c0319h2.quanlycongty.service.LanguageService;

import com.codegym.c0319h2.quanlycongty.model.Language.Language;

import java.util.Optional;

public interface LanguageService {
    Iterable<Language> findAll();

    Optional<Language> findById(Long id);
}

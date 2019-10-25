package com.codegym.c0319h2.quanlycongty.service.SpecializeService;

import com.codegym.c0319h2.quanlycongty.model.Specialize.Specialize;

import java.util.Optional;

public interface SpecializeService {
    Iterable<Specialize> findAll();

    Optional<Specialize> findById(Long id);

}

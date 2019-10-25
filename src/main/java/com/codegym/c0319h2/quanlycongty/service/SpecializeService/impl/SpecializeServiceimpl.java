package com.codegym.c0319h2.quanlycongty.service.SpecializeService.impl;

import com.codegym.c0319h2.quanlycongty.model.Specialize.Specialize;
import com.codegym.c0319h2.quanlycongty.repository.Specialize.SpecializeRepository;
import com.codegym.c0319h2.quanlycongty.service.SpecializeService.SpecializeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.ref.PhantomReference;
import java.util.Optional;

@Service
public class SpecializeServiceimpl implements SpecializeService {
    @Autowired
    private SpecializeRepository specializeRepository;
    @Override
    public Iterable<Specialize> findAll() {
        return specializeRepository.findAll();
    }

    @Override
    public Optional<Specialize> findById(Long id) {
        return specializeRepository.findById(id);
    }
}

package com.codegym.c0319h2.quanlycongty.service.MarketService.impl;

import com.codegym.c0319h2.quanlycongty.model.Market.Market;
import com.codegym.c0319h2.quanlycongty.model.Relationship.Relationship;
import com.codegym.c0319h2.quanlycongty.repository.Market.MarketRepository;
import com.codegym.c0319h2.quanlycongty.service.MarketService.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.ref.PhantomReference;
import java.util.Optional;

@Service
public class MarketServiceImpl implements MarketService {
    @Autowired
    private MarketRepository marketRepository;
    @Override
    public Iterable<Market> findAll() {
        return marketRepository.findAll();
    }

    @Override
    public Optional<Market> findById(Long id) {
        return marketRepository.findById(id);
    }
}

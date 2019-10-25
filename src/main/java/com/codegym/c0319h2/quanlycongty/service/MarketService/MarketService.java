package com.codegym.c0319h2.quanlycongty.service.MarketService;

import com.codegym.c0319h2.quanlycongty.model.Market.Market;
import com.codegym.c0319h2.quanlycongty.model.Relationship.Relationship;

import java.util.Optional;

public interface MarketService {
    Iterable<Market> findAll();

    Optional<Market> findById(Long id);
}

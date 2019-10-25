package com.codegym.c0319h2.quanlycongty.repository.Market;

import com.codegym.c0319h2.quanlycongty.model.Market.Market;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepository extends JpaRepository<Market,Long> {
}

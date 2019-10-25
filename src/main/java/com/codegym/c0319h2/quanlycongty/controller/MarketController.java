package com.codegym.c0319h2.quanlycongty.controller;

import com.codegym.c0319h2.quanlycongty.model.Market.Market;
import com.codegym.c0319h2.quanlycongty.service.MarketService.MarketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class MarketController {
    @Autowired
    private MarketService marketService;

    @GetMapping("/getAllMarket")
    public ResponseEntity<List<Market>> getAllLanguage(){
        List<Market> marketList = (List<Market>) marketService.findAll();
        if (marketList.isEmpty()){
            return new ResponseEntity<List<Market>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Market>>(marketList,HttpStatus.OK);
    }

    @GetMapping("/Market/{id}")
    public ResponseEntity<Market> findByid(@PathVariable Long id) {
        Optional<Market> market = marketService.findById(id);
        Market getMarket = market.get();
        if (getMarket==null) {
            return new ResponseEntity<Market>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Market>(getMarket, HttpStatus.OK);
    }
}

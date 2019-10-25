package com.codegym.c0319h2.quanlycongty.controller;

import com.codegym.c0319h2.quanlycongty.model.technology.Technology;
import com.codegym.c0319h2.quanlycongty.service.TechnologyService.TechnologyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class TechnologyController {
    @Autowired
    private TechnologyService technologyService;

    @GetMapping("/Technology")
    public ResponseEntity<List<Technology>> findAllTechnology() {
        List<Technology> technologyList = (List<Technology>) technologyService.findAll();
        if (technologyList.isEmpty()) {
            return new ResponseEntity<List<Technology>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Technology>>(technologyList, HttpStatus.OK);
    }

    @PostMapping("/Technology")
    public ResponseEntity<Technology> createTechnology(@RequestBody Technology technology, UriComponentsBuilder uriComponentsBuilder) {
        technologyService.save(technology);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriComponentsBuilder.path("/Technology/{id}").buildAndExpand(technology.getId()).toUri());
        return new ResponseEntity<Technology>(technology, HttpStatus.CREATED);
    }

    @PutMapping("/Technology/{id}")
    public ResponseEntity<Technology> updateTechnology(@PathVariable Long id, @RequestBody Technology technology) {
        Optional<Technology> technology1 = technologyService.findById(id);
        Technology technologyUpdale = technology1.get();
        if (technologyUpdale == null) {
            return new ResponseEntity<Technology>(HttpStatus.NOT_FOUND);
        }
        technologyUpdale.setName(technology.getName());
        technologyService.save(technologyUpdale);
        return new ResponseEntity<Technology>(technologyUpdale, HttpStatus.OK);
    }

    @DeleteMapping("/Technology/{id}")
    public ResponseEntity<Void> deleteTechnology(@PathVariable Long id) {
        Optional<Technology> technology = technologyService.findById(id);
        if (!technology.isPresent()) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        technologyService.remove(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/Technology/{id}")
    public ResponseEntity<Technology> findByid(@PathVariable Long id) {
        Optional<Technology> technology = technologyService.findById(id);
        Technology getTechnology = technology.get();
        if (getTechnology==null) {
            return new ResponseEntity<Technology>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Technology>(getTechnology, HttpStatus.OK);
    }
}

package com.codegym.c0319h2.quanlycongty.service.RelationshipService;

import com.codegym.c0319h2.quanlycongty.model.Relationship.Relationship;

import java.util.Optional;

public interface RelationshipService {
    Iterable<Relationship> findAll();

    Optional<Relationship> findById(Long id);

    Relationship showById(Long id);
//    Relationship findAllByName(String name);


}

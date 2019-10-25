package com.codegym.c0319h2.quanlycongty.service.RelationshipService.impl;

import com.codegym.c0319h2.quanlycongty.model.Relationship.Relationship;
import com.codegym.c0319h2.quanlycongty.repository.Relationship.RelationshipRepository;
import com.codegym.c0319h2.quanlycongty.service.RelationshipService.RelationshipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RelationshipServiceImpl implements RelationshipService {
    @Autowired
    private RelationshipRepository relationshipRepository;
    @Override
    public Iterable<Relationship> findAll() {
        return relationshipRepository.findAll();
    }

    @Override
    public Optional<Relationship> findById(Long id) {
        return relationshipRepository.findById(id);
    }

//    @Override
//    public Relationship findAllByName(String name) {
//        return relationshipRepository.findAllByName(name);
//    }


}

package com.codegym.c0319h2.quanlycongty.controller;

import com.codegym.c0319h2.quanlycongty.model.Relationship.Relationship;
import com.codegym.c0319h2.quanlycongty.service.RelationshipService.RelationshipService;
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
public class RelationshipController {
    @Autowired
    private RelationshipService relationshipService;

    @GetMapping("/getAllRelationship")
    public ResponseEntity<List<Relationship>> getAllLanguage(){
        List<Relationship> relationshipList = (List<Relationship>) relationshipService.findAll();
        if (relationshipList.isEmpty()){
            return new ResponseEntity<List<Relationship>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Relationship>>(relationshipList,HttpStatus.OK);
    }

    @GetMapping("/Relationship/{id}")
    public ResponseEntity<Relationship> findByid(@PathVariable Long id) {
        Optional<Relationship> relationship = relationshipService.findById(id);
        Relationship getRelationship = relationship.get();
        if (getRelationship==null) {
            return new ResponseEntity<Relationship>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Relationship>(getRelationship, HttpStatus.OK);
    }
}

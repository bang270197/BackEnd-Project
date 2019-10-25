package com.codegym.c0319h2.quanlycongty.controller;

import com.codegym.c0319h2.quanlycongty.model.Specialize.Specialize;
import com.codegym.c0319h2.quanlycongty.service.SpecializeService.SpecializeService;
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
public class SpecializeController {
    @Autowired
    private SpecializeService specializeService;

    @GetMapping("/getAllSpecialize")
    public ResponseEntity<List<Specialize>> getAllLanguage(){
        List<Specialize> specializeList = (List<Specialize>) specializeService.findAll();
        if (specializeList.isEmpty()){
            return new ResponseEntity<List<Specialize>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Specialize>>(specializeList,HttpStatus.OK);
    }

    @GetMapping("/Specialize/{id}")
    public ResponseEntity<Specialize> findByid(@PathVariable Long id) {
        Optional<Specialize> specialize = specializeService.findById(id);
        Specialize getSpecialize = specialize.get();
        if (getSpecialize==null) {
            return new ResponseEntity<Specialize>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Specialize>(getSpecialize, HttpStatus.OK);
    }
}

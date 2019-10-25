package com.codegym.c0319h2.quanlycongty.controller;

import com.codegym.c0319h2.quanlycongty.model.Language.Language;
import com.codegym.c0319h2.quanlycongty.service.LanguageService.LanguageService;
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
public class LanguageController {
    @Autowired
    private LanguageService languageService;

    @GetMapping("/getAllLanguage")
    public ResponseEntity<List<Language>> getAllLanguage(){
        List<Language> languageList = (List<Language>) languageService.findAll();
        if (languageList.isEmpty()){
            return new ResponseEntity<List<Language>>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Language>>(languageList,HttpStatus.OK);
    }

    @GetMapping("/Language/{id}")
    public ResponseEntity<Language> findByid(@PathVariable Long id) {
        Optional<Language> language = languageService.findById(id);
        Language getLanguage = language.get();
        if (getLanguage==null) {
            return new ResponseEntity<Language>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Language>(getLanguage, HttpStatus.OK);
    }
}

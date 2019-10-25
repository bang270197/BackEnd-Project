package com.codegym.c0319h2.quanlycongty.controller;

import com.codegym.c0319h2.quanlycongty.model.Tag.Tags;
import com.codegym.c0319h2.quanlycongty.service.TagService.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class TagsController {
    @Autowired
    private TagService tagService;

    @GetMapping("/tag")
    public ResponseEntity<List<Tags>> findAllTag(){
        List<Tags> tags = (List<Tags>) tagService.findAll();
        if (tags == null){
            return new ResponseEntity<List<Tags>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Tags>>(tags,HttpStatus.OK);
    }

    @PostMapping("/tag")
    public ResponseEntity<Tags> createTags(@RequestBody Tags tags){
        tagService.save(tags);
        return new ResponseEntity<Tags>(tags,HttpStatus.CREATED);
    }

    @PutMapping("/tag/{id}")
    public ResponseEntity<Tags> editTags(@PathVariable Long id,@RequestBody Tags tags){
        Optional<Tags> tags1 = tagService.findById(id);
        Tags tags2 = tags1.get();
        if (tags2 == null){
            return new ResponseEntity<Tags>(HttpStatus.NO_CONTENT);
        }
        tags2.setName(tags.getName());
        tagService.save(tags2);
        return new ResponseEntity<Tags>(tags2,HttpStatus.OK);
    }

    @GetMapping("/tag/{id}")
    public ResponseEntity<Tags> getTag(@PathVariable Long id){
        Optional<Tags> tags = tagService.findById(id);
        Tags tags1 = tags.get();
        if (tags1 == null){
            return new ResponseEntity<Tags>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<Tags>(tags1,HttpStatus.OK);
    }

    @DeleteMapping("/tag/{id}")
    public ResponseEntity<Void> deleteTag(@PathVariable Long id){
        Optional<Tags> tags = tagService.findById(id);
        Tags tags1 = tags.get();
        if (tags1 == null){
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        tagService.remove(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

}

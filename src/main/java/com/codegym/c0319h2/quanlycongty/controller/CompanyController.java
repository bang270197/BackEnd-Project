package com.codegym.c0319h2.quanlycongty.controller;

import com.codegym.c0319h2.quanlycongty.model.Relationship.Relationship;
import com.codegym.c0319h2.quanlycongty.model.company.Company;

import com.codegym.c0319h2.quanlycongty.model.technology.Technology;
import com.codegym.c0319h2.quanlycongty.repository.Company.CompanyRepository;
import com.codegym.c0319h2.quanlycongty.service.RelationshipService.RelationshipService;
import com.codegym.c0319h2.quanlycongty.service.TechnologyService.TechnologyService;
import com.codegym.c0319h2.quanlycongty.service.companyService.CompanyService;
import com.codegym.c0319h2.quanlycongty.service.companyService.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
public class CompanyController {
    private CompanyService companyService;
    private FileService fileService;
    @Autowired
    private TechnologyService technologyService;
    @Autowired
    private RelationshipService relationshipService;

    @Autowired
    public CompanyController(CompanyService companyService, FileService fileService) {
        this.companyService = companyService;
        this.fileService = fileService;
    }

    @GetMapping("/company")
    public ResponseEntity<List<Company>> findAll() {
        List<Company> companyList = (List<Company>) companyService.finByActive();
        if (companyList.isEmpty()) {
            return new ResponseEntity<List<Company>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Company>>(companyList, HttpStatus.OK);
    }


    @PostMapping("/company")
    public ResponseEntity<Company> createCompany(@RequestBody Company company, UriComponentsBuilder uriComponentsBuilder) {
        companyService.save(company);
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponentsBuilder.path("/company/{id}").buildAndExpand(company.getId()).toUri());
        return new ResponseEntity<Company>(company, HttpStatus.OK);
    }


    //thay doi chang thai active thanh false
    @PutMapping("/changeActive/{id}")
    public ResponseEntity<Void> updateActive(@PathVariable("id") Long id) throws IOException {
        Optional<Company> company = companyService.findById(id);
        Company company1 = company.get();
        if (company1 == null) {
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }
        fileService.deleteLogo(company1);
        company1.setActive(false);
        companyService.save(company1);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }


    @PutMapping("/company/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable Long id, @RequestBody Company company) {
        Optional<Company> company1 = companyService.findById(id);
        Company companyUpdate = company1.get();
        if (companyUpdate == null) {
            return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
        }
        companyUpdate.setCompanyName(company.getCompanyName());
        companyUpdate.setShortname(company.getShortname());
        companyUpdate.setAddress(company.getAddress());
        companyUpdate.setWebsite(company.getWebsite());
        companyUpdate.setPhonenumber(company.getPhonenumber());
        companyUpdate.setEmail(company.getEmail());
        companyUpdate.setIntroductoryinformation(company.getIntroductoryinformation());
        companyUpdate.setRelationship(company.getRelationship());
        companyUpdate.setSpecialize(company.getSpecialize());
        companyUpdate.setLanguage(company.getLanguage());
        companyUpdate.setTechnology(company.getTechnology());
        companyUpdate.setMarket(company.getMarket());
        companyUpdate.setNote(company.getNote());
        companyUpdate.setTags(company.getTags());
        companyService.save(companyUpdate);

        return new ResponseEntity<Company>(companyUpdate, HttpStatus.OK);
    }


    @DeleteMapping("/company/{id}")
    public ResponseEntity<Void> deteleCompany(@PathVariable Long id) {
        Optional<Company> company = companyService.findById(id);
        if (!company.isPresent()) {
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
        }
        companyService.delete(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/company/{id}")
    public ResponseEntity<Company> findByid(@PathVariable Long id) {
        Optional<Company> company = companyService.findById(id);
        Company getCompany = company.get();
        if (getCompany == null) {
            return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Company>(getCompany, HttpStatus.OK);
    }


    //    thêm ảnh vào user
    @PostMapping("/addLogo/{id}")
    public ResponseEntity<Company> addAvatar(@PathVariable("id") Long id, @RequestPart("companylogo") MultipartFile file) throws IOException {
        Optional<Company> company = companyService.findById(id);
        Company company1 = company.get();
        String fileName = file.getOriginalFilename();
        if (company1 != null) {

            if (company1.getCompanylogo() != null) {
                fileService.deleteLogo(company1);
                company1.setCompanylogo(fileName);
                fileService.saveFileLogo(file);
                companyService.save(company1);
                return new ResponseEntity<Company>(company1, HttpStatus.OK);
            } else {
                company1.setCompanylogo(fileName);
                fileService.saveFileLogo(file);
                companyService.save(company1);
                return new ResponseEntity<Company>(company1, HttpStatus.OK);
            }

        } else
            return new ResponseEntity<Company>(HttpStatus.NOT_FOUND);
    }


// tim kiem 1 doi tuong + 1 text
//    @GetMapping("/searchCompany")
//    public ResponseEntity<List<Company>> findAllByCompanyName(@RequestParam("companyName") String companyName,@RequestBody Relationship relationship){
//
//        List<Company> companyIterable = (List<Company>) companyService.findAllByCompanyNameAndRelationshipContaining(companyName, relationship);
//        if (companyIterable == null){
//            return new ResponseEntity<List<Company>>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<List<Company>>(companyIterable,HttpStatus.OK);
//    }


    @PostMapping(value = "/mutilpartFile/{id}")
    public ResponseEntity<Company> updateUser(@PathVariable("id") Long id, @RequestPart("companyavatar") MultipartFile[] file) throws IOException {
        //avatar
        // Khoi tao mang ten
        ArrayList<String> fileName = new ArrayList<>();
        //khoi tao mang luu file
        ArrayList<File> saveFiles = new ArrayList<>();





        Optional<Company> company = companyService.findById(id);
        Company company1 = company.get();

        if (company1 !=null){
            if (company1.getCompanyavatar()!=null){
                fileService.deleteImage(company1);
                // luu ten file vao mang
                for (MultipartFile multipartFile : file) {
                    fileName.add(multipartFile.getOriginalFilename());
                }
                // luu mang file len serve
                for (MultipartFile multipartFile : file) {
                    fileService.saveFileLImage(multipartFile);
                }
                company1.setCompanyavatar(fileName);
                companyService.save(company1);
                return new ResponseEntity<Company>(company1,HttpStatus.OK);
            }else {
                // luu ten file vao mang
                for (MultipartFile multipartFile : file) {
                    fileName.add(multipartFile.getOriginalFilename());
                }
                // luu mang file len serve
                for (MultipartFile multipartFile : file) {
                    fileService.saveFileLImage(multipartFile);
                }
                company1.setCompanyavatar(fileName);
                companyService.save(company1);
                return new ResponseEntity<Company>(company1,HttpStatus.OK);
            }
        }else
        return new ResponseEntity<Company>(company1,HttpStatus.OK);
    }


}

















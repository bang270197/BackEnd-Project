package com.codegym.c0319h2.quanlycongty.service.companyService.impl;

import com.codegym.c0319h2.quanlycongty.model.Relationship.Relationship;
import com.codegym.c0319h2.quanlycongty.model.technology.Technology;
import com.codegym.c0319h2.quanlycongty.repository.Company.CompanyRepository;
import com.codegym.c0319h2.quanlycongty.service.companyService.CompanyService;
import com.codegym.c0319h2.quanlycongty.model.company.Company;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class CompanyServiceImpl implements CompanyService {


    private CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl (CompanyRepository companyRepository){
        this.companyRepository = companyRepository;
    }

    @Override
    public Iterable<Company> showAll() {
        return companyRepository.findAll();
    }

    @Override
    public Optional<Company> findById(Long id) {
        return companyRepository.findById(id);
    }

    @Override
    public void save(Company company) {
         companyRepository.save(company);
    }

    @Override
    public void delete(Long id) {
         companyRepository.deleteById(id);
    }

//    @Override
//    public Company findAllByCompanyName(String companyName) {
//        return companyRepository.findAllByCompanyName(companyName);
//    }


    @Override
    public Iterable<Company> finByActive() {
        return companyRepository.finByActive();
    }




    // tim kiem theo text va obj
    @Override
    public Iterable<Company> findAllByCompanyNameAndRelationshipContaining(String companyName,@Param("relationship") Relationship relationship) {
        return companyRepository.findAllByCompanyNameAndRelationshipContaining(companyName,relationship);
    }

    @Override
    public Iterable<Company> findAllByCompanyNameContaining(String companyName) {
        return companyRepository.findAllByCompanyNameContaining(companyName);
    }


}

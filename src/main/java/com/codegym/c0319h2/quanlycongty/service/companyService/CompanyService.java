package com.codegym.c0319h2.quanlycongty.service.companyService;

import com.codegym.c0319h2.quanlycongty.model.Relationship.Relationship;
import com.codegym.c0319h2.quanlycongty.model.company.Company;
import com.codegym.c0319h2.quanlycongty.model.technology.Technology;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Iterable<Company> showAll();

    Optional<Company> findById(Long id);

    void save(Company company);

    void delete(Long id);

    Company findAllByCompanyName(String companyName);

    Iterable<Company> finByActive();

//    Iterable<Company> findAllByRelationship(Relationship relationship);

    Iterable<Company> findAllByTechnologyAndRelationship(Technology technologies,Relationship relationship);


}

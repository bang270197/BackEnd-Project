package com.codegym.c0319h2.quanlycongty.service.companyService;

import com.codegym.c0319h2.quanlycongty.model.Relationship.Relationship;
import com.codegym.c0319h2.quanlycongty.model.company.Company;
import com.codegym.c0319h2.quanlycongty.model.technology.Technology;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface CompanyService {
    Iterable<Company> showAll();

    Optional<Company> findById(Long id);

    void save(Company company);

    void delete(Long id);

//    Company findAllByCompanyName(String companyName);

    Iterable<Company> finByActive();


//     tim kiem theo text va obj
//    Iterable<Company> findAllByCompanyNameAndRelationshipContaining(@Param("companyName") String companyName,@RequestBody Relationship relationship);


//    Iterable<Company> findAllByCompanyNameAndTechnologyContaining(@Param("companyName") String companyName,@Param("technology") Technology[] technology);


}

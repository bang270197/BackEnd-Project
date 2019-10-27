package com.codegym.c0319h2.quanlycongty.repository.Company;

import com.codegym.c0319h2.quanlycongty.model.Relationship.Relationship;
import com.codegym.c0319h2.quanlycongty.model.company.Company;
import com.codegym.c0319h2.quanlycongty.model.technology.Technology;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Repository
public interface CompanyRepository extends PagingAndSortingRepository< Company,Long> {
    @Query("select c from Company c where c.active = true")
    Iterable<Company> finByActive();

//    Company findAllByCompanyName(String companyName);

//    Iterable<Company> findAllByRelationship(Relationship relationship);

//    Iterable<Company> findAllByTechnologyAndRelationship(Technology technologies,Relationship relationship);

    //tim kiem theo text + obj
//     @Query("select c from Company c where lower(c.companyName) like %:companyName% and c.relationship in (:relationship)")
//    Iterable<Company> findAllByCompanyNameAndRelationshipContaining(@Param("companyName") String companyName,@Param("relationship") Relationship relationship);






         @Query("select c from Company c where lower(c.companyName) like %:companyName% and c.technology in (:technology)")
    Iterable<Company> findAllByCompanyNameAndTechnologyContaining(@Param("companyName") String companyName,@Param("technology") Technology[] technology);






}

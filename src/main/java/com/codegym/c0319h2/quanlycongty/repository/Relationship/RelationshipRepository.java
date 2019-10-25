package com.codegym.c0319h2.quanlycongty.repository.Relationship;

import com.codegym.c0319h2.quanlycongty.model.Relationship.Relationship;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface RelationshipRepository extends JpaRepository<Relationship,Long> {

//    @Query(value = "select r from Relationship r where r.name  like '%name%' ")
//    Relationship findAllByName(@Param("name") String name);
}

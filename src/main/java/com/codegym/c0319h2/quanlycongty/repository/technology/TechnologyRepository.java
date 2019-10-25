package com.codegym.c0319h2.quanlycongty.repository.technology;

import com.codegym.c0319h2.quanlycongty.model.technology.Technology;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TechnologyRepository extends JpaRepository<Technology,Long> {


}

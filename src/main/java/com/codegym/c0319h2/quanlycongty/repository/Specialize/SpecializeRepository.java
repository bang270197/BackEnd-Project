package com.codegym.c0319h2.quanlycongty.repository.Specialize;

import com.codegym.c0319h2.quanlycongty.model.Specialize.Specialize;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecializeRepository extends JpaRepository<Specialize,Long> {
}

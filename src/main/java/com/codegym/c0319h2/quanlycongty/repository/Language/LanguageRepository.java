package com.codegym.c0319h2.quanlycongty.repository.Language;

import com.codegym.c0319h2.quanlycongty.model.Language.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageRepository extends JpaRepository<Language,Long> {
}

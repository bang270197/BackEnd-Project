package com.codegym.c0319h2.quanlycongty.repository.Tag;

import com.codegym.c0319h2.quanlycongty.model.Tag.Tags;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends PagingAndSortingRepository<Tags,Long> {
}

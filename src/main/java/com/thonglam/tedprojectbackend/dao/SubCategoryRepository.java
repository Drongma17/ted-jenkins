package com.thonglam.tedprojectbackend.dao;

import com.thonglam.tedprojectbackend.dto.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {
    List<SubCategory> getSubcategoryBysubCategoryId( Integer id);
    List<SubCategory> getSubcategoryBysubCategoryName(String subCategoryName);
}

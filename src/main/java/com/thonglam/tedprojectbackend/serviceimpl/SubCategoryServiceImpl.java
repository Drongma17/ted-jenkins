package com.thonglam.tedprojectbackend.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thonglam.tedprojectbackend.dao.SubCategoryRepository;
import com.thonglam.tedprojectbackend.dto.SubCategory;
import com.thonglam.tedprojectbackend.service.SubCategoryService;


@Service("subCategoryService")
public class SubCategoryServiceImpl implements SubCategoryService{

    @Autowired
    SubCategoryRepository subCategoryRepository;


    public List<SubCategory> getByChildCategory(Integer childCategory) {
        List<SubCategory>  subcategories = subCategoryRepository.getSubcategoryBysubCategoryId(childCategory);
        return subcategories;
    }

    public SubCategory getById(int id) {
        return subCategoryRepository.getOne(id);
    }

    public List<SubCategory> getByName( String name) {
        List<SubCategory> subcategories = subCategoryRepository.getSubcategoryBysubCategoryName(name);
        return subcategories;
    }

    public SubCategory saveSubCategory(SubCategory subcategory) {
        subCategoryRepository.save(subcategory);
        return subcategory;
    }
}

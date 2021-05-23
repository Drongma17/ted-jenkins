package com.thonglam.tedprojectbackend.service;

import java.util.List;

import com.thonglam.tedprojectbackend.dto.SubCategory;

public interface SubCategoryService {


    public List<SubCategory> getByChildCategory(Integer childCategory);
    public SubCategory getById(int id);
    public List<SubCategory> getByName( String name);
    public SubCategory saveSubCategory(SubCategory subcategory);

}

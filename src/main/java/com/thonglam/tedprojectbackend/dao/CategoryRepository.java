package com.thonglam.tedprojectbackend.dao;


import com.thonglam.tedprojectbackend.dto.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}

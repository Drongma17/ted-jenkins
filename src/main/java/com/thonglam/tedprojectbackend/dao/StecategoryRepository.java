package com.thonglam.tedprojectbackend.dao;

import com.thonglam.tedprojectbackend.dto.Stecategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StecategoryRepository extends JpaRepository<Stecategory, Integer> {
}

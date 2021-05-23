package com.thonglam.tedprojectbackend.dao;

import com.thonglam.tedprojectbackend.dto.Bacategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BacategoryRepository extends JpaRepository<Bacategory, Integer> {
}

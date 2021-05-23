package com.thonglam.tedprojectbackend.dao;

import com.thonglam.tedprojectbackend.dto.Entrepreneurs;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;

public interface EntrepreneursDao extends JpaRepository<Entrepreneurs, Long> {
    List<Entrepreneurs> getEntrepreneursByCategoryName(String categoryName);
}

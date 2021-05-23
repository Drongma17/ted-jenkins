package com.thonglam.tedprojectbackend.dao;

import com.thonglam.tedprojectbackend.dto.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository  extends JpaRepository<Application, Long> {
    List<Application> getApplicationByCategoryName(String categoryName);
}

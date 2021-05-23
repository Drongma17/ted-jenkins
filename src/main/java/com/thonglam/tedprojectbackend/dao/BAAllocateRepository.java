package com.thonglam.tedprojectbackend.dao;

import com.thonglam.tedprojectbackend.dto.BAAllocate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface BAAllocateRepository extends JpaRepository<BAAllocate, Integer> {
    List<BAAllocate> getBAAllocateByBusinessacId(Long id);
}

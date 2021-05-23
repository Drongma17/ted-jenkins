package com.thonglam.tedprojectbackend.dao;

import com.thonglam.tedprojectbackend.dto.EhubAllocate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EhubAllocateRepository extends JpaRepository<EhubAllocate, Integer> {
    List<EhubAllocate> getEhubAllocateByEhubId(Long id);
}

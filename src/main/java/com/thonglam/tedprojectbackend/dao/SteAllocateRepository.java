package com.thonglam.tedprojectbackend.dao;

import com.thonglam.tedprojectbackend.dto.SteAllocate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SteAllocateRepository extends JpaRepository<SteAllocate, Integer> {
    List<SteAllocate> getSteAllocateBySteId(Long id);
}

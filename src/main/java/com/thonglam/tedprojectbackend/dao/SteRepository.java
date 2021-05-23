package com.thonglam.tedprojectbackend.dao;

import com.thonglam.tedprojectbackend.dto.Ste;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SteRepository extends JpaRepository<Ste, Long> {
    List<Ste> getSteBySteCategoryName(String steCategoryName);
}

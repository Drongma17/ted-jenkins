package com.thonglam.tedprojectbackend.dao;

import com.thonglam.tedprojectbackend.dto.IncubationAllot;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IncubatonallotRepository extends JpaRepository<IncubationAllot, Integer> {
    List<IncubationAllot> getIncubationAllotByEntrepreneurId(Long id);
}

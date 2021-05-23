package com.thonglam.tedprojectbackend.dao;

import com.thonglam.tedprojectbackend.dto.Businessac;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BusinessacRepository extends JpaRepository<Businessac, Long> {
    List<Businessac> getBusinessacBybaCategoryName(String baCategoryName);
}

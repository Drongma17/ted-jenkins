package com.thonglam.tedprojectbackend.dao;

import com.thonglam.tedprojectbackend.dto.Ehub;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EhubRepository extends JpaRepository<Ehub, Long> {
    List<Ehub> getEhubByehubCategoryName(String ehubCategoryName);
}

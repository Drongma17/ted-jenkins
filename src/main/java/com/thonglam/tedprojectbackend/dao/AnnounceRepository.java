package com.thonglam.tedprojectbackend.dao;

import com.thonglam.tedprojectbackend.dto.Announce;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnnounceRepository extends JpaRepository<Announce, Integer> {
}

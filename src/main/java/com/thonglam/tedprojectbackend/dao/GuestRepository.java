package com.thonglam.tedprojectbackend.dao;

import com.thonglam.tedprojectbackend.dto.Guest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, Integer> {
}

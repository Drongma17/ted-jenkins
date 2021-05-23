package com.thonglam.tedprojectbackend.dao;

import com.thonglam.tedprojectbackend.dto.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Events, Long> {
}

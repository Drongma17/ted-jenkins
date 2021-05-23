package com.thonglam.tedprojectbackend.dao;

import com.thonglam.tedprojectbackend.dto.Gallery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryRepository extends JpaRepository<Gallery, Integer> {
}

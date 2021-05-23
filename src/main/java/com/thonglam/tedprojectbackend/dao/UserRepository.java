package com.thonglam.tedprojectbackend.dao;

import com.thonglam.tedprojectbackend.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
  User findByEmailIgnoreCase(String email);
}

package com.thonglam.tedprojectbackend.service;

import com.thonglam.tedprojectbackend.dto.User;

import java.util.List;
import java.util.Optional;

public interface UserService {



    User save(User user);
    List<User> findAll();
    User getUserByEmail(String name);

    Optional<User> updateUser(Long userId, User user);
    Optional<String> deleteUser(Long userId);

}

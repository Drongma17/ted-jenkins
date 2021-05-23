package com.thonglam.tedprojectbackend.serviceimpl;



import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thonglam.tedprojectbackend.dao.UserRepository;
import com.thonglam.tedprojectbackend.dto.User;
import com.thonglam.tedprojectbackend.service.UserService;
import com.thonglam.tedprojectbackend.util.PasswordUtil;


@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    @Autowired
    private BCryptPasswordEncoder passwordEncoder;



    @Override
    public User save(User user) {
     String password =PasswordUtil.getPasswordHash(user.getPassword());
     user.setPassword(password);
     user.setCreatedDate(new Date());
        return userRepository.save(user);
    }

    @Override
    public List<User> findAll() {
        return (List<User>) userRepository.findAll();
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmailIgnoreCase(email);
    }

    @Override
    public Optional<User> updateUser(Long userId, User userPerson) {
       return userRepository.findById(userId)
             .map(user ->{
                 user.setUsername(userPerson.getUsername());
                 user.setEmail(userPerson.getEmail());
                 user.setPassword(userPerson.getPassword());
                 user.setPhoneNumber(userPerson.getPhoneNumber());
                 user.setRole(userPerson.getRole());
                 user.setCreatedDate(userPerson.getCreatedDate());
                 return userRepository.save(user);
             });
    }


    @Override
    public Optional<String> deleteUser(Long userId) {
        return userRepository.findById(userId)
                .map(user->{
                    userRepository.delete(user);
                    return "One User is deleted successfully";
                });
    }


}

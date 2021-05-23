package com.thonglam.tedprojectbackend.serviceimpl;



import com.thonglam.tedprojectbackend.dao.UserRepository;
import com.thonglam.tedprojectbackend.dto.User;
import com.thonglam.tedprojectbackend.security.JwtUserFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class JwtUserDetailServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmailIgnoreCase(username);
        if(user ==null){
            throw new UsernameNotFoundException(String.format("No user found with this username '%s'.", username));
        }else {
            return JwtUserFactory.create(user);
        }

    }
}

package com.thonglam.tedprojectbackend.security;

import com.thonglam.tedprojectbackend.dto.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.*;
import java.util.stream.Collectors;

public class JwtUserFactory {
    public static JwtUser create(User user) {
        return new JwtUser(user.getUser_id(), user.getEmail(), user.getPassword(),user, maptoGrantedAuthorities(new ArrayList<String>(Arrays.asList("ROLE_"+ user.getRole()))), user.isEnabled());
    }

    private static List<GrantedAuthority> maptoGrantedAuthorities(List<String> authorities) {
        return authorities.stream().map(authority -> new SimpleGrantedAuthority(authority)).collect(Collectors.toList());
    }


}

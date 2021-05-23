package com.thonglam.tedprojectbackend.controller;



import com.thonglam.tedprojectbackend.domain.UserDTO;
import com.thonglam.tedprojectbackend.dto.User;
import com.thonglam.tedprojectbackend.exception.UnAuthorizedException;
import com.thonglam.tedprojectbackend.security.JwtTokenUtil;
import com.thonglam.tedprojectbackend.security.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
public class AuthenticationController {


    @Value("${jwt.header}")
    private String tokenHeader;


    @Autowired
    private AuthenticationManager authenticationManager;

   @Autowired
    private JwtTokenUtil jwtTokenUtil;


   @PostMapping(value = "/login")
   public ResponseEntity<UserDTO> login(@RequestBody User user, HttpServletRequest request, HttpServletResponse response){

       try {
           Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword()));
           SecurityContextHolder.getContext().setAuthentication(authentication);
           final JwtUser userDetails =(JwtUser)authentication.getPrincipal();
           final String token =jwtTokenUtil.generateToken(userDetails);
           response.setHeader("Token", token);
           return new ResponseEntity<UserDTO>(new UserDTO(userDetails.getUser(), token), HttpStatus.OK);
       }catch (Exception e){
              throw new UnAuthorizedException(e.getMessage());
       }
   }


}

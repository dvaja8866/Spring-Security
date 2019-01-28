package com.example.springbootsecurity.securitydbexample.service;

import com.example.springbootsecurity.securitydbexample.model.CustomUserDetails;
import com.example.springbootsecurity.securitydbexample.model.Users;
import com.example.springbootsecurity.securitydbexample.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> optionalUsers = userRepository.findByName(username);

        optionalUsers.orElseThrow(() -> new UsernameNotFoundException("UserName Not Found"));

        return optionalUsers.map(CustomUserDetails::new).get();


    }
}

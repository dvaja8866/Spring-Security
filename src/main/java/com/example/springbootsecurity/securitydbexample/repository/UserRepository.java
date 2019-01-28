package com.example.springbootsecurity.securitydbexample.repository;

import com.example.springbootsecurity.securitydbexample.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<Users,Integer> {


    Optional<Users> findByName(String username);
}

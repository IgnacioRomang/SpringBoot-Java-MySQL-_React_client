package com.example.ejemplo.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.ejemplo.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}

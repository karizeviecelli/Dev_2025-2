package com.senai.demo.repositories;

import com.senai.demo.entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    Boolean existsByEmail(String email);
    Optional<UserModel> findByEmail(String email);
}

package com.senai.demo.repositories;

import com.senai.demo.entities.TaskModel;
import com.senai.demo.entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {
    Optional<TaskModel> findByUser(UserModel userModel);
}

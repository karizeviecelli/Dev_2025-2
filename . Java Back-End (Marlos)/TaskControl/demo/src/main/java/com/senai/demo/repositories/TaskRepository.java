package com.senai.demo.repositories;

import com.senai.demo.entities.TaskModel;
import com.senai.demo.entities.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.config.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskModel, Long> {
    Optional<TaskModel> findByUser(UserModel userModel);

    List<TaskModel> findAllByUser(UserModel user);
}

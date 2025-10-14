package com.Task_springboot.repositories;

import com.Task_springboot.models.TaskModel;
import com.Task_springboot.models.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TaskRepository extends JpaRepository<TaskModel,Long> {
    Optional<TaskModel> findByUserModel(UserModel usuario);

}
//Como eu preciso validar o usuário por e-mail, o próprio JPA indica que você crie esse metodo.
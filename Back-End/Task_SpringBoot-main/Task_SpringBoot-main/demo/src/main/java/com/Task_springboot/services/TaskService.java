package com.Task_springboot.services;

import com.Task_springboot.dtos.MensagemDTO;
import com.Task_springboot.dtos.UserDTO;
import com.Task_springboot.models.UserModel;
import com.Task_springboot.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    //InserirTarefas




    //ObterTarefas




    //atualizaTarefas



    //excluirTarefas
}

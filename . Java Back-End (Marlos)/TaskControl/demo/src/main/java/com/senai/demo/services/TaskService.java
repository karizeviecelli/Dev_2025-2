package com.senai.demo.services;

import com.senai.demo.dtos.MessageDto;
import com.senai.demo.dtos.TaskDto;
import com.senai.demo.entities.TaskModel;
import com.senai.demo.entities.UserModel;
import com.senai.demo.repositories.TaskRepository;
import com.senai.demo.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private TaskRepository taskRepository;
    private UserRepository userRepository;

    public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    public List<TaskDto> getTask() {
        List<TaskDto> listTaskDto = new ArrayList<>();
        List<TaskModel> listTaskModel = taskRepository.findAll();

        for (TaskModel task : listTaskModel){
            TaskDto taskDto = new TaskDto();
            taskDto.setId(task.getId());
            taskDto.setDescription(task.getDescription());
            taskDto.setTitle(task.getTitle());
            taskDto.setStatus(task.getStatus());
            taskDto.setSchedulingDate(task.getSchedulingDate());
            taskDto.setEmailUser(task.getUser().getEmail());
            listTaskDto.add(taskDto);
        }

        return listTaskDto;
    }

    public MessageDto createTask(@Valid TaskDto taskDto) {
        MessageDto messageDto = new MessageDto();
        TaskModel taskModel = new TaskModel();
        //Esse optional serve para pegar o User, para validar e colocar vinculado a tarefa
        Optional<UserModel> userOp = userRepository.findByEmail(taskDto.getEmailUser());

        if (!userOp.isPresent()) {
            messageDto.setMessage("Usuário informado não foi encontrado");
            return messageDto;
        }

        List<TaskModel> taskOp = taskRepository.findAllByUser(userOp.get());
        //Se taskOp não estiver vazio ele entra no if
        if (!taskOp.isEmpty()) {
            // Verifica se ja não tem uma tarefa para aquele dia
            for (TaskModel task : taskOp) {
                if (taskDto.getSchedulingDate().equals(task.getSchedulingDate())) {
                    messageDto.setMessage("Usuário já possui agenda para a data informada");
                    return messageDto;
                }
            }
        }
        taskModel.setStatus(taskDto.getStatus());
        taskModel.setSchedulingDate(taskDto.getSchedulingDate());
        taskModel.setTitle(taskDto.getTitle());
        taskModel.setDescription(taskDto.getDescription());
        taskModel.setUser(userOp.get());

        taskRepository.save(taskModel);
        messageDto.setMessage("Tarefa inserida com sucesso");
        return messageDto;
    }


    public MessageDto alterTask(@Valid TaskDto taskDto, Long id) {
        MessageDto messageDto = new MessageDto();

        Optional<TaskModel> taskOp = taskRepository.findById(id);
        //Faz validação para saber se o Id passado pelo front corresponde a algum
        if (!taskOp.isPresent()){
            messageDto.setMessage("Tarefa não encontrada");
            return messageDto;
        }

        TaskModel task = new TaskModel();
        Optional<UserModel> userOp = userRepository.findByEmail(taskDto.getEmailUser());
        //Faz validação para ver se o usuário que será o dono da tarefa existe
        if (!userOp.isPresent()){
            messageDto.setMessage("Usuário da tarefa não encontrado");
            return messageDto;
        }

        task.setUser(userOp.get());
        task.setId(taskOp.get().getId());
        task.setTitle(taskDto.getTitle());
        task.setDescription(taskDto.getDescription());
        task.setSchedulingDate(taskDto.getSchedulingDate());
        task.setStatus(taskDto.getStatus());

        messageDto.setMessage("Usuário atualizado com sucesso");
        return messageDto;
    }

    public MessageDto deleteTask(Long id) {
        MessageDto messageDto = new MessageDto();
        return messageDto;
    }
}

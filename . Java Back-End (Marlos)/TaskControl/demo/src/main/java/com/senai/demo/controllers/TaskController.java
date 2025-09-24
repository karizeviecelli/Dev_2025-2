package com.senai.demo.controllers;

import co.elastic.clients.elasticsearch.nodes.Http;
import com.senai.demo.dtos.MessageDto;
import com.senai.demo.dtos.TaskDto;
import com.senai.demo.services.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.config.Task;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/task")
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<TaskDto>> getTasks() {
        List<TaskDto> listTaskDto = taskService.getUsers();

        if (listTaskDto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(listTaskDto);
        }

        return ResponseEntity.ok(listTaskDto);
    }

    @PostMapping
    public ResponseEntity<MessageDto> createTask(@RequestBody @Valid TaskDto taskDto) {
        MessageDto messageDto = taskService.createTask(taskDto);

        if (messageDto.getMessage().equals("Tarefa inserida com sucesso")) {
            return ResponseEntity.ok(messageDto);
        }

        if (messageDto.getMessage().equals("Usuário da tarefa não foi encontrado")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageDto);
        }

        if (messageDto.getMessage().equals("Usuário já possui agenda para a data informada")) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(messageDto);
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(messageDto);

    }

    @PutMapping("/{id}")
    public ResponseEntity<MessageDto> alterTask(@RequestBody @Valid TaskDto taskDto, @PathVariable("id") Long id) {
        MessageDto messageDto = taskService.alterTask(taskDto, id);

        if (messageDto.getMessage().equals("Tarefa não encontrada")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageDto);
        }
        if (messageDto.getMessage().equals("Usuário da tarefa não encontrado")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageDto);
        }

        return ResponseEntity.ok(messageDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageDto> deleteTask(@PathVariable("id") Long id) {
        MessageDto messageDto = taskService.deleteTask(id);

        if (messageDto.getMessage().equals("Tarefa não encontrada")){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageDto);
        }

        return ResponseEntity.ok(messageDto);
    }


}

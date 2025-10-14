package com.Task_springboot.controllers;

import com.Task_springboot.services.TaskService;
import com.Task_springboot.services.UserService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/Tarefas")
public class TaskController {

    //Injeção de depêndencia - CHECK
    private final TaskService taskService;

    private final UserService userService;

    public TaskController(TaskService taskService, UserService userService) {
        this.taskService = taskService;
        this.userService = userService;
    }


}

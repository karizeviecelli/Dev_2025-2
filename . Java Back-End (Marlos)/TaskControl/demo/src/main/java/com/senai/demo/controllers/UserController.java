package com.senai.demo.controllers;

import com.senai.demo.dtos.MessageDto;
import com.senai.demo.dtos.UserDto;
import com.senai.demo.services.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers() {
        List<UserDto> listUsersDto = userService.listUsers();

        if (listUsersDto.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(listUsersDto);
        }
        return ResponseEntity.ok(listUsersDto);
    }

    @GetMapping("/{email}")
    public ResponseEntity<Object> getUser(@PathVariable("email") String emailUser){
        Object userDto = userService.getUser(emailUser);

        if (userDto instanceof MessageDto){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(userDto);
        }

        return ResponseEntity.ok(userDto);
    }

    @PostMapping
    public ResponseEntity<MessageDto> createUser(@RequestBody @Valid UserDto userDto) {
        MessageDto messageDto = userService.createUser(userDto);

        if (messageDto.getMessage().equals("Usuário inserido com sucesso")) {
            return ResponseEntity.ok(messageDto);
        }

        return ResponseEntity.status(HttpStatus.CONFLICT).body(messageDto);
    }

    @PutMapping("/{email}")
    public ResponseEntity<MessageDto> alterUser(@RequestBody @Valid UserDto userDto, @PathVariable("email") String emailUser) {
        MessageDto messageDto = userService.alterUser(userDto, emailUser);

        if (messageDto.getMessage().equals("Usuário alterado com sucesso")) {
            return ResponseEntity.ok(messageDto);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageDto);
    }

    @DeleteMapping("/{email}")
    public ResponseEntity<MessageDto> deleteUser(@PathVariable("email") String emailUser){
        MessageDto messageDto = userService.deleteUser(emailUser);

        if (messageDto.getMessage().equals("Usuário excluído com sucesso")) {
            return ResponseEntity.ok(messageDto);
        }
        if (messageDto.getMessage().equals("Usuário vinculado em tarefas")){
            return ResponseEntity.status(HttpStatus.CONFLICT).body(messageDto);
        }

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(messageDto);

    }

}

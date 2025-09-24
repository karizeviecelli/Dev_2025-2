package com.senai.demo.services;

import com.senai.demo.dtos.MessageDto;
import com.senai.demo.dtos.UserDto;
import com.senai.demo.entities.TaskModel;
import com.senai.demo.entities.UserModel;
import com.senai.demo.repositories.TaskRepository;
import com.senai.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private UserRepository userRepository;
    private TaskRepository taskRepository;

    public UserService(UserRepository userRepository, TaskRepository taskRepository) {
        this.userRepository = userRepository;
        this.taskRepository = taskRepository;
    }

    public List<UserDto> listUsers() {
        List<UserDto> listUsersDto = new ArrayList<>();
        List<UserModel> listUsers = userRepository.findAll();

        for (UserModel user : listUsers) {
            UserDto userDto = new UserDto();
            userDto.setName(user.getName());
            userDto.setEmail(user.getEmail());
            listUsersDto.add(userDto);
        }
        return listUsersDto;
    }

    public Object getUser(String emailUser) {
        Optional<UserModel> userOp = userRepository.findByEmail(emailUser);

        if (!userOp.isPresent()) {
            MessageDto messageDto = new MessageDto();
            messageDto.setMessage("Esse email não está vinculado a nenhum usuário!");
            return messageDto;
        }

        UserDto userDto = new UserDto();
        userDto.setName(userOp.get().getName());
        userDto.setEmail(userOp.get().getEmail());
        return userDto;
    }

    public MessageDto createUser(UserDto userDto) {
        MessageDto messageDto = new MessageDto();
        UserModel user = new UserModel();

        if (userRepository.existsByEmail(userDto.getEmail())) {
            messageDto.setMessage("Usuário já existe!");
            return messageDto;
        }

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        userRepository.save(user);
        messageDto.setMessage("Usuário inserido com sucesso");
        return messageDto;
    }

    public MessageDto alterUser(UserDto userDto, String emailUser) {
        MessageDto messageDto = new MessageDto();
        Optional<UserModel> userOp = userRepository.findByEmail(emailUser);

        if (!userOp.isPresent()) {
            messageDto.setMessage("Usuário não existe no banco");
            return messageDto;
        }
        UserModel user = new UserModel();

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setId(userOp.get().getId());
        userRepository.save(user);

        messageDto.setMessage("Usuário alterado com sucesso");
        return messageDto;
    }


    public MessageDto deleteUser(String emailUser) {
        MessageDto messageDto = new MessageDto();

        Optional<UserModel> userOp = userRepository.findByEmail(emailUser);


        if (!userOp.isPresent()) {
            messageDto.setMessage("Usuário não existe!");
            return messageDto;
        }

        Optional<TaskModel> taskOp = taskRepository.findByUser(userOp.get());
        if (taskOp.isPresent()) {
            if (taskOp.get().getUser().equals(userOp.get())) {
                messageDto.setMessage("Usuário vinculado em tarefas");
                return messageDto;
            }
        }

        userRepository.delete(userOp.get());
        messageDto.setMessage("Usuário excluído com sucesso");
        return messageDto;
    }


}

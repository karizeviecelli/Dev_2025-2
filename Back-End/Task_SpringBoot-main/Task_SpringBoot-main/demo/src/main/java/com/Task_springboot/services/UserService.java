package com.Task_springboot.services;

import com.Task_springboot.dtos.MensagemDTO;
import com.Task_springboot.dtos.UserDTO;
import com.Task_springboot.models.TaskModel;
import com.Task_springboot.models.UserModel;
import com.Task_springboot.repositories.TaskRepository;
import com.Task_springboot.repositories.UserRepository;
import jakarta.persistence.Id;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repository;
    private final TaskRepository taskRepository;

    public UserService(UserRepository repository, TaskRepository taskRepository) {
        this.repository = repository;
        this.taskRepository = taskRepository;
    }

    //InserirUsários
    public MensagemDTO inseriUsuario(UserDTO userDados) {

        Optional<UserModel> userOP = repository.findByEmail(userDados.getEmail());
        MensagemDTO msg = new MensagemDTO();
        if (userOP.isPresent()) {
            msg.setMsg("Este usuário já existe!");
            return msg;
        } else {
            UserModel usuarioModel = new UserModel();
            usuarioModel.setEmail(userDados.getEmail());
            usuarioModel.setNome(userDados.getNome());
            repository.save(usuarioModel);
            msg.setMsg("Sucesso!");
        }
        return msg;

    }

    //Listar Usuários inseridos
    public List<UserDTO> obtendoUsuarios() {

        MensagemDTO msg = new MensagemDTO();

        List<UserDTO> listaUserDTO = new ArrayList<>();

        List<UserModel> listaUserModel = repository.findAll();

        for (UserModel verificando : listaUserModel) {
            UserDTO userDTO = new UserDTO();
            userDTO.setEmail(verificando.getEmail());
            userDTO.setNome(verificando.getNome());
            listaUserDTO.add(userDTO);
        }
        return listaUserDTO;
    }

    //AtualizarUsários
    public MensagemDTO atualizandoUsuario(String email, UserDTO userDados){

        MensagemDTO msg = new MensagemDTO();

        Optional<UserModel> userOP = repository.findByEmail(userDados.getEmail());

        if (userOP.isPresent()) {

            UserModel attUser = new UserModel();

            attUser.setEmail(userDados.getEmail());
            attUser.setNome(userDados.getNome());
            repository.save(attUser);
            msg.setMsg("Usuário alterado com sucesso!");
            return msg;
        }
            msg.setMsg("Usuário não encontrado!");
            return msg;
    }




    //ExcluirUsuários
    public MensagemDTO excluir(UserDTO userDados) {

        MensagemDTO msg = new MensagemDTO();

        Optional<UserModel> userOP = repository.findByEmail(userDados.getEmail());

        if (userOP.isPresent()) {

            Optional<TaskModel> taskMD = taskRepository.findByUserModel(userOP.get());

            if (taskMD.isPresent()){
                msg.setMsg("Usuário vinculado a tarefa!");
                return msg;
            }
            repository.delete(userOP.get());
            msg.setMsg("Usuário deletado!");
            return  msg;
        }
        msg.setMsg("Usuário não encontrado!");
        return  msg;
    }


}
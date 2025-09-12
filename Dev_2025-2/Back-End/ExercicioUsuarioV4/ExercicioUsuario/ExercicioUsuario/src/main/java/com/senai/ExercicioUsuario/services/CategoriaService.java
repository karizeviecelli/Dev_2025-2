package com.senai.ExercicioUsuario.services;

import com.senai.ExercicioUsuario.dtos.CategoriaRequisicaoDto;
import com.senai.ExercicioUsuario.dtos.CategoriaRespostaDto;
import com.senai.ExercicioUsuario.dtos.MensagemDto;
import com.senai.ExercicioUsuario.models.CategoriaModel;
import com.senai.ExercicioUsuario.models.UsuarioModel;
import com.senai.ExercicioUsuario.repositories.CategoriaRepository;
import com.senai.ExercicioUsuario.repositories.UsuarioRepository;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    List<CategoriaModel> categorias = new ArrayList<>();
    private Long categoriaId = (long) 0;
    private   CategoriaRepository repository;

    public CategoriaService(CategoriaRepository repository) {
        this.repository = repository;
    }

    //Terminar em casa
    // ------------------CATEGORIA----------------------
    public MensagemDto cadastrarCategoria(CategoriaRequisicaoDto nome) {
        MensagemDto mensagem = new MensagemDto();
        CategoriaModel categoriaNova = new CategoriaModel();


        categoriaNova.setNome(nome.getNome());
        repository.save(categoriaNova);
        mensagem.setMensagemUsuario("Categoria cadastrada");

        return mensagem;
    }


    public  List<CategoriaRespostaDto> listaCategorias() {
        List<CategoriaRespostaDto> lista = new ArrayList<>();

      List<CategoriaModel>  listaCategoriaModel = repository.findAll();
            MensagemDto msg = new MensagemDto();
        for (CategoriaModel categoria : listaCategoriaModel) {
            CategoriaRespostaDto categoriaR = new CategoriaRespostaDto();

            categoriaR.setId(categoria.getId());
            categoriaR.setNome(categoria.getNome());
            lista.add(categoriaR);

        }
        msg.setMensagemUsuario("Lista não encontrada!");
        return lista;
    }

        public MensagemDto deletarCategoria(Long id) {
        MensagemDto mensagem = new MensagemDto();

        Optional<CategoriaModel> categoriaOP = repository.findById(id);


        if (categoriaOP.isPresent()){
            //Signfiica que encontrou o usuario pelo id
            repository.delete(categoriaOP.get());
            mensagem.setMensagemUsuario("Categoria deletada com sucesso");
            return mensagem;
        }

        mensagem.setMensagemUsuario("ID não localizado na lista");
        return mensagem;
    }




}

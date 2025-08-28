package com.example.cadastromed.Controller;

import com.example.cadastromed.Models.Medico;
import com.example.cadastromed.Models.Paciente;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class ListaController implements Initializable {

    @FXML
    private TableView<Medico> listasMedicos;

    @FXML
    private TableView<Paciente> listasPacientes;

    @FXML
    private TableColumn<Medico, String> medColEspecialidade;

    @FXML
    private TableColumn<Medico, String> medColIdade;

    @FXML
    private TableColumn<Medico, String> medColNome;

    @FXML
    private TableColumn<Paciente, String> pacColIdade;

    @FXML
    private TableColumn<Paciente, String> pacColNome;

    @FXML
    private TableColumn<Paciente, String> pacColSexo;

    private ObservableList<Medico> medicos;
    private ObservableList<Paciente> pacientes;

    //Recebe os dados do outro controller e guarda eles
    public void receberDados(ObservableList<Paciente> pacienteObservableList, ObservableList<Medico> medicoObservableList){
        this.pacientes = pacienteObservableList;
        this.medicos = medicoObservableList;

        if (listasMedicos != null && listasPacientes != null) {
            listasMedicos.setItems(medicos);
            listasPacientes.setItems(pacientes);
        }
    }

    @FXML
    private void excluirMedico() {
        Medico selecionado = listasMedicos.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            medicos.remove(selecionado);
        } else {
            mostrarAlerta("Selecione um médico para excluir.");
        }
    }

    @FXML
    private void excluirPaciente() {
        Paciente selecionado = listasPacientes.getSelectionModel().getSelectedItem();
        if (selecionado != null) {
            pacientes.remove(selecionado);
        } else {
            mostrarAlerta("Selecione um paciente para excluir.");
        }
    }

    //Esse método sobrescrito inicializa quando o fxml é iniciado, já colocando os valores dentro das TableViews
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        medColNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        medColIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));
        medColEspecialidade.setCellValueFactory(new PropertyValueFactory<>("especialidade"));

        pacColNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        pacColIdade.setCellValueFactory(new PropertyValueFactory<>("idade"));
        pacColSexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));

        if (medicos != null) {
            listasMedicos.setItems(medicos);
        }
        if (pacientes != null) {
            listasPacientes.setItems(pacientes);
        }
    }

    //Método para jogar um alerta na tela
    private void mostrarAlerta(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Atenção");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }

    @FXML
    private TextField campoNomePaciente;
    @FXML
    private TextField campoIdadePaciente;
    @FXML
    private TextField campoSexoPaciente;

    @FXML
    private TextField campoNomeMedico;
    @FXML
    private TextField campoIdadeMedico;
    @FXML
    private TextField campoEspecialidadeMedico;
    int conversor;
    @FXML
    private void alterarPaciente() {
        Paciente selecionado = listasPacientes.getSelectionModel().getSelectedItem();
        if (selecionado == null) {
            mostrarAlerta("Selecione um paciente para alterar.");
            return;
        }

        String novoNome = campoNomePaciente.getText().trim();
        String novaIdade = campoIdadePaciente.getText().trim();
        String novoSexo = campoSexoPaciente.getText().trim();

        if (novoNome.isEmpty() || novaIdade.isEmpty() || novoSexo.isEmpty()) {
            mostrarAlerta("Preencha todos os campos para alterar.");
            return;
        }

        selecionado.setNome(novoNome);
        conversor = Integer.parseInt(novaIdade);
        selecionado.setIdade(conversor);
        selecionado.setSexo(novoSexo);

        listasPacientes.refresh();

        campoNomePaciente.clear();
        campoIdadePaciente.clear();
        campoSexoPaciente.clear();
    }

    @FXML
    private void alterarMedico() {
        Medico selecionado = listasMedicos.getSelectionModel().getSelectedItem();
        if (selecionado == null) {
            mostrarAlerta("Selecione um médico para alterar.");
            return;
        }

        String novoNome = campoNomeMedico.getText().trim();
        String novaIdade = campoIdadeMedico.getText().trim();
        String novaEspecialidade = campoEspecialidadeMedico.getText().trim();

        if (novoNome.isEmpty() || novaIdade.isEmpty() || novaEspecialidade.isEmpty()) {
            mostrarAlerta("Preencha todos os campos para alterar.");
            return;
        }

        selecionado.setNome(novoNome);
        conversor = Integer.parseInt(novaIdade);
        selecionado.setIdade(conversor);
        selecionado.setEspecialidade(novaEspecialidade);

        listasMedicos.refresh();

        campoNomeMedico.clear();
        campoIdadeMedico.clear();
        campoEspecialidadeMedico.clear();
    }




}

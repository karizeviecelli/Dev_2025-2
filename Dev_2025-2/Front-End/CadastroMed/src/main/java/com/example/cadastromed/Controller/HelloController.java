package com.example.cadastromed.Controller;

import com.example.cadastromed.Models.Medico;
import com.example.cadastromed.Models.Paciente;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloController {

    ArrayList<Medico> medicos = new ArrayList<Medico>();
    ArrayList<Paciente> pacientes = new ArrayList<Paciente>();

    //Pega os textos dos campos
    @FXML
    void botaoMedico() {
        if (nomeMedico.getText().isBlank() ||
                idadeMedico.getText().isBlank() ||
                cpfMedico.getText().isBlank() ||
                especialidadeMedico.getText().isBlank()){
            mostrarAlerta("Preencha todos os campos!");
        } else {
            Medico medico = new Medico(
                    nomeMedico.getText(),
                    Integer.parseInt(idadeMedico.getText()),
                    cpfMedico.getText(),
                    especialidadeMedico.getText()
            );

            medicos.add(medico);
            limparMedico();
        }

    }
    //Pega os textos dos campos
    @FXML
    void botaoPaciente() {
        if (nomePaciente.getText().isBlank() ||
                        idadePaciente.getText().isBlank() ||
                        cpfPaciente.getText().isBlank() ||
                        sexoPaciente.getText().isBlank()){
            mostrarAlerta("Preencha todos os campos!");
        } else {
            Paciente paciente = new Paciente(
                    nomePaciente.getText(),
                    Integer.parseInt(idadePaciente.getText()),
                    cpfPaciente.getText(),
                    sexoPaciente.getText()
            );

            pacientes.add(paciente);
            limparPaciente();
        }
    }

    void validaPaciente(){

    }

    @FXML
    private TextField sexoPaciente;

    @FXML
    private TextField cpfMedico;

    @FXML
    private TextField cpfPaciente;

    @FXML
    private TextField especialidadeMedico;

    @FXML
    private TextField idadeMedico;

    @FXML
    private TextField idadePaciente;

    @FXML
    private TextField nomeMedico;

    @FXML
    private TextField nomePaciente;

    //Abre a tela de listas dos Pacientes e Médicos e também envia as informações via ObservableList
    @FXML
    void botaoListas(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/cadastromed/list.fxml"));
        Parent root = loader.load();

        ListaController listaController = loader.getController();
        ObservableList<Paciente> pacienteObservableList = FXCollections.observableArrayList(pacientes);
        ObservableList<Medico> medicoObservableList = FXCollections.observableArrayList(medicos);
        listaController.receberDados(pacienteObservableList,medicoObservableList);

        Stage stage = new Stage();
        stage.setScene(new Scene(root));
        stage.setTitle("Lista de Médicos e Pacientes");
        stage.show();
    }
    //Métodos para limpar os campos
    public void limparPaciente(){
        nomePaciente.setText("");
        idadePaciente.setText("");
        cpfPaciente.setText("");
        sexoPaciente.setText("");
    }

    public void limparMedico(){
        nomeMedico.setText("");
        idadeMedico.setText("");
        cpfMedico.setText("");
        especialidadeMedico.setText("");
    }

    //Método para jogar um alerta na tela
    private void mostrarAlerta(String mensagem) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        alert.setTitle("Atenção");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }
}
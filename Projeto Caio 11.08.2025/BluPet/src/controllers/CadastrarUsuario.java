package controllers;

import dao.UsuarioDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CadastrarUsuario {

    @FXML
    private Button btnCadastrarUsuario;
    @FXML
    private TextField loginField;
    @FXML
    private TextField senhaField;

    @FXML
    public void initialize() {
        btnCadastrarUsuario.setOnAction(e -> {
            UsuarioDAO.criarUsuario(loginField.getText(), senhaField.getText());
            System.out.println("Usuário cadastrado!");
        });
    }
}

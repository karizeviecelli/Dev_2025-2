package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import javafx.scene.control.TextField;
import model.Usuario;
import util.ConexaoBD;

public class UsuarioDAO {
    public void validarLogin(String login, String Senha){
        //vou comparar os parametros que entraram com cada usuario do banco para validar
       String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
       
        
    }


   

	public static void criarUsuario(String loginField, String senhaField) {
		Usuario novoUsuario = new Usuario();
        String login = loginField.toString();
        String senha = senhaField.toString();

        String sql = "INSERT INTO usuario (login, senha) VALUES (?, ?)";
		try(Connection conn = ConexaoBD.conectar();
		PreparedStatement ps = conn.prepareStatement(sql)){

		    novoUsuario.cadatrarUsuario(login, senha);
			ps.setString(1, novoUsuario.getLoginUsuario());
		    ps.setString(2, novoUsuario.getSenhaUsuario());
			
			ps.executeUpdate();
			System.out.println("Usuario criado");
			} catch( SQLException erro) {
				JOptionPane.showMessageDialog(null, "PessoaDAO"+erro.getMessage());
			}
        }
    }


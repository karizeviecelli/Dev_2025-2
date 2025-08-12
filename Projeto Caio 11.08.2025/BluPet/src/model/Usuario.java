package model;

import javax.swing.JOptionPane;

public class Usuario {
    private Integer idUsuario;
    private String loginUsuario;
    private String senhaUsuario;


 	public void cadatrarUsuario(String login, String senha) {
            this.loginUsuario = login;
            this.senhaUsuario = senha;
	}





    public Integer getIdUsuario() {
        return idUsuario;
    }
    public String getLoginUsuario() {
        return loginUsuario;
    }public String getSenhaUsuario() {
        return senhaUsuario;
    }
    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }
    public void setLoginUsuario(String loginUsuario) {
        this.loginUsuario = loginUsuario;
    }
    public void setSenhaUsuario(String senhaUsuario) {
        this.senhaUsuario = senhaUsuario;
    }





}

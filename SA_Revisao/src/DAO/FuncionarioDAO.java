package DAO;

import Conexao.Conexao;
import Model.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO {

    public static boolean create(Funcionario funcionario) {
        try {
            String sql = "INSERT INTO Funcionario(nome,dt_nascimento,cpf,salario,cargo ) values (?,?,?,?,?)";
            PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);

            LocalDate dt_nasc = funcionario.getDt_nas();

            ps.setString(1, funcionario.getNome());
            ps.setDate(2, java.sql.Date.valueOf(dt_nasc));
            ps.setString(3, funcionario.getCpf());
            ps.setDouble(4, funcionario.getSalario());
            ps.setString(5, funcionario.getCargo());
            ps.executeUpdate();
            ps.close();
            return true;
        } catch (Exception e) {
            return false;
        }

    }

    public static boolean remove(int idFuncionario)  {
        try{
        String sql = "DELETE FROM funcionario where id = ?";
        PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
        ps.setInt(1, idFuncionario);

        int linhasAfetadas = ps.executeUpdate();

        if (linhasAfetadas > 0) {
            System.out.println("funcionario deletado");
            ps.close();
            return true;
        }
            System.out.println("Usuaio não deletado");
            return false;
        }catch(Exception e){
            System.out.println("Erro: "+e.getMessage());
            return false;
        }

    }

    public static void getFuncionario() throws SQLException {
        String sql = "SELECT * FROM Funcionario";
        PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            java.sql.Date dtNascimento = rs.getDate("dt_nascimento");
            String cpf = rs.getString("cpf");
            double salario = rs.getDouble("salario");
            String cargo = rs.getString("cargo");

            System.out.println("ID: " + id + ", Nome: " + nome + ", Data Nascimento: " + dtNascimento
                    + ", CPF: " + cpf + ", Salário: " + salario + ", Cargo: " + cargo);
        }

        rs.close();
        ps.close();

    }

    public static void getFuncionarioALL(int idFuncioanrio) throws SQLException {
        String sql = "SELECT * FROM Funcionario where id = ?";
        PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);
        ps.setInt(1, idFuncioanrio);

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            java.sql.Date dtNascimento = rs.getDate("dt_nascimento");
            String cpf = rs.getString("cpf");
            double salario = rs.getDouble("salario");
            String cargo = rs.getString("cargo");

            System.out.println("ID: " + id + ", Nome: " + nome + ", Data Nascimento: " + dtNascimento
                    + ", CPF: " + cpf + ", Salário: " + salario + ", Cargo: " + cargo);
        }

        rs.close();
        ps.close();

    }

    public boolean AtualiarFuncionario(int id, String nome, double salario, String cargo) throws SQLException {
        StringBuilder sql = new StringBuilder("UPDATE funcionario SET ");
        List<Object> params = new ArrayList<>();

        if (nome != null) {
            sql.append("nome = ?, ");
            params.add(nome);
        }
        if (salario > 0) {
            sql.append("salario = ?, ");
            params.add(salario);
        }
        if (cargo != null) {
            sql.append("cargo = ?, ");
            params.add(cargo);
        }

        if (params.isEmpty()) {
            return false;
        }
        sql.setLength(sql.length() - 2);

        sql.append("WHERE ID = ?");
        params.add(id);

        try (PreparedStatement ps = Conexao.getConnection().prepareStatement(sql.toString())) {
            for (int i = 0; i < params.size(); i++) {
                ps.setObject(i + 1, params.get(i));
            }
            int linhas = ps.executeUpdate();
            return true;
        }
    }
    
    public static List<Funcionario>verificaExistFuncionarios() throws SQLException {
        List<Funcionario>funcionarios = new ArrayList<>();
        String sql = "SELECT * FROM Funcionario";
        PreparedStatement ps = Conexao.getConnection().prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            java.sql.Date dtNascimento = rs.getDate("dt_nascimento");
            String cpf = rs.getString("cpf");
            double salario = rs.getDouble("salario");
            String cargo = rs.getString("cargo");
            
            LocalDate dtnas = dtNascimento.toLocalDate();
            funcionarios.add(new Funcionario(salario, cargo, id, nome, cpf,dtnas));
        }

        rs.close();
        ps.close();
        
        return funcionarios;
    }


}

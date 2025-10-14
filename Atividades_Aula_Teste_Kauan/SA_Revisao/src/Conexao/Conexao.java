
package Conexao;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
    
     private static final String URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection getConnection() {
        
        Connection conn = null;
        try {
           
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Erro ao conectar: " + e.getMessage());
        }
        return conn;
    }
    public static void main(String[] args) {
        
    }
}

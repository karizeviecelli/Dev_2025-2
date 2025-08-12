import java.sql.*;
import java.util.Scanner;

public class PetShopCRUD {

    private static final String URL = "jdbc:mysql://localhost:3306/banco_blupet";
    private static final String USER = "root";
    private static final String SENHA = "";

    private static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL, USER, SENHA);
    }

    private static void inserirPet(String nome, String tipo, int idade) {
        String sql = "INSERT INTO pets (nome, tipo, idade) VALUES (?, ?, ?)";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, tipo);
            stmt.setInt(3, idade);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Pet inserido com sucesso!");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao inserir pet: " + e.getMessage());
        }
    }

    private static void listarPets() {
        String sql = "SELECT * FROM pets";

        try (Connection conn = conectar();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            System.out.println("ID | Nome       | Tipo     | Idade");
            System.out.println("-------------------------------------");

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                String tipo = rs.getString("tipo");
                int idade = rs.getInt("idade");

                System.out.printf("%-3d| %-10s| %-9s| %d\n", id, nome, tipo, idade);
            }

        } catch (SQLException e) {
            System.out.println("Erro ao listar pets: " + e.getMessage());
        }
    }

    private static void atualizarPet(int id, String nome, String tipo, int idade) {
        String sql = "UPDATE pets SET nome = ?, tipo = ?, idade = ? WHERE id = ?";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, nome);
            stmt.setString(2, tipo);
            stmt.setInt(3, idade);
            stmt.setInt(4, id);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Pet atualizado com sucesso!");
            } else {
                System.out.println("Pet com ID " + id + " não encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao atualizar pet: " + e.getMessage());
        }
    }

    private static void deletarPet(int id) {
        String sql = "DELETE FROM pets WHERE id = ?";

        try (Connection conn = conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                System.out.println("Pet deletado com sucesso!");
            } else {
                System.out.println("Pet com ID " + id + " não encontrado.");
            }
        } catch (SQLException e) {
            System.out.println("Erro ao deletar pet: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n=== Pet Shop CRUD ===");
            System.out.println("1 - Inserir pet");
            System.out.println("2 - Listar pets");
            System.out.println("3 - Atualizar pet");
            System.out.println("4 - Deletar pet");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = sc.nextInt();
            sc.nextLine(); // limpar buffer

            switch (opcao) {
                case 1:
                    System.out.print("Nome: ");
                    String nome = sc.nextLine();
                    System.out.print("Tipo: ");
                    String tipo = sc.nextLine();
                    System.out.print("Idade: ");
                    int idade = sc.nextInt();
                    sc.nextLine();

                    inserirPet(nome, tipo, idade);
                    break;

                case 2:
                    listarPets();
                    break;

                case 3:
                    System.out.print("ID do pet para atualizar: ");
                    int idAtualizar = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();
                    System.out.print("Novo tipo: ");
                    String novoTipo = sc.nextLine();
                    System.out.print("Nova idade: ");
                    int novaIdade = sc.nextInt();
                    sc.nextLine();

                    atualizarPet(idAtualizar, novoNome, novoTipo, novaIdade);
                    break;

                case 4:
                    System.out.print("ID do pet para deletar: ");
                    int idDeletar = sc.nextInt();
                    sc.nextLine();

                    deletarPet(idDeletar);
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}

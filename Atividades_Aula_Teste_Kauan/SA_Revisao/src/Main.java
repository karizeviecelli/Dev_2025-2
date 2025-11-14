
import DAO.FuncionarioDAO;
import Model.Funcionario;
import Services.FuncionarioService;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        FuncionarioService fs = new FuncionarioService();
        int opcao = 10;

        do {
            try {
                System.out.println("\n===== MENU FUNCIONÁRIOS =====");
                System.out.println("1 - Adicionar funcionário");
                System.out.println("2 - Listar todos");
                System.out.println("3 - Buscar por ID");
                System.out.println("4 - Atualizar funcionário");
                System.out.println("5 - Remover funcionário");
                System.out.println("0 - Sair");
                System.out.print("Escolha: ");
                opcao = sc.nextInt();
                
                switch (opcao) {
                    case 1 ->
                        fs.adicionarFuncionario();
                    case 2 ->
                        fs.listarFuncionarios();
                    case 3 ->
                        fs.buscarFuncionario();
                    case 4 ->
                        fs.atualizarFuncionario();
                    case 5 ->
                        fs.removerFuncionario();
                    case 0 ->
                        System.out.println("Saindo...");
                    default ->
                        System.out.println("Op?ão inválida!");
                }

            } catch (InputMismatchException e) {
                System.out.println("Opcao incorreta.Digite apenas numeros ");
                sc.nextLine();
            } catch (SQLException e) {
                System.out.println("Erro no banco de dados: " + e.getMessage());
                sc.nextLine();
            }
        } while (opcao != 0);
    }

}

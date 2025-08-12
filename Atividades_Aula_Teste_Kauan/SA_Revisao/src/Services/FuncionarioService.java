package Services;

import DAO.FuncionarioDAO;
import Model.Funcionario;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class FuncionarioService {

    static Scanner sc = new Scanner(System.in);

    public static boolean adicionarFuncionario() throws SQLException {
        System.out.println("\n=== CADASTRAR FUNCION�RIO ===");

        String nome;
        while (true) {
            System.out.print("Nome: ");
            nome = sc.nextLine().trim();
            if (nome.length() >= 3) {
                break;
            }
            System.err.println("Nome deve ter pelo menos 3 caracteres.");
        }

        LocalDate dtNasc;
        while (true) {
            System.out.print("Data de nascimento (yyyy-MM-dd): ");
            String dataStr = sc.nextLine();
            try {
                dtNasc = LocalDate.parse(dataStr);
                if (dtNasc.isAfter(LocalDate.now())) {
                    System.err.println("Data de nascimento n�o pode ser no futuro.");
                    continue;
                }
                int idade = LocalDate.now().getYear() - dtNasc.getYear();
                if (idade < 14) {
                    System.err.println("Funcion�rio deve ter pelo menos 14 anos.");
                    continue;
                }
                break;
            } catch (Exception e) {
                System.err.println("Data inv�lida. Use o formato yyyy-MM-dd.");
            }
        }

        String cpf;
        while (true) {
            System.out.print("CPF (somente n�meros): ");
            cpf = sc.nextLine().replaceAll("\\D", "");
            if (cpf.length() == 11) {
                break;
            }
            System.err.println("CPF inv�lido.");
        }

        double salario;
        while (true) {
            try {
                System.out.print("Sal�rio: ");
                salario = Double.parseDouble(sc.nextLine());
                if (salario > 0) {
                    break;
                }
                System.err.println("Sal�rio deve ser maior que zero.");
            } catch (NumberFormatException e) {
                System.err.println("Valor inv�lido para sal�rio.");
            }
        }

        String cargo;
        while (true) {
            System.out.print("Cargo: ");
            cargo = sc.nextLine().trim();
            if (!cargo.isEmpty()) {
                break;
            }
            System.err.println(" Cargo n�o pode ser vazio.");
        }

        Funcionario funcionario = new Funcionario(nome, cpf, dtNasc, salario, cargo);
        FuncionarioDAO.create(funcionario);

        return true;
    }

    public static void listarFuncionarios() throws SQLException {
        FuncionarioDAO dao = new FuncionarioDAO();
        if (dao.verificaExistFuncionarios().size() > 0) {
            System.out.println("\n=== LISTA DE FUNCION�RIOS ===");
            FuncionarioDAO.getFuncionario();
        } else {
            System.out.println("nenhum funcionario cadastrado");
        }
    }

    public static void buscarFuncionario() throws SQLException {
        FuncionarioDAO dao = new FuncionarioDAO();
        if (dao.verificaExistFuncionarios().size() > 0) {
            System.out.print("\nDigite o ID do funcion�rio: ");
            int id = Integer.parseInt(sc.nextLine());
            FuncionarioDAO.getFuncionarioALL(id);
        } else {
            System.out.println("nenhum funcionario cadastrado");
        }

    }

    public static void atualizarFuncionario() throws SQLException {
        FuncionarioDAO dao = new FuncionarioDAO();
        if (dao.verificaExistFuncionarios().size() > 0) {
            System.out.println("\n=== ATUALIZAR FUNCION�RIO ===");
            System.out.print("ID: ");
            int id = Integer.parseInt(sc.nextLine());

            System.out.print("Novo nome (ou deixe em branco): ");
            String nome = sc.nextLine();
            if (nome.isBlank()) {
                nome = null;
            }

            System.out.print("Novo sal�rio (ou 0 para n�o alterar): ");
            double salario = Double.parseDouble(sc.nextLine());

            System.out.print("Novo cargo (ou deixe em branco): ");
            String cargo = sc.nextLine();
            if (cargo.isBlank()) {
                cargo = null;
            }

            if (dao.AtualiarFuncionario(id, nome, salario, cargo));
            System.out.println("Usuario atualizado com sucesso");
        } else {
            System.out.println("Nenhum usuario cadastrado");
        }
    }

    public static void removerFuncionario() throws SQLException {
        FuncionarioDAO dao = new FuncionarioDAO();
        if (dao.verificaExistFuncionarios().size() > 0) {

            while (true) {
                try {
                    System.out.print("\nDigite o ID para remover: ");
                    int id = Integer.parseInt(sc.nextLine());
                    if (id <= 0) {
                        System.out.println("Id digitada errada");
                        continue;
                    } else {
                        if (!FuncionarioDAO.remove(id)) {
                            continue;
                        } else {
                            break;
                        }

                    }

                } catch (Exception e) {
                    System.out.println("Erro: " + e);
                    continue;
                }

            }
        } else {
            System.out.println("Nenhum usuario cadastrado");
        }
    }

}

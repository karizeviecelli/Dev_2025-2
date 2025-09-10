import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Cofrinho cofrinho = new Cofrinho();

        int opcao;
        do {
            System.out.println("\n=== MENU COFRINHO ===");
            System.out.println("1. Adicionar moeda");
            System.out.println("2. Listar moedas");
            System.out.println("3. Ver total em reais");
            System.out.println("0. Sair");
            System.out.print("Escolha: ");
            opcao = sc.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Qual moeda deseja adicionar?");
                    System.out.println("1 - Real | 2 - Dólar | 3 - Euro");
                    int tipo = sc.nextInt();
                    System.out.print("Digite o valor: ");
                    double valor = sc.nextDouble();

                    switch (tipo) {
                        case 1:
                            cofrinho.adicionar(new Real(valor));
                            break;
                        case 2:
                            cofrinho.adicionar(new Dolar(valor));
                            break;
                        case 3:
                            cofrinho.adicionar(new Euro(valor));
                            break;
                        default:
                            System.out.println("Opção inválida!");
                    }
                    break;

                case 2:
                    cofrinho.listar();
                    break;

                case 3:
                    System.out.println("Total em reais: " + cofrinho.calcularTotalEmReais());
                    break;

                case 0:
                    System.out.println("Saindo do cofrinho... até mais!");
                    break;

                default:
                    System.out.println("Opção inválida!");
            }

        } while (opcao != 0);

        sc.close();
    }
}
